package com.macorrales.advent2022.day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String... args) throws IOException {
        var shipHold = new ShipHold();
        shipHold.addStack(1, from("BZT"));
        shipHold.addStack(2, from("VHTDN"));
        shipHold.addStack(3, from("BFMD"));
        shipHold.addStack(4, from("TJGWVQL"));
        shipHold.addStack(5, from("WDGPVFQM"));
        shipHold.addStack(6, from("VZQGHFS"));
        shipHold.addStack(7, from("ZSNRLTCW"));
        shipHold.addStack(8, from("ZHWDJNRM"));
        shipHold.addStack(9, from("MQLFDS"));

        List<String> assignments = Files.readAllLines(Path.of(args[0]));
        assignments.stream()
                .skip(10)
                .forEach(shipHold::execute);
        System.out.println(shipHold.top());
    }

    private static List<Character> from(String s) {
        return s.chars().mapToObj(i -> Character.valueOf((char) i)).collect(Collectors.toList());

    }
}
