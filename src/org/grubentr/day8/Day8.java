package org.grubentr.day8;

public class Day8 {
    public static int part1(String input) {
        Grid grid = new Grid(Tokenizer.fromString(input));
        return grid.getNumVisible();
    }

    public static void main(String[] args) {
        System.out.println(part1(Data.input));
    }
}
