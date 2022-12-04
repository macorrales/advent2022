package com.macorrales.advent2022.day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        var finder = new OverlapFinder();

        List<String> assignments = Files.readAllLines(Path.of(args[0]));
        System.out.printf("There are %s full overlapping pairs in the file\n",finder.countFullOverlaps(assignments));
        System.out.printf("There are %s simple overlapping pairs in the file\n",finder.countOverlaps(assignments));
    }
}
