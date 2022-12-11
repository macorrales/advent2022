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
 */
public class App {
    private Compiler compiler = new Compiler();

    public static void main(String[] args) throws IOException {
        List<String> program = Files.readAllLines(Path.of(args[0]));
        App app = new App();
        System.out.println(app.sumOfSignals(program));
        System.out.println(app.crtLines(program));
    }

    Integer sumOfSignals(List<String> program) {
        var cpuInstructions = compiler.compile(program).collect(Collectors.toList());
        return IntStream.range(1, cpuInstructions.size())
                .filter(i -> (i - 20) % 40 == 0)
                .map(i -> strength(program, i))
                .sum();
    }

    public String crtLines(List<String> program) {
        var cpu = new CPU();
        var cpuInstructions = compiler.compile(program).collect(Collectors.toList());
        return IntStream.range(0, cpuInstructions.size())
                .mapToObj(Integer::valueOf)
                .reduce("", (crt, i) -> {
                    String pixel = crt.concat(CRT.display(i, cpu.registerX()));
                    cpu.run(cpuInstructions.get(i));
                    return pixel;
                }, String::concat);
    }


    Integer strength(List<String> program, Integer cycle) {
        var cpu = new CPU();

        compiler.compile(program)
                .limit(cycle - 1)
                .forEach(cpu::run);
        return cpu.registerX() * cycle;
    }
}
