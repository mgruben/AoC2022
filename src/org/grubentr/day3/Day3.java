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
        long sum = 0L;
        for (List<String> groupString : Tokenizer.toGroups(input)) {
            Group group = new Group(groupString.get(0),
                    groupString.get(1),
                    groupString.get(2));
            sum += Priority.getPriority(group.getBadge());
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(part1(Data.input));
        System.out.println(part2(Data.input));
    }
}
