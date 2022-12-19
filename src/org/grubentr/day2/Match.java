package org.grubentr.day2;

public record Match(Shape s1, Shape s2) {
    public long score() {
        int winLossDraw = 0;
        if (s1 == s2) {
            winLossDraw = 3;
        } else if (s1.beats(s2)) {
            winLossDraw = 0;
        } else {
            winLossDraw = 6;
        }
        return winLossDraw + s2.points;
    }
}
