package chapter6;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class JoshCompositeShow implements Show {
    private List<Show> shows = new ArrayList<Show>();

    public JoshCompositeShow(Show... shows) {
        if (shows.length < 2 || shows.length > 5) {
            throw new IllegalArgumentException();
        }
        this.shows.addAll(Arrays.asList(shows));
    }

    public JoshCompositeShow copy() {
        List<Show> copies = new ArrayList<>();
        for (Show show : shows) {
            copies.add(show.copy());
        }
        return new JoshCompositeShow(copies.toArray(new Show[copies.size()]));
    }

    public int runningTime() {
        int runningTime = 0;
        for (Show show : shows) {
            runningTime += show.runningTime();
        }
        return runningTime;
    }

    public String description() {
        String description = "";
        for (Show show : shows) {
            description += show.description() + "\n";
        }
        return description;
    }

}