package org.grubentr.day6;

public class Day6 {
    public static int part1() {
        int windowSize = 4;

        CharacterWindow characterWindow = new CharacterWindow(Data.input, windowSize);

        while (characterWindow.canAdvance() && characterWindow.getNumUnique() != windowSize) {
            characterWindow.advance();
        }

        return characterWindow.getNumCharactersProcessed();
    }

    public static void main(String[] args) {
        System.out.println(part1());
    }
}
