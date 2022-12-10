package com.macorrales.advent2022.day10;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompilerTest {

    Compiler compiler = new Compiler();

    @Test
    void whenNoopInstructionShouldBeASingleCycle() {
        assertEquals(1, compiler.compile("noop").count());
    }

    @Test
    void whenApplyingNoopResultShouldBeIdentity() {
        var initialState = 29;
        var op = compiler.compile("noop").findFirst().get();
        assertEquals(initialState, op.apply(initialState));
    }

    @Test
    void whenCompilingAprogramWithTwoNoopShouldProduceTwoCycles() {
        var program = List.of("noop", "noop");
        var machineCode = compiler.compile(program);
        assertEquals(2, machineCode.count());
        var initialState = 3;
    }

    @Test
    void whenAddXitReturnsTwoCyclesAdditionFunction() {
        Stream<Function<Integer, Integer>> machineCode = compiler.compile("addx 3");
        assertEquals(2, machineCode.count());
    }

    @Test
    void whenAddXFirstInstructionIsIdentity() {
        var initialState = 69;
        var op = compiler.compile("addx 7").findFirst().get();
        assertEquals(initialState, op.apply(initialState));
    }

    @Test
    void whenAddXSecondInstructionIsAddition() {
        Integer[] initialState = {26};
        compiler.compile("addx 9").forEach((f) -> {
            initialState[0] = f.apply(initialState[0]);
        });
        assertEquals(26+9,initialState[0]);
    }
}
