package josh_chapter1;

public class JoshTwelveDaysIterative {

    static String[] DAYS = { "first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth",
            "tenth", "eleventh", "twelfth" };

    static String[] GIFTS = { "a partridge in a pear tree", "two turtle doves", "three French Hens",
            "four Calling Birds", "five Golden Rings", "six Geese a Laying", "seven Swans a Swimming",
            "eight Maids a Milking", "nine Ladies Dancing", "ten Lords a Leaping", "eleven Pipers Piping",
            "twelve Drummers Drumming" };

    //Exercise 1: Rewrite TwelveDays in an iterative style, as opposed to recursive.
    static String poemIterative() {

        String poem = "";

        for (int i = 0; i < DAYS.length; i++) {
            poem += "On the " + DAYS[i] + " day of Christmas, my true love gave to me...\n";
            for (int j = 0; j <= i; j++) {
                poem += GIFTS[j] + "\n";
            }
            poem += "\n";
        }

        return poem;
    }

    public static void main(String[] args) {
        System.out.println(poemIterative());
    }

}