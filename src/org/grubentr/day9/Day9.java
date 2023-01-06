package org.grubentr.day9;

import java.util.Map;
import java.util.Scanner;

public class Day9 {
    private static final Map<String, Coord> diffMap = Map.of(
            "R", Coord.RIGHT,
            "L", Coord.LEFT,
            "U", Coord.UP,
            "D", Coord.DOWN
    );

    private static int solver(String input, int numKnots) {
        Simulator sim = new Simulator(numKnots);
        Scanner sc = new Scanner(input);

        while (sc.hasNext()) {
            Coord direction = diffMap.get(sc.next());
            int count = sc.nextInt();

            for (int i = 0; i < count; i++) {
                System.out.printf("Going %s%n", direction);
                sim.update(direction);
            }
        }

        return sim.getVisited().size();
    }

    public static int part1(String input) {
        return solver(input, 2);
    }

    public static int part2(String input) {
        return solver(input, 10);
    }

    public static void main(String[] args) {
        System.out.println(part1(Data.input));
        System.out.println(part2(Data.input));
    }
}
