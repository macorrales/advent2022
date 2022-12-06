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
        ShipHold shipHold = buildSampleShipHold();
        assertEquals("NDP",shipHold.top());
    }

    private static ShipHold buildSampleShipHold() {
        ShipHold shipHold = new ShipHold();
        shipHold.addStack(1,List.of('Z','N'));
        shipHold.addStack(2,List.of('M','C','D'));
        shipHold.addStack(3,List.of('P'));
        return shipHold;
    }

    @Test
    void shouldMoveOneBoxOnCommand(){
        // move 1 from 2 to 1
        var shipHold = buildSampleShipHold();
        shipHold.execute("move 1 from 2 to 1");
        assertEquals("DCP",shipHold.top());
    }
}
