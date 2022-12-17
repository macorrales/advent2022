package com.macorrales.advent2022.dayX;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
