package org.grubentr.day9;

/**
 * This class represents a(n integer) coordinate on a 2-dimensional plane.
 *
 * @param x The x value; positive is to the right.
 * @param y The y value; positive is up.
 */
public record Coord(int x, int y) {

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
