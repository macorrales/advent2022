package com.macorrales.advent2022.day11;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MonkeyLoaderTest {
    MonkeyLoader monkeyLoader = new MonkeyLoader();

    @Test
    void shouldLoadSevenMonkeysFromSample() throws IOException {
        assertEquals(4,monkeyLoader.load(sample()).size());
    }


    String sample() throws IOException {
        return Files.readString(Path.of("src/test/resources/sample.txt"));
    }
}
