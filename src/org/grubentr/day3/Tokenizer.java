package org.grubentr.day3;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {

    public static List<List<String>> toGroups(String input) {
        List<List<String>> groups = new ArrayList<>();
        List<String> group = new ArrayList<>();

        int i = 0;

        for (String line : input.split("\\n")) {
            group.add(line);
            if (++i % 3 == 0) {
                groups.add(group);
                group = new ArrayList<>();
            }
        }

        return groups;
    }
}
