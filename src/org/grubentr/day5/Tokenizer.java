package org.grubentr.day5;

import java.util.Scanner;
import java.util.Stack;

public class Tokenizer {
    public static StackStore fromInputPart1(String input) {
        // Iterate over the input line by line, with a line counter
        Scanner sc = new Scanner(input);

        // Store the first part of the input; it defines the initial stack state
        Stack<String> crateStrings = new Stack<>();
        boolean haveStacks = false;
        while (!haveStacks) {
            String line = sc.nextLine();
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
        while (sc.hasNext()) {
            stackStore.performOpPart1(sc.nextLine());
        }

        // return the StackStore in its final state
        return stackStore;
    }

    public static StackStore fromInputPart2(String input) {
        // Iterate over the input line by line, with a line counter
        Scanner sc = new Scanner(input);

        // Store the first part of the input; it defines the initial stack state
        Stack<String> crateStrings = new Stack<>();
        boolean haveStacks = false;
        while (!haveStacks) {
            String line = sc.nextLine();
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
        while (sc.hasNext()) {
            stackStore.performOpPart2(sc.nextLine());
        }

        // return the StackStore in its final state
        return stackStore;
    }

}
