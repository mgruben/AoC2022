package org.grubentr.day1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.grubentr.day1.Data.input;

public class Day1 {
    public static Integer sumList(List<Integer> l) {
        return l.stream().reduce(0, Integer::sum);
    }
    public static Optional<Integer> getTopElf(String input) {
        List<List<Integer>> elfCalories = Tokenizer.tokenizeCalories(input);
        return elfCalories.stream()
                .map(Day1::sumList)
                .max(Integer::compare);
    }

    public static List<Integer> getTopThreeElves(String input) {
        List<List<Integer>> elfCalories = Tokenizer.tokenizeCalories(input);
        elfCalories.sort(Comparator.comparingInt(Day1::sumList));
        Collections.reverse(elfCalories);
        return elfCalories.stream()
                .map(Day1::sumList)
                .limit(3L)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(getTopThreeElves(input).stream().reduce(0, Integer::sum));
    }
}
