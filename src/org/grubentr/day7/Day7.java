package org.grubentr.day7;

import java.util.ArrayList;

public class Day7 {

    public static long part1(String input) {
        ShellReader sr = new ShellReader();
        input.lines().forEach(sr::parse);

        Dir root = sr.getRoot();
        root.calcSizes();

        return TreeSpider.findDir(new ArrayList<>(), root, dir -> dir.size() <= 100000L)
                .stream()
                .mapToLong(Dir::size)
                .sum();
    }

    public static void main(String[] args) {
        System.out.println(part1(Data.input));
    }
}
