package com.macorrales.advent2022.day10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CRTTest {

    @ParameterizedTest()
    @CsvSource(textBlock = """
                           0,9,.
                           0,1,#
                            """)
    void whenPointerWithinXSpriteShowAHash(Integer cycle, Integer registerX, String response){
        assertEquals(response,CRT.display(cycle,registerX));
    }
}
