package org.grubentr.day8;

public class Day8 {
    public static int part1(String input) {
        Grid grid = new Grid(Tokenizer.fromString(input));
        return grid.getNumVisibleFromOutside();
    }

    public static long part2(String input) {
        Grid grid = new Grid(Tokenizer.fromString(input));
        return grid.getHighestScenicScore();
    }

    public static void main(String[] args) {
        System.out.println(part1(Data.input));
        System.out.println(part2(Data.input));
    }
}
