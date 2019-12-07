package josh_chapter5;

import java.lang.Math;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class JoshTestCos {

    private final double DELTA = 0.0001;

    @Test
    public void testCos_Within1and2PI() {
        assertEquals(-1.0, Math.cos(Math.PI), DELTA);
        assertEquals(1.0, Math.cos(2 * Math.PI), DELTA);
    }

    //unfinished
}