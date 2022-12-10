package com.macorrales.advent2022.day10;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Hello world!
 *
 */
public class App
{
    private Compiler compiler = new Compiler();

    public static void main(String[] args ) throws IOException {
        List<String> program = Files.readAllLines(Path.of(args[0]));
        System.out.println(new App().sumOfSignals(program));
    }

    Integer sumOfSignals(List<String> program) {
        var cpuInstructions = compiler.compile(program).collect(Collectors.toList());
        return IntStream.range(1,cpuInstructions.size())
                .filter(i->(i -20) %40==0)
                .peek(System.out::println)
                .map(i->strength(program,i))
                .sum();
    }

    record IndexedInstruction(Integer i, Function<Integer,Integer> func){

    }

    Integer strength(List<String> program,Integer cycle){
        var cpu = new CPU();

        compiler.compile(program)
                .limit(cycle-1)
                .forEach(cpu::run);
        return cpu.registerX()*cycle;
    }
}
