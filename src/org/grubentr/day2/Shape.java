package org.grubentr.day2;

public enum Shape {
    Rock(1),
    Paper(2),
    Scissors(3);

    public final int points;
    Shape(int points) {
        this.points = points;
    }

    public boolean beats(Shape other) {
        return ((this == Rock && other == Scissors)
        || (this == Scissors && other == Paper)
        || (this == Paper && other == Rock));
    }
}
