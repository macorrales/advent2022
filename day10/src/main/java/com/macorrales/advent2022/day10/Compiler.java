package com.macorrales.advent2022.day10;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Takes instructions and compiles them to cycle operations
 */
public class Compiler {
    Stream<Function<Integer,Integer>> compile(String s) {
        if (s.equals("noop")){
            return  Stream.of(i->i);
        }
        var operand= s.replace("addx ","");
        var value= Integer.valueOf(operand);
        return Stream.of(i->i, i->i+value);
    }

    Stream<Function<Integer,Integer>> compile(List<String> instructions){
        return instructions.stream().flatMap(this::compile);
    }
}
