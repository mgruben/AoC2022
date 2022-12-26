package org.grubentr.day5;

import java.util.Stack;

public class Tokenizer {
    public static StackStore fromInput(String input) {
        // Iterate over the input line by line, with a line counter
        String[] lines = input.split("\n");
        int lineCounter = 0;

        // Store the first part of the input; it defines the initial stack state
        Stack<String> crateStrings = new Stack<>();
        boolean haveStacks = false;
        while (!haveStacks) {
            String line = lines[lineCounter++];
            if (line.length() == 0) {  // We've read all of the first part of the input
                haveStacks = true;
            } else {
                crateStrings.push(line);
            }
        }

        // Play back the first part of the input to create a new StackStore
        String lengthString = crateStrings.pop();
        int size = Integer.parseInt(String.valueOf(lengthString.charAt(lengthString.length() - 2)));
        StackStore stackStore = new StackStore(size);

        while (!crateStrings.isEmpty()) {
            stackStore.addCrates(crateStrings.pop());
        }

        // The remainder of the input is operations to perform; do those.
        while (lineCounter < lines.length) {
            stackStore.performOp(lines[lineCounter++]);
        }

        // return the StackStore in its final state
        return stackStore;
    }
}
