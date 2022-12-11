package com.macorrales.advent2022.day11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonkeyTest {

    @Test
    void shouldParseEntry(){
        var entry = """
                    Monkey 0:
                      Starting items: 79, 98
                      Operation: new = old * 19
                      Test: divisible by 23
                        If true: throw to monkey 2
                        If false: throw to monkey 3
                    """;
        var monkey = Monkey.of(entry);
        assertArrayEquals(new long[]{79l,98l},monkey.items());
        assertEquals(190, monkey.operator().apply(10l));
        assertEquals(23, monkey.divisor());
        assertEquals(2, monkey.positiveTestMonkey());
        assertEquals(3, monkey.negativeTestMonkey());
    }

    @Test
    void shouldOldTimesOldOperation(){
        var entry = """
                    Monkey 1:
                      Starting items: 99, 67, 62, 61, 59, 98
                      Operation: new = old * old
                      Test: divisible by 2
                        If true: throw to monkey 6
                        If false: throw to monkey 7
                    """;
        assertEquals(17*17,Monkey.of(entry).operator().apply(17l));
    }
    @Test
    void shouldOldPlusNumberOperation(){
        var entry = """
                    Monkey 6:
                      Starting items: 95, 88, 53, 75
                      Operation: new = old + 8
                      Test: divisible by 3
                        If true: throw to monkey 0
                        If false: throw to monkey 7
                    """;
        assertEquals(17+8,Monkey.of(entry).operator().apply(17l));
    }

}
