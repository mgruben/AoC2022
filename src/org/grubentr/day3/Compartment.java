package org.grubentr.day3;

class Compartment {
    private long[] items;

    private int charToIndex(char c) {
        if (c <= 'Z') return c - 'A';
        else return c - 'a' + 26;
    }

    private char indexToChar(int i) {
        if (i < 26) return (char) (i + 'A');
        else return (char) (i + 'a' - 26);
    }

    public Compartment(String itemString) {
        items = new long[52];
        for (Character c : itemString.toCharArray()) {
            items[charToIndex(c)] += 1;
        }
    }

    public long numberOf(char c) {
        return items[charToIndex(c)];
    }

    public String getOverlap(Compartment other) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 52; i++) {
            if (items[i] > 0 && other.numberOf(indexToChar(i)) > 0) {
                sb.append(indexToChar(i));
            }
        }
        return sb.toString();
    }
}
