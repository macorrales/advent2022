package com.macorrales.advent2022.day11;

import java.util.Arrays;
import java.util.function.UnaryOperator;

public record Monkey(long[] items, UnaryOperator<Long> operator, long divisor, int positiveTestMonkey,
                     int negativeTestMonkey) {
    static Monkey  of(String s){
        var lines = s.split("\n");

        return new Monkey(parseItems(lines),
                          parseOperator(lines),
                          parseDivisor(lines),
                          parseTrueToMonkey(lines),
                          parseFalseToMonkey(lines));
    }

    private static int parseFalseToMonkey(String[] lines){
        return Integer.parseInt(lines[5].replace("    If false: throw to monkey ",""));
    }
    private static int parseTrueToMonkey(String[] lines){
        return Integer.parseInt(lines[4].replace("    If true: throw to monkey ",""));
    }
    private static long parseDivisor(String[]lines){
        return Long.parseLong(lines[3].replace("  Test: divisible by ",""));
    }
    private static UnaryOperator<Long> parseOperator(String[] lines) {
        var operationText = lines[2]
                .replace("  Operation: new = old ", "")
                .trim();
        if (operationText.equals("* old")) {
            return (l)->l*l;
        }

        var operatorText = operationText.split(" ")[0];
        long operand = Long.parseLong(operationText.split(" ")[1]);
        if (operatorText.equals("*")){
            return (l)->l*operand;
        }
        return (l)->l+operand;
    }

    private static long[] parseItems(String[] lines) {
        return Arrays.stream(lines[1]
                        .replace("  Starting items: ", "")
                        .split(","))
                .map(String::trim)
                .mapToLong(Long::parseLong)
                .toArray();
    }
}
