package org.grubentr.day4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRangePair {

    @Test
    public void shouldFullyOverlap() {
        RangePair sut = RangePair.fromString("6-6,4-6");

        Assertions.assertTrue(sut.fullyOverlaps());
    }
}
