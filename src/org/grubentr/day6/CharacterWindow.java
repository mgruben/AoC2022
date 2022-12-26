package org.grubentr.day6;

public class CharacterWindow {
    private int head, tail, numUnique;
    private final String datastream;
    private final long[] characters;

    public CharacterWindow(String input, int windowSize) {
        characters = new long[26];
        head = 0;
        tail = 0;
        numUnique = 0;

        datastream = input;

        for (int i = 0; i < windowSize; i++) advanceHead();
    }

    public void advance() {
        advanceHead();
        advanceTail();
    }

    public boolean canAdvance() {
        return head < datastream.length();
    }

    public int getNumUnique() {
        return numUnique;
    }

    public int getNumCharactersProcessed() {
        return head;
    }

    private void advanceHead() {
        incr(datastream.charAt(head++));
    }

    private void advanceTail() {
        decr(datastream.charAt(tail++));
    }

    private void incr(char c) {
        if (characters[charToIndex(c)]++ == 0) numUnique++;
    }

    private void decr(char c) {
        if (--characters[charToIndex(c)] == 0) numUnique--;
    }

    private int charToIndex(char c) {
        return c - 'a';
    }
}
