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
    public Integer apply(int i) {
        return i + arg;
    }
}
