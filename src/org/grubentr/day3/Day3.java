package org.grubentr.day3;

import java.util.List;

public class Day3 {
    public static void main(String[] args) {
        List<Rucksack> rucksacks = Data.testInput
                .lines()
                .map(Rucksack::new)
                .toList();
    }
}
