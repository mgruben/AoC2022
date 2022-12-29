package org.grubentr.day7;

import java.util.ArrayList;
import java.util.List;

public class Day7 {

    private static Dir init(String input) {
        ShellReader sr = new ShellReader();
        input.lines().forEach(sr::parse);

        Dir root = sr.getRoot();
        root.calcSizes();

        return root;
    }

    public static long part1(String input) {
        Dir root = init(input);

        return TreeSpider.findDir(new ArrayList<>(), root, dir -> dir.size() <= 100000L)
                .stream()
                .mapToLong(Dir::size)
                .sum();
    }

    public static long part2(String input) {
        Dir root = init(input);

        long unused = 70_000_000L - root.size();
        long needed = 30_000_000L - unused;

        List<Dir> dirsBiggerThanRoot = TreeSpider.findDir(new ArrayList<>(), root, dir -> dir.size() > needed);
        return dirsBiggerThanRoot.stream().mapToLong(Dir::size).sorted().findFirst().orElseThrow();
    }

    public static void main(String[] args) {
        System.out.println(part1(Data.input));
        System.out.println(part2(Data.input));
    }
}
