package com.macorrales.advent2022.day05;

import java.util.*;

public class ShipHold {

    SortedMap<Integer,Stack<Character>> stacks = new TreeMap<>();
    public String top() {
        return stacks.values().stream()
                .map(Stack::peek)
                .map(String::valueOf)
                .reduce("",String::concat);
    }

    public void addStack(int id,List<Character> boxes) {
        Stack<Character> stack = new Stack<>();
        boxes.stream().forEach(stack::push);
        stacks.put(id,stack);
    }

    public void execute(String s) {
        
    }
}

