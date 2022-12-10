package com.macorrales.advent2022.day10;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class CPUTest {

    @Test
    void initialStateOfCPUis_1() {
        var cpu = new CPU();
        assertEquals(1, cpu.registerX());
    }

    @Test
    void processInstructionAppliesFunctionToRegister() {
        var cpu = new CPU();
        Function<Integer, Integer> triple = (i) -> i * 3;
        cpu.run(triple);
        assertEquals(3, cpu.registerX());
    }


}
