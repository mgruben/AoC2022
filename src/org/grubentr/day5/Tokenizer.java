package org.grubentr.day5;

import java.util.Scanner;
import java.util.Stack;

public class Tokenizer {
    private record OpInts(int count, int from, int to) {}

    private static OpInts parseOp(String opString) {
        Scanner sc = new Scanner(opString);  // Default matches on whitespace

        // "move"
        sc.next();
        int count = sc.nextInt();

        // "from"
        sc.next();
        int from = sc.nextInt();

        // "to"
        sc.next();
        int to = sc.nextInt();

        return new OpInts(count, from, to);
    }

    private static StackStore buildStackStore(Scanner inputScanner) {
        // Store the first part of the input; it defines the initial stack state
        Stack<String> crateStrings = new Stack<>();
        boolean haveStacks = false;
        while (!haveStacks) {
            String line = inputScanner.nextLine();
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

        return stackStore;
    }



    public static StackStore fromInputPart1(String input) {
        Scanner sc = new Scanner(input);
        StackStore stackStore = buildStackStore(sc);

        // The remainder of the input is operations to perform; do those.
        while (sc.hasNext()) {
            OpInts opInts = parseOp(sc.nextLine());
            stackStore.performOpPart1(opInts.count, opInts.from, opInts.to);
        }

        // return the StackStore in its final state
        return stackStore;
    }

    public static StackStore fromInputPart2(String input) {
        Scanner sc = new Scanner(input);
        StackStore stackStore = buildStackStore(sc);

        // The remainder of the input is operations to perform; do those.
        while (sc.hasNext()) {
            OpInts opInts = parseOp(sc.nextLine());
            stackStore.performOpPart2(opInts.count, opInts.from, opInts.to);
        }

        // return the StackStore in its final state
        return stackStore;
    }

}
