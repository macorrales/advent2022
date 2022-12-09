package com.macorrales.advent2022.day05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommandTest {

    @Test
    void shouldParseValuesProperly(){
        var cmd = Command.parseCommand("move 13 from 25 to 35");
        assertEquals(13,cmd.amount());
        assertEquals(25,cmd.from());
        assertEquals(35,cmd.to());
    }

}
