package com.macorrales.advent2022.day10;

import java.util.function.Function;

public class CPU {
    private Integer x = 1;

    public Integer registerX() {
        return x;
    }

    public void run(Function<Integer, Integer> func) {
        x = func.apply(x);
    }


}
