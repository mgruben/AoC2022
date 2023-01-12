package org.grubentr.day10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestInstruction {

    @Test
    public void tickShouldDecrement() {
        // Testing an arbitrary new implementation should test all implementations
        Instruction instruction = new Instruction(1) {
            @Override
            public Integer apply(int i) {
                return null;
            }
        };

        Assertions.assertEquals(1, instruction.getDuration());
        instruction.tick();
        Assertions.assertEquals(0, instruction.getDuration());
    }
    @Test
    public void shouldNotAdd() {
        Instruction instruction = new Noop();
        Assertions.assertEquals(1, instruction.apply(1));
    }

    @Test
    public void shouldAdd() {
        Instruction instruction = new Addx(5);
        Assertions.assertEquals(10, instruction.apply(5));
    }

    @Test
    public void shouldSubtract() {
        Instruction instruction = new Addx(-5);
        Assertions.assertEquals(-2, instruction.apply(3));
    }

    @Test
    public void oneNoopShouldEqualAnother() {
        Assertions.assertEquals(new Noop(), new Noop());
    }

    @Test
    public void addxShouldEqual() {
        Assertions.assertEquals(new Addx(44), new Addx(44));
    }

    @Test
    public void addxShouldNotEqual() {
        Assertions.assertNotEquals(new Addx(1), new Addx(2));
    }
}
