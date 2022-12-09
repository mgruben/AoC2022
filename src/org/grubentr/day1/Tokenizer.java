package org.grubentr.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tokenizer {
    static List<List<Integer>> tokenizeCalories(String calorieStrings) {
        List<List<Integer>> elfList = new ArrayList<>();
        List<Integer> calorieList = new ArrayList<>();
        boolean flushed = false;
        for (String line : calorieStrings.lines().toList()) {
            if (Objects.equals(line, "")) {
                elfList.add(calorieList);
                calorieList = new ArrayList<>();
                flushed = true;
            } else {
                calorieList.add(Integer.valueOf(line));
                flushed = false;
            }
        }
        if (!flushed) elfList.add(calorieList);
        return elfList;
    }
}
