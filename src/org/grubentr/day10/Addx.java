package org.grubentr.day10;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
public class Addx extends Instruction {
    int arg;

    public Addx(int arg) {
        super(2);
        this.arg = arg;
    }
    @Override
    public Long apply(long i) {
        return i + arg;
    }

    @Override
    public String toString() {
        return "addx " + arg;
    }
}
