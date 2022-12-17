package com.macorrales.advent2022.dayX;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws IOException {
        Files.readAllLines(Path.of(args[0]));
        App app = new App();
    }
}
