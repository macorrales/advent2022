package com.macorrales.advent2022.day11;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class AppTest {

    App app = new App();

    @Test
    void firstRound() throws IOException {
        app.load(sample());
        app.playRound();

        assertArrayEquals(List.of(BigInteger.valueOf(20l),
                BigInteger.valueOf(23l),
                BigInteger.valueOf(27l),
                BigInteger.valueOf(26l)).toArray(), app.monkeys.get(0).items().toArray());
        assertArrayEquals(List.of(BigInteger.valueOf(2080l),
                BigInteger.valueOf(25l),
                BigInteger.valueOf(167l),
                BigInteger.valueOf(207l),
                BigInteger.valueOf(401l),
                BigInteger.valueOf(1046l)).toArray(), app.monkeys.get(1).items().toArray());
        assertTrue(app.monkeys.get(2).items().isEmpty());
        assertTrue(app.monkeys.get(3).items().isEmpty());
        assertEquals(2, app.inspections.get(app.monkeys.get(0).id()));
    }

    @Test
    void playSampleGame() throws IOException {
        app.load(sample());
        app.playGame();
        assertEquals(101, app.inspections.get(app.monkeys.get(0).id()));
        assertEquals(95, app.inspections.get(app.monkeys.get(1).id()));
        assertEquals(7, app.inspections.get(app.monkeys.get(2).id()));
        assertEquals(105, app.inspections.get(app.monkeys.get(3).id()));
    }

    @Test
    void monkeyBusinessForSampleShouldMatch() throws IOException {
        app.load(sample());
        app.playGame();
        assertEquals(10605, app.monkeyBusiness());
    }

    @Test
    void secondPartInspections() throws IOException {
        app.load(sample());
        app.playSecondPart();
        assertEquals(52166, app.inspections.get(app.monkeys.get(0).id()));
        assertEquals(47830, app.inspections.get(app.monkeys.get(1).id()));
        assertEquals(1938, app.inspections.get(app.monkeys.get(2).id()));
        assertEquals(52013, app.inspections.get(app.monkeys.get(3).id()));

    }

    @Test
    @Disabled
    void secondPartForSampleShouldMatch() throws IOException {
        app.load(sample());
        app.playSecondPart();
        assertEquals(2713310158l, app.monkeyBusiness());
    }

    String sample() throws IOException {
        return Files.readString(Path.of("src/test/resources/sample.txt"));
    }

}
