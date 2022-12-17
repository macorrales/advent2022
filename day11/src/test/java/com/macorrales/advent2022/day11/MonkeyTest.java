package com.macorrales.advent2022.day11;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(0,monkey.id());
        assertEquals(List.of(BigInteger.valueOf(79l),BigInteger.valueOf(98l)),monkey.items());
        assertEquals(BigInteger.valueOf(190), monkey.operator().apply(BigInteger.valueOf(10L)));
        assertEquals(BigInteger.valueOf(23), monkey.divisor());
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
        assertEquals(BigInteger.valueOf(17*17),Monkey.of(entry).operator().apply(BigInteger.valueOf(17l)));
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
        assertEquals(BigInteger.valueOf(17+8),Monkey.of(entry).operator().apply(BigInteger.valueOf(17l)));
    }

    @Test
    void shouldThrowAllItems(){
        var monkey = Monkey.of(   """
                                            Monkey 2:
                                              Starting items: 79, 60, 97
                                              Operation: new = old * old
                                              Test: divisible by 13
                                                If true: throw to monkey 1
                                                If false: throw to monkey 3
                                            """);
        List<Monkey.Throw> throwList = monkey.turn();
        assertEquals(3, throwList.size());
        assertEquals(new Monkey.Throw(1,BigInteger.valueOf(2080l)), throwList.get(0));
        assertEquals(new Monkey.Throw(3,BigInteger.valueOf(1200l)), throwList.get(1));
        assertEquals(new Monkey.Throw(3,BigInteger.valueOf(3136l)), throwList.get(2));
    }

    @Test
    void shouldReceive(){
        var monkey = Monkey.of(   """
                                            Monkey 2:
                                              Starting items: 79
                                              Operation: new = old * old
                                              Test: divisible by 13
                                                If true: throw to monkey 1
                                                If false: throw to monkey 3
                                            """);
        monkey.throwAtMe(BigInteger.valueOf(60l));
        List<Monkey.Throw> throwList = monkey.turn();
        assertEquals(2, throwList.size());
        assertEquals(new Monkey.Throw(1,BigInteger.valueOf(2080l)), throwList.get(0));
        assertEquals(new Monkey.Throw(3,BigInteger.valueOf(1200l)), throwList.get(1));
    }

}
