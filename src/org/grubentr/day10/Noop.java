package org.grubentr.day10;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
public class Noop extends Instruction {
    public Noop() {
        super(1);
    }
    @Override
    public Long apply(long i) {
        return i;
    }
}
