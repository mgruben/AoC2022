package org.grubentr.day3;


import java.util.List;

public class Day3 {

    public static long part1(String input) {
        return input
                .lines()
                .map(Rucksack::new)
                .map(Rucksack::getOverlap)
                .flatMapToInt(String::chars)
                .mapToObj(i -> (char) i)
                .map(Priority::getPriority)
                .reduce(Long::sum)
                .orElse(0L);
    }

    public static long part2(String input) {
        return Tokenizer.toGroups(input).stream()
                .map(Group::new)
                .map(Group::getBadge)
                .map(Priority::getPriority)
                .reduce(Long::sum)
                .orElse(0L);
    }

    public static void main(String[] args) {
        System.out.println(part1(Data.input));
        System.out.println(part2(Data.input));
    }
}
