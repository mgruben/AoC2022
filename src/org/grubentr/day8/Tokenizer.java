package org.grubentr.day8;

public class Tokenizer {
    public static int[][] fromString(String input) {
        return input.lines()
                .map(line -> line.chars()
                        .map(c -> c - 48)
                        .toArray())
                .toArray(int[][]::new);
    }
}
