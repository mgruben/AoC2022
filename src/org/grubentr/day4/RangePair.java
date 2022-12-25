package org.grubentr.day4;

public class RangePair {
    private final Range a;
    private final Range b;

    public RangePair(Range first, Range second) {
        a = first;
        b = second;
    }

    public static RangePair fromString(String rangePairString) {
        String[] pair = rangePairString.split(",");
        return new RangePair(
                Range.fromRangeString(pair[0]),
                Range.fromRangeString(pair[1]));
    }

    public boolean fullyOverlaps() {
        return a.contains(b) || b.contains(a);
    }
}
