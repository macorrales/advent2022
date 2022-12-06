package com.macorrales.advent2022.day05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommandTest {

    @Test
    void shouldParseValuesProperly(){
        var cmd = Command.parseCommand("move 1 from 2 to 3");
        assertEquals(1,cmd.amount());
        assertEquals(2,cmd.from());
        assertEquals(3,cmd.to());
    }

}
