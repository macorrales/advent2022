package com.macorrales.advent2022.day05;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ShipHold {

    List<Stack<Character>> stacks = new ArrayList<>();
    public String top() {
        return stacks.stream()
                .map(Stack::peek)
                .map(String::valueOf)
                .reduce("", (s, c) -> s + c);
    }

    public void addStack(List<Character> boxes) {
        Stack<Character> stack = new Stack<>();
        boxes.stream().forEach(stack::push);
        stacks.add(stack);
    }
}
