package org.grubentr.day3;

public class Rucksack {
     private final Compartment first;
     private final Compartment second;
    public Rucksack(String contents) {
        int halfway = contents.length() / 2;
        first = new Compartment(contents.substring(0, halfway));
        second = new Compartment(contents.substring(halfway));
    }

}

