package org.grubentr.day10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCrt {
    @Test
    public void shouldBeALine() {
        String expected = """
                ..................###...................
                ..................###...................
                ..................###...................
                ..................###...................
                ..................###...................
                ..................###...................
                """;

        Crt crt = new Crt(() -> 19);
        crt.tick(240);

        Assertions.assertEquals(expected, crt.toString());
    }

    @Test
    public void extraCyclesShouldntChangeImage() {
        String expected = """
                ..................###...................
                ..................###...................
                ..................###...................
                ..................###...................
                ..................###...................
                ..................###...................
                """;

        Crt crt = new Crt(() -> 19);
        crt.tick(499);

        Assertions.assertEquals(expected, crt.toString());
    }

    @Test
    public void allPixelsShouldBeOn() {
        String expected = """
                ########################################
                ########################################
                ########################################
                ########################################
                ########################################
                ########################################
                """;

        class ZeroToThirtyNineCounter {
            private int x;
            public int get() {
                int ans = x;
                x = (x + 1) % 40;
                return ans;
            }
        }

        ZeroToThirtyNineCounter c = new ZeroToThirtyNineCounter();
        Crt crt = new Crt(c::get);
        crt.tick(240);

        Assertions.assertEquals(expected, crt.toString());
    }

    @Test
    public void allPixelsShouldBeOff() {
        String expected = """
                ........................................
                ........................................
                ........................................
                ........................................
                ........................................
                ........................................
                """;

        Crt crt = new Crt(() -> 109);
        crt.tick(240);

        Assertions.assertEquals(expected, crt.toString());
    }
}
