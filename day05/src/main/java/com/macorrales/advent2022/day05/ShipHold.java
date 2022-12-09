package com.macorrales.advent2022.day05;

import java.util.*;

public class ShipHold {

    SortedMap<Integer, Deque<Character>> stacks = new TreeMap<>();
    public String top() {
        return stacks.values().stream()
                .map(Deque::peek)
                .map(String::valueOf)
                .reduce("", String::concat);
    }

    public void addStack(int id,List<Character> boxes) {
        Deque<Character> stack = new ArrayDeque<>();
        boxes.stream().forEach(stack::push);
        stacks.put(id,stack);
    }

    public void execute(String s) {

        System.out.println(s);
        var cmd = Command.parseCommand(s);
        var from = stacks.get(cmd.from());
        var to = stacks.get(cmd.to());
        // do it "amount" of boxes
        for (int i = 0; i < cmd.amount(); i++) {
            to.push(from.pop());
        }
    }

    private Character safePeek(Stack<Character> stack) {
        try {
            return stack.peek();
        } catch (EmptyStackException e) {
            return ' ';
        }
    }
}

