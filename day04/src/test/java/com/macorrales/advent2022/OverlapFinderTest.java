package com.macorrales.advent2022;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OverlapFinderTest {

    OverlapFinder overlapFinder = new OverlapFinder();

    @ParameterizedTest
    @CsvSource(textBlock = """
            2-4,6-8:false
            2-3,4-5:false
            5-7,7-9:false
            2-8,3-7:true
            6-6,4-6:true
            2-6,4-8:false
            6-8,1-3:false
            11-17,11-17:true
            """, delimiter = ':')
    void testAll(String pair, boolean result) {
        assertEquals(result, overlapFinder.fullOverlap(pair));

    }

    @Test
    void shouldCountFullOverlapsProperly() {
        var pairs = List.of(
                "2-4,6-8",
                "2-3,4-5",
                "5-7,7-9",
                "2-8,3-7",
                "6-6,4-6",
                "2-6,4-8");
        assertEquals(2,overlapFinder.countFullOverlaps(pairs));
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
            2-4,6-8:false
            2-3,4-5:false
            5-7,7-9:true
            2-8,3-7:true
            6-6,4-6:true
            2-6,4-8:true
            """, delimiter = ':')
    void testAllPartialOverlaps(String pair, boolean result) {
        assertEquals(result,overlapFinder.overlap(pair));
    }


    @Test
    void shouldCountPartialOverlapsProperly() {
        var pairs = List.of(
                "2-4,6-8",
                "2-3,4-5",
                "5-7,7-9",
                "2-8,3-7",
                "6-6,4-6",
                "2-6,4-8");
        assertEquals(4,overlapFinder.countOverlaps(pairs));
    }
}
