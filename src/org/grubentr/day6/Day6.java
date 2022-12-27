package org.grubentr.day6;

public class Day6 {
    public static int findStartOfMessageMarker(int windowSize) {
        CharacterWindow characterWindow = new CharacterWindow(Data.input, windowSize);

        while (characterWindow.canAdvance() && characterWindow.getNumUnique() != windowSize) {
            characterWindow.advance();
        }

        return characterWindow.getNumCharactersProcessed();
    }

    public static int part1() {
        return findStartOfMessageMarker(4);
    }

    public static int part2() {
        return findStartOfMessageMarker(14);
    }

    public static void main(String[] args) {
        System.out.println(part1());
        System.out.println(part2());
    }
}
