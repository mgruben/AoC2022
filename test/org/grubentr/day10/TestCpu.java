package org.grubentr.day10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.stream.Stream;

public class TestCpu {
    private Cpu sut;

    @BeforeEach
    public void setup() {
        sut = new Cpu();
    }

    @Test
    public void shouldHaveNextAfterInstantiation() {
        sut.program(Stream.of((Instruction) new Noop()).iterator());
        Assertions.assertTrue(sut.hasNext());
    }

    @Test
    public void cpuShouldStartAt1() {
        Assertions.assertEquals(1, sut.getX());
    }

    @Test
    public void noInstructionTicksShouldNotExplodeCpu() {
        sut.tick();
        sut.tick();
        sut.tick();
    }

    @Test
    public void noopShouldNotChangeX() {
        sut.program(Stream.of((Instruction) new Noop()).iterator());

        sut.tick();
        Assertions.assertEquals(1, sut.getX());
        sut.tick();
        Assertions.assertEquals(1, sut.getX());
    }

    @Test
    public void addxShouldChangeX() {
        Instruction addx = new Addx(10);

        sut.program(Stream.of((Instruction) addx).iterator());

        Assertions.assertEquals(2, addx.getDuration());

        sut.tick();
        // A 2-cycle instruction should not execute after 1 tick
        Assertions.assertEquals(1, sut.getX());

        // Each tick should decrement addx's duration
        Assertions.assertEquals(1, addx.getDuration());

        sut.tick();
        // But it should execute after 2
        Assertions.assertEquals(11, sut.getX());
        Assertions.assertEquals(0, addx.getDuration());
    }

    private Iterator<Instruction> fromString(String string) {
        return string.lines()
                .map(Tokenizer::toInstruction)
                .iterator();
    }

    @Test
    public void testTinyInput() {
        sut.program(fromString(Data.tinyInput));

        // noop
        sut.tick();
        Assertions.assertEquals(1, sut.getX());

        // addx 3
        sut.tick();
        Assertions.assertEquals(1, sut.getX());
        sut.tick();
        Assertions.assertEquals(4, sut.getX());

        // addx -5
        sut.tick();
        Assertions.assertEquals(4, sut.getX());
        sut.tick();
        Assertions.assertEquals(-1, sut.getX());
    }

    @Test
    public void shouldBeNegative1() {
        sut.program(fromString(Data.tinyInput));
        sut.tickUntil(5);
        Assertions.assertEquals(-1, sut.getX());
    }

    @Test
    public void testTestInput() {
        sut.program(fromString(Data.testInput));

        sut.tickUntil(19); // The 20th cycle
        Assertions.assertEquals(21, sut.getX());

        sut.tick(40); // 60th cycle
        Assertions.assertEquals(19, sut.getX());

        sut.tick(40); // 100th cycle
        Assertions.assertEquals(18, sut.getX());

        sut.tick(40); // 140th cycle
        Assertions.assertEquals(21, sut.getX());

        sut.tick(40); // 180th cycle
        Assertions.assertEquals(16, sut.getX());

        sut.tick(40); // 220th cycle
        Assertions.assertEquals(18, sut.getX());
    }
}
