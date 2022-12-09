package com.macorrales.advent2022.day05;

import java.util.regex.Pattern;

public record Command (int amount, int from, int to ) {
    static Command parseCommand(String s){
        int amount =extractValue(s, "move");
        int from = extractValue(s,"from");
        int to = extractValue(s,"to");
        return new Command(amount,from,to);
    }

    private static int extractValue(String s, String tag) {
        var p = Pattern.compile("(?<=" + tag + " )([0-9]*)");
        var m = p.matcher(s);
        m.find();
        var value = m.group();
        return Integer.parseInt(value);
    }
}
