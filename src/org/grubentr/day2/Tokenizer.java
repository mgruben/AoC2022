package org.grubentr.day2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Tokenizer {
    private static final Map<String, Shape> toShape = Map.of("A", Shape.Rock,
            "B", Shape.Paper,
            "C", Shape.Scissors,
            "X", Shape.Rock,
            "Y", Shape.Paper,
            "Z", Shape.Scissors);

    private static Match lineToMatch(String line) {
        String[] halves = line.split(" ");
        return new Match(toShape.get(halves[0]), toShape.get(halves[1]));
    }

    public static List<Match> tokenizeMatches(String input) {
        List<Match> matches = new ArrayList<>();

        return input.lines().map(Tokenizer::lineToMatch).collect(Collectors.toList());
    }
}
