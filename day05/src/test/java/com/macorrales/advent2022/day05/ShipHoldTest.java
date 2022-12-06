package com.macorrales.advent2022.day05;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShipHoldTest {

    @Test
    void anEmptyHoldTopIsEmptyString(){
        ShipHold shipHold = new ShipHold();
        assertTrue("".equals(shipHold.top()));
    }

    @Test
    void aHoldWithOneStackTopIsTopBoxLetter(){
        ShipHold shipHold = new ShipHold();
        shipHold.addStack(1,List.of('A','B','C'));
        assertEquals("C",shipHold.top());
    }

    @Test
    void aHoldWithSeveralStacksTopIsAllTopBoxesLetters(){
        ShipHold shipHold = new ShipHold();
        shipHold.addStack(1,List.of('A','B','C'));
        shipHold.addStack(2,List.of('A','B'));
        shipHold.addStack(3,List.of('A'));
        assertEquals("CBA",shipHold.top());
    }


}
