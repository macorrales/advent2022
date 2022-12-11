package com.macorrales.advent2022.day11;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Day 11
 */
public class App {

    public static void main(String[] args) throws IOException {
        Files.readAllLines(Path.of(args[0]));
        App app = new App();
    }
}
