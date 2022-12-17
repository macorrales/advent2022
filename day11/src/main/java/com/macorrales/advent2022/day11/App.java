package com.macorrales.advent2022.day11;


import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * Day 11
 */
public class App {

    public static final int ROUNDS_IN_GAME = 20;
    List<Monkey> monkeys;
    Map<Integer, BigInteger> inspections = new HashMap<>();

    public static void main(String[] args) throws IOException {
        String input = Files.readString(Path.of(args[0]));
        App app = new App();
        app.load(input);
        app.playGame();
        System.out.println("Monkey business is : "+app.monkeyBusiness());
        var secondPart = new App();
        secondPart.load(input);
        secondPart.playSecondPart();
        System.out.println("Second part Monkey Business is: "+ secondPart.monkeyBusiness());
    }

    public void playSecondPart(){
        for (int i = 0; i< 10000; i++){
            playRound(l -> l);
        }

    }

    public void playGame() {
        for (int i = 0; i< ROUNDS_IN_GAME; i++){
            playRound();
        }
    }

    void load(String input) {
        monkeys = new MonkeyLoader().load(input);
    }

    public void playRound() {
        playRound(l->l.divide(BigInteger.valueOf(3l)));
    }
    public void playRound(Function<BigInteger, BigInteger> relief) {
        monkeys.forEach(
                (monkey) -> {
                    List<Monkey.Throw> throwList = monkey.turn(relief);
                    inspections.put(monkey.id(), inspections.getOrDefault(monkey.id(), BigInteger.ZERO).add(BigInteger.valueOf(throwList.size())));
                    throwList.forEach((send) -> {
                                Monkey theMonkey = monkeys.get(send.monkey());
                                monkeys.set(send.monkey(), theMonkey.throwAtMe(send.worry()));
                            }
                    );
                }
        );
    }

    public BigInteger monkeyBusiness() {
        return inspections.values()
                .stream()
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .reduce(BigInteger.ONE,(a,b)->a.multiply(b));
    }
}
