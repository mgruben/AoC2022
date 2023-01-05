package org.grubentr.day9;

import java.util.HashSet;
import java.util.Set;

public class Simulator {
    /*
    By definition, the tail's diff from 17 is (0, 0).
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
    private final Coord start;
    private Coord head;
    private Coord tail;

    public Simulator() {
        start = new Coord(0, 0);
        head = new Coord(0, 0);
        tail = new Coord(0, 0);

        visited.add(start);
    }

    public void update(Coord diff) {
        head = head.plus(diff);
        updateTail(tail.diff(head));
        visited.add(tail);
    }

    public Set<Coord> getVisited() {
        return new HashSet<>(visited);
    }

    private void updateTail(Coord diff) {
        if (diff.equals(C01) || diff.equals(C02)) {
            tail = tail.plus(C13);
        } else if (diff.equals(C03)) {
            tail = tail.plus(C14);
        } else if (diff.equals(C04) || diff.equals(C05)) {
            tail = tail.plus(C15);
        } else if (diff.equals(C06)) {
            tail = tail.plus(C18);
        } else if (diff.equals(C07) || diff.equals(C08)) {
            tail = tail.plus(C21);
        } else if (diff.equals(C09)) {
            tail = tail.plus(C20);
        } else if (diff.equals(C10) || diff.equals(C11)) {
            tail = tail.plus(C19);
        } else if (diff.equals(C12)) {
            tail = tail.plus(C16);
        } else if (diff.equals(C13) || diff.equals(C14) || diff.equals(C15)
                || diff.equals(C16) || diff.equals(C17) || diff.equals(C18)
                || diff.equals(C19) || diff.equals(C20) || diff.equals(C21)) {
            // do nothing; tail doesn't update
        } else {
            throw new RuntimeException("Got unexpected diff: " + diff);
        }
    }
}
