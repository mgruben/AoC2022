package org.grubentr.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Tokenizer {
    private static final Map<String, Shape> toShapePart1 = Map.of("A", Shape.Rock,
            "B", Shape.Paper,
            "C", Shape.Scissors,
            "X", Shape.Rock,
            "Y", Shape.Paper,
            "Z", Shape.Scissors);

    private static final Map<Shape, Shape> toWin = Map.of(
            Shape.Rock, Shape.Paper,
            Shape.Paper, Shape.Scissors,
            Shape.Scissors, Shape.Rock
    );

    private static final Map<Shape, Shape> toLose = Map.of(
            Shape.Rock, Shape.Scissors,
            Shape.Paper, Shape.Rock,
            Shape.Scissors, Shape.Paper
    );

    private static Match lineToMatchPart1(String line) {
        String[] halves = line.split(" ");
        return new Match(toShapePart1.get(halves[0]), toShapePart1.get(halves[1]));
    }

    public static List<Match> tokenizePart1(String input) {
        List<Match> matches = new ArrayList<>();

        return input.lines().map(Tokenizer::lineToMatchPart1).collect(Collectors.toList());
    }

    private static Match lineToMatchPart2(String line) {
        String[] halves = line.split(" ");
        Shape opponent = toShapePart1.get(halves[0]);
        Shape you = switch (halves[1]) {
            case "X" -> toLose.get(opponent);
            case "Y" -> opponent;
            case "Z" -> toWin.get(opponent);
            default -> throw new RuntimeException("Unexpected input " + halves[1]);
        };
        return new Match(opponent, you);
    }

    public static List<Match> tokenizePart2(String input) {
        return input.lines().map(Tokenizer::lineToMatchPart2).collect(Collectors.toList());
    }
}
