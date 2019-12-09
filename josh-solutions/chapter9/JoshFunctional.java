package chapter9;

import java.util.ArrayList;
import java.util.function.Predicate;

public class JoshFunctional {

    private static void exercise1() {
        //Consider a list of movies Write code to create a new `ArrayList` of all the movies, then use method `removeIf` of `ArrayList` to remove all movies produced before 1960.
        ArrayList<Movie> movies;

        // First, use an anonymous class as the explicit argument to `removeIf`.
        movies = new ArrayList<Movie>(Movies.movies());
        movies.removeIf(new Predicate<Movie>() {
            public boolean test(Movie movie) {
                return movie.year() < 1960;
            }
        });
        System.out.println(movies);

        //Once this works, replace the anonymous class with a lambda expression written as a block of statements, and with type parameter. 
        movies = new ArrayList<Movie>(Movies.movies());
        movies.removeIf((Movie movie) -> movie.year() < 1960);
        System.out.println(movies);

        //Finally, transform your lambda expression once again so that it is defined as an expression, has no type parameter or parentheses.
        movies = new ArrayList<Movie>(Movies.movies());
        movies.removeIf(movie -> movie.year() < 1960);
        System.out.println(movies);
    }

    public static void main(String[] args) {
        exercise1();
    }
}