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
    @Test
    void shouldMoveOneBoxOnCommand(){

        /*
                    [D]
                [N] [C]
                [Z] [M] [P]
                 1   2   3
        */
        // move 1 from 2 to 1
        var shipHold = buildSampleShipHold();
        shipHold.executeCrane9000("move 1 from 2 to 1");
        assertEquals("DCP", shipHold.top());
        shipHold.executeCrane9000("move 3 from 1 to 3");
        shipHold.executeCrane9000("move 2 from 2 to 1");
        shipHold.executeCrane9000("move 1 from 1 to 2");
        assertEquals("CMZ", shipHold.top());
    }

    @Test
    void shouldMovePilesAtOnceUsingCrane9001() {
        /*
                    [D]
                [N] [C]
                [Z] [M] [P]
                 1   2   3
        */
        // move 1 from 2 to 1
        var shipHold = buildSampleShipHold();
        shipHold.executeCrane9001("move 1 from 2 to 1");
        shipHold.executeCrane9001("move 3 from 1 to 3");
        shipHold.executeCrane9001("move 2 from 2 to 1");
        shipHold.executeCrane9001("move 1 from 1 to 2");
        assertEquals("MCD", shipHold.top());

    }

    private static ShipHold buildSampleShipHold() {
        ShipHold shipHold = new ShipHold();
        shipHold.addStack(1, List.of('Z', 'N'));
        shipHold.addStack(2, List.of('M', 'C', 'D'));
        shipHold.addStack(3, List.of('P'));
        return shipHold;
    }
}
