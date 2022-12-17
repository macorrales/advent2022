package com.macorrales.advent2022.day11;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public record Monkey(int id, List<BigInteger> items, UnaryOperator<BigInteger> operator, BigInteger divisor, int positiveTestMonkey,
                     int negativeTestMonkey) {

    public static final BigInteger LEAST_COMMON_MULTIPLIER = BigInteger.valueOf(11*2*5*17*19*7*3*13*23);

    static Monkey  of(String s){
        var lines = s.split("\n");

        return new Monkey(parseId(lines),
                          parseItems(lines),
                          parseOperator(lines),
                          parseDivisor(lines),
                          parseTrueToMonkey(lines),
                          parseFalseToMonkey(lines));
    }

    public Monkey throwAtMe(BigInteger item){
        items.add(item);
        return this;

    }

    private static int parseFalseToMonkey(String[] lines){
        return Integer.parseInt(lines[5].replace("    If false: throw to monkey ",""));
    }
    private static int parseTrueToMonkey(String[] lines){
        return Integer.parseInt(lines[4].replace("    If true: throw to monkey ",""));
    }
    private static BigInteger parseDivisor(String[]lines){
        return new BigInteger(lines[3].replace("  Test: divisible by ",""));
    }
    private static UnaryOperator<BigInteger> parseOperator(String[] lines) {
        var operationText = lines[2]
                .replace("  Operation: new = old ", "")
                .trim();
        if (operationText.equals("* old")) {
            return (l)->l.multiply(l);
        }

        var operatorText = operationText.split(" ")[0];
        var operand = new BigInteger(operationText.split(" ")[1]);
        if (operatorText.equals("*")){
            return (l)->l.multiply(operand);
        }
        return (l)->l.add(operand);
    }

    private static List<BigInteger> parseItems(String[] lines) {
        return new ArrayList<>(Arrays.stream(lines[1]
                        .replace("  Starting items: ", "")
                        .split(","))
                .map(String::trim)
                .map(BigInteger::new)
                .toList());
    }

    private static int parseId(String [] lines){
        return Integer.parseInt(
                lines[0]
                .replace("Monkey ","")
                .replace(":","")
        );
    }
    public List<Throw> turn() {
        Function<BigInteger, BigInteger> relief = worry -> worry.divide(BigInteger.valueOf(3l));
        return turn(relief);
    }

    public List<Throw> turn(Function<BigInteger, BigInteger> relief) {
        List<Throw> throwList = items.stream()
                .map(operator)
                .map(relief)
                .map(worry ->
                        new Throw((worry.mod(divisor).equals(BigInteger.ZERO)) ? positiveTestMonkey : negativeTestMonkey, worry.mod(LEAST_COMMON_MULTIPLIER)))
                .toList();
        items.clear();
        return throwList;
    }

    record Throw (Integer monkey, BigInteger worry){
     }
}
