package com.macorrales.advent2022.day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MonkeyLoader {
    public List<Monkey> load(String input) {
        var monkeys = input.split("\n\n");
        return new ArrayList<>(Arrays.asList(monkeys)
                .stream()
                .map(Monkey::of)
                .toList())                ;
    }
}
