import java.util.function.BinaryOperator;
import java.util.function.Function;

class ConvertTemp {

        public static void main(String[] args) {

                //(°C * 1.8) + 32
                int celsiusDegree = 16;
                Function<Integer, Double>  celsiusToFahrenheit = c -> (c* 1.8)+32;
                double fahrenheitDegree = celsiusToFahrenheit.apply(celsiusDegree);
                System.out.println(fahrenheitDegree);


                int number1=123456789;
                int number2=123456789;
                // why int can't compile .......
                BinaryOperator <Integer> binaryOperator =  (a , b) -> (a > b) ? 1 : (a == b) ? 0 : -1;
                Integer checker =binaryOperator.apply(number1,number2);
                System.out.println( checker);
                if(checker==0) System.out.println("Both are equals");


        }



}