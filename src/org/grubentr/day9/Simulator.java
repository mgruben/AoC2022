package org.grubentr.day9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Simulator {
    /*
    By definition, a knot's diff from 17 is (0, 0).
    The other cases are enumerated as follows:

       02 03 04
    01 13 14 15 05
    12 16 17 18 06
    11 19 20 21 07
       10 09 08
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
    private final static Coord C13 = new Coord(-1, 1);
    private final static Coord C14 = new Coord(0, 1);
    private final static Coord C15 = new Coord(1, 1);
    private final static Coord C16 = new Coord(-1, 0);
    private final static Coord C17 = new Coord(0, 0);
    private final static Coord C18 = new Coord(1, 0);
    private final static Coord C19 = new Coord(-1, -1);
    private final static Coord C20 = new Coord(0, -1);
    private final static Coord C21 = new Coord(1, -1);

    private final Set<Coord> visited = new HashSet<>();
    private final List<Coord> knots = new ArrayList<>();

    public Simulator(int numKnots) {
        for (int i = 0; i < numKnots; i++) {
            knots.add(new Coord(0, 0));
        }

        visited.add(knots.get(knots.size() - 1));
    }

    public void update(Coord diff) {
        // The head behaves specially; update it apart from the rest
        Coord head = knots.get(0);
        head = head.plus(diff);
        knots.set(0, head);

        Coord next;
        for (int i = 1; i < knots.size(); i++) {
            next = knots.get(i);
            next = follow(next, next.diff(head));
            knots.set(i, next);
            head = next;
        }

        // After exiting the above for-loop, both `head` and `next`
        // point to the last Coord in the list.
        visited.add(head);
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
        } else if (diff.equals(C13) || diff.equals(C14) || diff.equals(C15)
                || diff.equals(C16) || diff.equals(C17) || diff.equals(C18)
                || diff.equals(C19) || diff.equals(C20) || diff.equals(C21)) {
            // This coordinate shouldn't change; return the same one
            return next;
        } else {
            throw new RuntimeException("Got unexpected diff: " + diff);
        }
    }
}
