package org.grubentr.day10;

import java.util.function.IntFunction;

public abstract class Instruction implements IntFunction<Integer> {
    private int duration;

    Instruction(int duration) {
        this.duration = duration;
    }

    /**
     * Decrements this Instruction's duration
     */
    void tick() {
        duration--;
    }

    int getDuration() {
        return duration;
    }
}
