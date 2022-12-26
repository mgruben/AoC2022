package org.grubentr.day5;

public class day5 {
    public static String part1(String input) {
        return Tokenizer.fromInput(input).peekTops();
    }
    public static void main(String[] args) {
        System.out.println(part1(Data.input));
    }
}
