package org.grubentr.day4;

public record Range(long start, long end) {

    public static Range fromRangeString(String rangeString) {
        String[] range = rangeString.split("-");
        return new Range(Long.parseLong(range[0]), Long.parseLong(range[1]));
    }
    public boolean contains(Range other) {
        return other.start >= this.start &&
                other.end <= this.end;
    }
}
