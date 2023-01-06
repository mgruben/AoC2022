package org.grubentr.day9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Simulator {
    /*
    By definition, a knot's diff from 17 is (0, 0).
    The other cases are enumerated as follows:

    22 02 03 04 23
    01 13 14 15 05
    12 16 17 18 06
    11 19 20 21 07
    25 10 09 08 24
     */
    private final static Coord C01 = new Coord(-2, 1);
    private final static Coord C02 = new Coord(-1, 2);
    private final static Coord C03 = new Coord(0, 2);
    private final static Coord C04 = new Coord(1, 2);
    private final static Coord C05 = new Coord(2, 1);
    private final static Coord C06 = new Coord(2, 0);
    private final static Coord C07 = new Coord(2, -1);
    private final static Coord C08 = new Coord(1, -2);
    private final static Coord C09 = new Coord(0, -2);
    private final static Coord C10 = new Coord(-1, -2);
    private final static Coord C11 = new Coord(-2, -1);
    private final static Coord C12 = new Coord(-2, 0);

    // Diffs that indicate that the next knot shouldn't update
    private final static Coord C13 = new Coord(-1, 1);
    private final static Coord C14 = new Coord(0, 1);
    private final static Coord C15 = new Coord(1, 1);
    private final static Coord C16 = new Coord(-1, 0);
    private final static Coord C17 = new Coord(0, 0);
    private final static Coord C18 = new Coord(1, 0);
    private final static Coord C19 = new Coord(-1, -1);
    private final static Coord C20 = new Coord(0, -1);
    private final static Coord C21 = new Coord(1, -1);
    private final static Set<Coord> NO_OP_COORDS = Set.of(
            C13, C14, C15, C16, C17, C18, C19, C20, C21);

    // new possible diffs for part2
    private final static Coord C22 = new Coord(-2, 2);
    private final static Coord C23 = new Coord(2, 2);
    private final static Coord C24 = new Coord(2, -2);
    private final static Coord C25 = new Coord(-2, -2);

    private final Set<Coord> visited = new HashSet<>();
    private final List<Coord> knots = new ArrayList<>();

    public Simulator(int numKnots) {
        for (int i = 0; i < numKnots; i++) {
            knots.add(new Coord(0, 0));
        }

        // Visit the tail
        visited.add(knots.get(knots.size() - 1));
    }

    public void update(Coord startingDiff) {
        // The head behaves specially; update it apart from the rest
        Coord prev = knots.get(0);
        prev = prev.plus(startingDiff);
        knots.set(0, prev);

        Coord next;
        Coord diff;
        boolean visitedTail = true;
        for (int i = 1; i < knots.size(); i++) {
            next = knots.get(i);
            diff = next.diff(prev);

            // If the diff between prev and next is close enough,
            // neither this nor any subsequent knot will update; just break.
            if (NO_OP_COORDS.contains(diff)) {
                visitedTail = false;
                break;
            }

            next = follow(next, diff);
            knots.set(i, next);
            prev = next;
        }

        // Visit the tail
        if (visitedTail) visited.add(knots.get(knots.size() - 1));
    }

    public Set<Coord> getVisited() {
        return new HashSet<>(visited);
    }

    private Coord follow(Coord next, Coord diff) {
        if (diff.equals(C01) || diff.equals(C02)) {
            return next.plus(C13);
        } else if (diff.equals(C03)) {
            return next.plus(C14);
        } else if (diff.equals(C04) || diff.equals(C05)) {
            return next.plus(C15);
        } else if (diff.equals(C06)) {
            return next.plus(C18);
        } else if (diff.equals(C07) || diff.equals(C08)) {
            return next.plus(C21);
        } else if (diff.equals(C09)) {
            return next.plus(C20);
        } else if (diff.equals(C10) || diff.equals(C11)) {
            return next.plus(C19);
        } else if (diff.equals(C12)) {
            return next.plus(C16);
        } else if (diff.equals(C22)) {
            return next.plus(C13);
        } else if (diff.equals(C23)) {
            return next.plus(C15);
        } else if (diff.equals(C24)) {
            return next.plus(C21);
        } else if (diff.equals(C25)) {
            return next.plus(C19);
        } else if (NO_OP_COORDS.contains(diff)) {
            // This coordinate shouldn't change; return the same one
            return next;
        } else {
            throw new RuntimeException("Got unexpected diff: " + diff);
        }
    }
}
