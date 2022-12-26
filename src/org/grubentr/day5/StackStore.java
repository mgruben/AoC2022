package org.grubentr.day5;

import java.util.*;

public class StackStore {
    private final List<Stack<Character>> stacks;

    public StackStore(int size) {
        stacks = new ArrayList<>(size + 1);
        stacks.add(null); // Insert a dummy stack at index 0, so we can use 1-indexed counting
        for (int i = 0; i < size; i++) {
            stacks.add(new Stack<>());
        }
    }

    public String peekTops() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < stacks.size(); i++) {
            Stack<Character> s = stacks.get(i);
            if (s.isEmpty()) sb.append(" ");
            else sb.append(s.peek());
        }
        return sb.toString();
    }

    /**
     * Given a line of puzzle input, add the crates this line contains to the right stacks.
     * Ex:
     * Given "    [A]    "
     * Add "A" to Stack 2.
     *
     * @param line
     */
    public void addCrates(String line) {
        for (int i = 1, stack = 1; i < line.length(); i+=4, stack++) {
            if (line.charAt(i) != ' ') stacks.get(stack).push(line.charAt(i));
        }
    }

    public void performOpPart1(int count, int from, int to) {
        for (int i = 0; i < count; i++) {
            Stack<Character> source = stacks.get(from);
            Stack<Character> destination = stacks.get(to);

            destination.push(source.pop());
        }
    }

    public void performOpPart2(int count, int from, int to) {
        Stack<Character> tmp = new Stack<>();

        for (int i = 0; i < count; i++) {
            Stack<Character> source = stacks.get(from);
            tmp.push(source.pop());
        }

        while (!tmp.isEmpty()) {
            Stack<Character> destination = stacks.get(to);
            destination.push(tmp.pop());
        }
    }
}
