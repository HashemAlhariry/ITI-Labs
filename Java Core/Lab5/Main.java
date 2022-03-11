import com.company.streams.City;
import com.company.streams.Country;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.stream.Collectors.reducing;

public class Main {

    public static void main(String[] args) {

        InMemoryWorldDao worldDao=	new InMemoryWorldDao();
        Set<String> allContinents=worldDao.getContinents();
        List<Country> countries=worldDao.findAllCountries();
        List<City> cities = worldDao.findAllCities();
        //highestPopulation(countries);
        //mostPopulatedCityByEachContinent(allContinents,worldDao);
        highestPopulatedCapital(countries,worldDao);

    }
        
    //• Find the highest populated city of each country
    public static void highestPopulation(List<Country> allCountries) {

        List<City> collect = allCountries.stream().map(Country::getCities)
                .peek(cities -> cities.stream().reduce(BinaryOperator.maxBy((a1, a2) -> a1.getPopulation() > a2.getPopulation() ? 1 : 0)))
                .flatMap(List::stream)
                .collect(Collectors.toList());

        for (City c: collect) {
            System.out.println(c.getName() +" "+c.getPopulation());
        }

        // Another Solution
        /*
        worldDao.findAllCountries().stream().forEach(country -> {
            System.out.println(worldDao.findCitiesByCountryCode(country.getCode()).stream().max(Comparator.comparingInt(City::getPopulation)));
        });
        */

    }


    //• Find the most populated city of each continent
    public static void mostPopulatedCityByEachContinent(Set<String> allContinents,InMemoryWorldDao worldDao) {


        // List of List of Countries for each continent
        List<List<Country>> contries= allContinents.stream().map(worldDao::findCountriesByContinent).collect(Collectors.toList());

        // getting max pop city  in each continent
        List<String> cities = contries.stream().map(list->{


                    Optional<City> temp = list.stream().map(country-> {
                        Optional<City> maxPopCity=worldDao.findCitiesByCountryCode(country.getCode()).stream().max(Comparator.comparingInt(City::getPopulation));
                        if(maxPopCity.isPresent())
                            return maxPopCity.get();
                        else
                            return null;
                    }).collect(Collectors.toList()).stream().filter(cc->cc!=null).max(Comparator.comparingInt(City::getPopulation));



                    if(temp.isPresent())
                        return temp.get();
                    else
                        return null;

                }
        ).filter(x->x!=null).map(c->c.getName()).collect(Collectors.toList());



        for (String s : cities){
            System.out.println(s);
        }





    }


    //• Find the highest populated capital city

    public static  void highestPopulatedCapital(List<Country> allCountries , InMemoryWorldDao worldDao){

        Optional<City> city= allCountries.stream()
                .map(Country::getCapital)
                .map(worldDao::findCityById)
                .filter(e -> e != null)
                .max(
                       Comparator.comparingInt(City::getPopulation)
                );
        if(city.isPresent()) {
            System.out.println(city.get().getName()+ " "+city.get().getPopulation());
        }
        else
        {
            System.out.println("Nothing found");
        }

    }







}





/*
   allContinents.stream().map(worldDao::findCountriesByContinent)
                .peek(countries -> countries.stream()
                        .map(Country::getCities)
                        .peek(cities -> cities.stream().reduce(BinaryOperator.maxBy((a1, a2) -> a1.getPopulation() > a2.getPopulation() ? 1 : 0)))
                        .flatMap(List::stream)
                        .collect(Collectors.toList())).collect(Collectors.toList());

                .peek(cities -> cities.stream().reduce(BinaryOperator.maxBy((a1, a2) -> a1.getPopulation() > a2.getPopulation() ? 1 : 0)))
                .flatMap(List::stream)
                .collect(Collectors.toList());
                
 */
