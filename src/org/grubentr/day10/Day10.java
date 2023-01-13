package org.grubentr.day10;

public class Day10 {

    public static long part1(String input) {
        Cpu cpu = new Cpu();
        cpu.program(input.lines().map(Tokenizer::toInstruction).iterator());

        long ans = 0;

        cpu.tickUntil(19); // The 20th cycle
        ans += cpu.getX() * 20;

        cpu.tick(40); // 60th cycle
        ans += cpu.getX() * 60;

        cpu.tick(40); // 100th cycle
        ans += cpu.getX() * 100;

        cpu.tick(40); // 140th cycle
        ans += cpu.getX() * 140;

        cpu.tick(40); // 180th cycle
        ans += cpu.getX() * 180;

        cpu.tick(40); // 220th cycle
        ans += cpu.getX() * 220;

        return ans;
    }

    public static String part2(String input) {
        Cpu cpu = new Cpu();
        cpu.program(input.lines().map(Tokenizer::toInstruction).iterator());

        Crt crt = new Crt(cpu::getX);

        while (cpu.hasNext()) {
            crt.tick();
            cpu.tick();
        }

        return crt.toString();
    }

    public static void main(String[] args) {
        System.out.println(part1(Data.input));
        System.out.println(part2(Data.input));
    }
}
