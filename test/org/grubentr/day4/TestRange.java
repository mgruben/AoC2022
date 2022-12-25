package org.grubentr.day4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRange {
    @Test
    public void shouldNotContainNoOverlap() {
        Range a = new Range(2,4);
        Range b = new Range(6,8);

        Assertions.assertFalse(a.contains(b));
        Assertions.assertFalse(b.contains(a));
    }

    @Test
    public void shouldNotContainSomeOverlap() {
        Range a = new Range(5,7);
        Range b = new Range(7,9);

        Assertions.assertFalse(a.contains(b));
        Assertions.assertFalse(b.contains(a));
    }

    @Test
    public void oneShouldContainTheOther() {
        Range a = new Range(2,8);
        Range b = new Range(3,7);

        Assertions.assertTrue(a.contains(b));
        Assertions.assertFalse(b.contains(a));
    }

    @Test
    public void testParseFromRangeString() {
        Range expected = new Range(4, 11);
        Range actual = Range.fromRangeString("4-11");

        Assertions.assertEquals(expected, actual);
    }
}
