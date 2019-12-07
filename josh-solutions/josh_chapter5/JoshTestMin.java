package josh_chapter5;

import java.lang.Math;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class JoshTestMin {

    @Test
    public void testMin_FirstSmaller() {

        int x = 0;
        int y = 1;

        assertEquals(x, Math.min(x, y));
    }

    @Test
    public void testMin_SecondSmaller() {

        int x = 1;
        int y = 0;

        assertEquals(y, Math.min(x, y));
    }

    @Test
    public void testMin_Equal() {

        int x = 1;
        int y = 1;

        assertEquals(1, Math.min(x, y));
    }

    public static void main(String[] args) {
        JoshTestMin tm = new JoshTestMin();
        tm.testMin_FirstSmaller();
        tm.testMin_SecondSmaller();
        tm.testMin_Equal();

    }

}