package com.macorrales.advent2022.day11;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class AppTest
{

    App app = new App();
    @Test
    void firstRound() throws IOException {
        app.load(sample());
        app.playRound();

        assertArrayEquals(List.of(20l, 23l, 27l, 26l).toArray(),app.monkeys.get(0).items().toArray());
        assertArrayEquals(List.of(2080l, 25l, 167l, 207l, 401l, 1046l).toArray(),app.monkeys.get(1).items().toArray());
        assertTrue(app.monkeys.get(2).items().isEmpty());
        assertTrue(app.monkeys.get(3).items().isEmpty());
        assertEquals(2,app.inspections.get(app.monkeys.get(0).id()));
    }

    @Test
    void playSampleGame() throws IOException {
        app.load(sample());
        app.playGame();
        assertEquals(101,app.inspections.get(app.monkeys.get(0).id()));
        assertEquals(95,app.inspections.get(app.monkeys.get(1).id()));
        assertEquals(7,app.inspections.get(app.monkeys.get(2).id()));
        assertEquals(105,app.inspections.get(app.monkeys.get(3).id()));
    }

    @Test
    void monkeyBusinessForSampleShouldMatch() throws IOException {
        app.load(sample());
        app.playGame();
        assertEquals(10605,app.monkeyBusiness());
    }
    String sample() throws IOException {
        return Files.readString(Path.of("src/test/resources/sample.txt"));
    }

}
