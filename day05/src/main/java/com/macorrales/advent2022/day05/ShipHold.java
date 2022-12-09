package com.macorrales.advent2022.day05;

import java.util.*;

public class ShipHold {

    public SortedMap<Integer, Deque<Character>> stacks = new TreeMap<>();
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

    public void executeCrane9000(String s) {

        var cmd = Command.parseCommand(s);
        // do it "amount" of boxes
        var from = stacks.get(cmd.from());
        var to = stacks.get(cmd.to());
        for (int i = 0; i < cmd.amount(); i++) {
            to.push(from.pop());
        }
    }

    public void executeCrane9001(String s) {
        var cmd = Command.parseCommand(s);
        // do it "amount" of boxes
        var from = stacks.get(cmd.from());
        var to = stacks.get(cmd.to());
        var tmp = new ArrayDeque<Character>();
        for (int i = 0; i < cmd.amount(); i++) {
            tmp.push(from.pop());
        }
        for (int i = 0; i < cmd.amount(); i++) {
            to.push(tmp.pop());
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

