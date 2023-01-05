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

    public static int part1(String input) {
        Simulator sim = new Simulator();
        Scanner sc = new Scanner(input);

        while (sc.hasNext()) {
            Coord direction = diffMap.get(sc.next());
            int count = sc.nextInt();

            for (int i = 0; i < count; i++) {
                sim.update(direction);
            }
        }

        return sim.getVisited().size();
    }

    public static void main(String[] args) {
        System.out.println(part1(Data.input));
    }
}
