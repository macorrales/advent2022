package com.macorrales.advent2022.day11;

import java.util.Arrays;
import java.util.List;

public class MonkeyLoader {
    public List<Monkey> load(String input) {
        var monkeys = input.split("\n\n");
        return Arrays.asList(monkeys)
                .stream()
                .map(Monkey::of)
                .toList();
    }
}
