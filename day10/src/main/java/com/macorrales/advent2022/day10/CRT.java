package com.macorrales.advent2022.day10;

public class CRT {
    public static String display(Integer cycle, Integer registerX){

        int pointer = (cycle) % 40;
        String pixel = (pointer >= registerX-1 && pointer <= registerX+1) ? "#":".";

        if (pointer == 39 && cycle!=0){
            pixel= pixel + "\n";
        }

        return pixel;
    }
}
