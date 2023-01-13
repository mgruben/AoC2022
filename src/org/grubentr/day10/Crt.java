package org.grubentr.day10;

import java.util.function.LongSupplier;

public class Crt {
    private static final int WIDTH = 40;
    private static final int HEIGHT = 6;
    private final boolean[][] pixels = new boolean[WIDTH][HEIGHT];
    private int cycle;
    private final LongSupplier cursor;

    Crt(LongSupplier cursor) {
        this.cursor = cursor;
    }

    void tick() {
        long c = cursor.getAsLong();
        int i = cycle % WIDTH;
        int j = cycle / WIDTH;

        // Turns on if in the range; off if not
        pixels[i][j] = ((c - 1 <= i) && (i <= c + 1));

        cycle = (cycle + 1) % 240;
    }

    void tick(int cycles) {
        for (int i = 0; i < cycles; i++) tick();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < HEIGHT; j++) {
            for (int i = 0; i < WIDTH; i++) {
                sb.append(pixels[i][j] ? '#' : '.');
            }
            sb.append('\n');
        }

        return sb.toString();
    }
}
