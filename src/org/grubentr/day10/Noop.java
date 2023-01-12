package org.grubentr.day10;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
public class Noop extends Instruction {
    public Noop() {
        super(0);
    }
    @Override
    public Integer apply(int i) {
        return i;
    }
}
