package org.grubentr.day3;

import java.util.HashSet;
import java.util.Set;

public class Group {
    private final Set<Character> a;
    private final Set<Character> b;
    private final Set<Character> c;

    private Set<Character> fromString(String input) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            set.add(input.charAt(i));
        }
        return set;
    }

    Group(String first, String second, String third) {
        a = fromString(first);
        b = fromString(second);
        c = fromString(third);
    }

    public Character getBadge() {
        Set<Character> intersection = new HashSet<>(a);
        intersection.retainAll(b);
        intersection.retainAll(c);
        assert intersection.size() == 1;
        return intersection.stream().findFirst().orElseThrow();
    }
}
