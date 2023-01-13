package org.grubentr.day10;

public class Tokenizer {
    private static final String NOOP = "noop";
    public static Instruction toInstruction(String line) {
        if (line.equals(NOOP)) {
            return new Noop();
        } else {
            // "addx " is 5 characters.
            // Thus, the integer component of this operation
            // begins at index 5.
            return new Addx(Integer.parseInt(line.substring(5)));
        }
    }
}
