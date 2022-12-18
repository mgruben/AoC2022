package org.grubentr.day2;

import java.util.List;

public class Day2 {
    public long scoreMatches(List<Match> matches) {
        long score = 0;
        for (Match match : matches) {
            score += match.score();
        }
        return score;
    }
}
