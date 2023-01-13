package org.grubentr.day10;

import java.util.function.LongFunction;

public abstract class Instruction implements LongFunction<Long> {
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
