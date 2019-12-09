package chapter9;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a show that consists of the screening of a single movie.
 */

public class JoshMovie implements Show {

    //Turn class Movie into a Flyweight class with lazily-instantiated flyweights where the flyweight store is a Map<String, Movie> and the key is the title (assumed to be unique for this exercise). Use Map.computeIfAbsent with a lambda expression in the implementation of your flyweight object accessor method.
    private static Map<String, JoshMovie> FLYWEIGHT = new HashMap<String, JoshMovie>();

    public static JoshMovie getMovie(String pTitle, int pYear, int pTime) {
        return FLYWEIGHT.computeIfAbsent(pTitle, k -> new JoshMovie(pTitle, pYear, pTime));
    }

    //It works :)
    public static void main(String[] args) {
        JoshMovie.getMovie("test", 0, 20);
        System.out.println(FLYWEIGHT);
        JoshMovie.getMovie("foo", 1, 30);
        System.out.println(FLYWEIGHT);
        JoshMovie.getMovie("foo", 1, 30);
        System.out.println(FLYWEIGHT);
    }

    private String aTitle;
    private int aYear;
    private int aRunningTime;

    /**
     * @param pTitle The title of the movie
     * @param pYear The release year of the movie
     * @param pTime The running time of the movie.
     */
    private JoshMovie(String pTitle, int pYear, int pTime) {
        aTitle = pTitle;
        aYear = pYear;
        aRunningTime = pTime;
    }

    public int year() {
        return aYear;
    }

    @Override
    public String description() {
        return String.format("[%s (%d): %d minutes]", aTitle, aYear, aRunningTime);
    }

    public String title() {
        return aTitle;
    }

    @Override
    public int time() {
        return aRunningTime;
    }

    public String toString() {
        return description();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + aRunningTime;
        result = prime * result + ((aTitle == null) ? 0 : aTitle.hashCode());
        result = prime * result + aYear;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        JoshMovie other = (JoshMovie) obj;
        if (aRunningTime != other.aRunningTime)
            return false;
        if (aTitle == null) {
            if (other.aTitle != null)
                return false;
        } else if (!aTitle.equals(other.aTitle))
            return false;
        if (aYear != other.aYear)
            return false;
        return true;
    }
}