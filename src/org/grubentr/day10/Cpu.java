package org.grubentr.day10;

import java.util.Iterator;

public class Cpu {
    private long x = 1;
    private int cycle;
    private Instruction current;
    private Iterator<Instruction> instructions;

    public void program(Iterator<Instruction> instructions) {
        this.instructions = instructions;
        if (this.instructions.hasNext()) {
            current = instructions.next();
        }
    }

    public void tick() {
        cycle++;
        if (current != null) {
            current.tick();
            if (current.getDuration() == 0) {
                perform();
            }
        }
    }

    public void tick(int cycles) {
        for (int i = 0; i < cycles; i++) tick();
    }

    public void tickUntil(int cycleCount) {
        while (cycle < cycleCount) tick();
    }

    private void perform() {
        if (current == null) {
            throw new RuntimeException("Asked to perform an instruction, but don't have one!");
        }
        if (current.getDuration() != 0) {
            throw new RuntimeException("Asked to perform an instruction but its duration is "
                    + current.getDuration());
        }
        x = current.apply(x);

        current = instructions.hasNext() ? instructions.next() : null;
    }

    public long getX() {
        return x;
    }

    public int getCycle() {
        return cycle;
    }

    public boolean hasNext() {
        return current != null;
    }
}
