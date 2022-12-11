package com.macorrales.advent2022.day11;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest
{

    @Test
    void itLoadsSample() throws IOException {
        sample().forEach(System.out::println);

    }
    List<String> sample() throws IOException {
        return Files.readAllLines(Path.of("src/test/resources/sample.txt"));
    }

}
