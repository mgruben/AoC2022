package org.grubentr.day9;

/**
 * This class represents a(n integer) coordinate on a 2-dimensional plane.
 *
 * @param x The x value; positive is to the right.
 * @param y The y value; positive is up.
 */
public record Coord(int x, int y) {
    public static final Coord LEFT = new Coord(-1, 0);
    public static final Coord RIGHT = new Coord(1, 0);
    public static final Coord UP = new Coord(0, 1);
    public static final Coord DOWN = new Coord(0, -1);


    /**
     * The result of adding this and some other coordinate.
     *
     * @param other Another coordinate
     * @return (x1 + x2, y1 + y2)
     */
    public Coord plus(Coord other) {
        return new Coord(other.x() + this.x(), other.y() + this.y());
    }

    /**
     * The result of subtracting this coordinate <em>from</em> some other coordinate.
     *
     * @param other Another coordinate
     * @return (x2 - x1, y2 - y1)
     */
    public Coord diff(Coord other) {
        return new Coord(other.x() - this.x(), other.y() - this.y());
    }
}
