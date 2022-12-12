package com.macorrales.advent2022.day11;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Day 11
 */
public class App {

    public static final int ROUNDS_IN_GAME = 20;
    List<Monkey> monkeys;
    Map<Integer, Integer> inspections = new HashMap<>();

    public static void main(String[] args) throws IOException {
        String input = Files.readString(Path.of(args[0]));
        App app = new App();
        app.load(input);
        app.playGame();
        System.out.println("Monkey business is : "+app.monkeyBusiness());
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
        monkeys.forEach(
                (monkey) -> {
                    List<Monkey.Throw> throwList = monkey.turn();
                    inspections.put(monkey.id(), inspections.getOrDefault(monkey.id(), 0) + throwList.size());
                    throwList.forEach((send) -> {
                                Monkey theMonkey = monkeys.get(send.monkey());
                                monkeys.set(send.monkey(), theMonkey.throwAtMe(send.worry()));
                            }
                    );
                }
        );
    }

    public int monkeyBusiness() {
        return inspections.values()
                .stream()
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .reduce(1,(a,b)->a*b);
    }
}
