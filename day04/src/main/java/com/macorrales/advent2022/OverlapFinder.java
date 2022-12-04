package com.macorrales.advent2022;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class OverlapFinder {
    public long countFullOverlaps(List<String> pairs){
        return calculateCount(pairs, this::fullOverlap);
    }

    public long countOverlaps(List<String> assignments) {
        return calculateCount(assignments,this::overlap);
    }

    public boolean fullOverlap(String pair){

        var assignments = pair.split(",");
        var oneElfBounds = elfBounds(assignments[0]);
        var anotherElfBounds = elfBounds(assignments[1]);

        return fullOverlap(oneElfBounds[0], oneElfBounds[1], anotherElfBounds[0], anotherElfBounds[1]);
    }

    private long calculateCount(List<String> pairs, Predicate<String> overlapPredicate ) {
        return pairs.stream().filter(overlapPredicate).count();
    }

    public boolean overlap(String pair) {
        var assignments = pair.split(",");
        var oneElfBounds = elfBounds(assignments[0]);
        var anotherElfBounds = elfBounds(assignments[1]);

        return overlap(oneElfBounds[0],oneElfBounds[1],anotherElfBounds[0],anotherElfBounds[1]);
    }

    private static int[] elfBounds(String assigment) {
        return Arrays.stream(assigment.split("-")).mapToInt(Integer::parseInt).toArray();
    }


    private boolean fullOverlap(int leftFrom, int leftTo, int rightFrom, int rightTo){
        // left one contains right one
        if (leftFrom<=rightFrom && leftTo>=rightTo){
            return true;
        }
        // right one contains left one
        if (rightFrom<=leftFrom && rightTo>=leftTo){
            return true;
        }
        return false;
    }

    private boolean overlap(int leftFrom, int leftTo, int rightFrom, int rightTo) {
        // if left ends up in right
        if (leftTo >= rightFrom && leftTo<=rightTo){
            return true;
        }
        // if right one ends up in left one
        if (rightTo>= leftFrom && rightTo<=leftTo){
            return true;
        }
    return false;
    }

}
