package com.macorrales.advent2022.day10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest
{

    private App app = new App();

    @Test
    void sampleProgram(){
    var program = sample();
    var compiler = new Compiler();
    var cpu = new CPU();
     compiler.compile(program)
             .forEach(cpu::run);
     assertEquals(-1,cpu.registerX())
     ;
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
            20, 420
            60, 1140
            100, 1800
            140, 2940
            180, 2880
            220, 3960
            """)
    void longerProgramStrengthAt20(Integer cycle, Integer strength){
        assertEquals(strength,app.strength(longerSample(), cycle));
    }

    @Test
    void longerProgramSumOfSignals(){
        assertEquals(13140,app.sumOfSignals(longerSample()));
    }
    private List<String> sample(){
        return List.of("noop",
                "addx 3",
                "addx -5"
                );
    }

    private List<String> longerSample(){
        var input = """
addx 15
addx -11
addx 6
addx -3
addx 5
addx -1
addx -8
addx 13
addx 4
noop
addx -1
addx 5
addx -1
addx 5
addx -1
addx 5
addx -1
addx 5
addx -1
addx -35
addx 1
addx 24
addx -19
addx 1
addx 16
addx -11
noop
noop
addx 21
addx -15
noop
noop
addx -3
addx 9
addx 1
addx -3
addx 8
addx 1
addx 5
noop
noop
noop
noop
noop
addx -36
noop
addx 1
addx 7
noop
noop
noop
addx 2
addx 6
noop
noop
noop
noop
noop
addx 1
noop
noop
addx 7
addx 1
noop
addx -13
addx 13
addx 7
noop
addx 1
addx -33
noop
noop
noop
addx 2
noop
noop
noop
addx 8
noop
addx -1
addx 2
addx 1
noop
addx 17
addx -9
addx 1
addx 1
addx -3
addx 11
noop
noop
addx 1
noop
addx 1
noop
noop
addx -13
addx -19
addx 1
addx 3
addx 26
addx -30
addx 12
addx -1
addx 3
addx 1
noop
noop
noop
addx -9
addx 18
addx 1
addx 2
noop
noop
addx 9
noop
noop
noop
addx -1
addx 2
addx -37
addx 1
addx 3
noop
addx 15
addx -21
addx 22
addx -6
addx 1
noop
addx 2
addx 1
noop
addx -10
noop
noop
addx 20
addx 1
addx 2
addx 2
addx -6
addx -11
noop
noop
noop
""";
        return Arrays.asList(input.split("\n"));
    }
}
