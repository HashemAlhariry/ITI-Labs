package gov.iti.jets.bean.annotation.required;

import org.springframework.beans.factory.annotation.Required;

public class SimpleMovieLister {
    private MovieFinder movieFinder;

    @Required
    public void setMovieFinder(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }
    public String getMovieFinderName (){
        return movieFinder.getMovieName();
    }
}
