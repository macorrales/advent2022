package com.macorrales.advent2022.day04;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class OverlapFinder {
    public long countFullOverlaps(List<String> pairs) {
        return count(pairs, this::fullOverlap);
    }

    public long countOverlaps(List<String> assignments) {
        return count(assignments, this::overlap);
    }

    private long count(List<String> pairs, Predicate<ElfPairAssignment> overlapPredicate) {
        return pairs.stream()
                .map(ElfPairAssignment::parse)
                .filter(overlapPredicate)
                .count();
    }

    boolean fullOverlap(ElfPairAssignment pair) {
        // left one contains right one
        return (pair.oneElfFrom <= pair.anotherElfFrom && pair.oneElfTo >= pair.anotherElfTo)
                // or right one contains left one
                || (pair.anotherElfFrom <= pair.oneElfFrom && pair.anotherElfTo >= pair.oneElfTo);
    }

    boolean overlap(ElfPairAssignment pair) {
        // if one ends up in another
        return (pair.oneElfTo >= pair.anotherElfFrom && pair.oneElfTo <= pair.anotherElfTo)
                // if another ends up in one
                || (pair.anotherElfTo >= pair.oneElfFrom && pair.anotherElfTo <= pair.oneElfTo);
    }

    record ElfPairAssignment(int oneElfFrom, int oneElfTo, int anotherElfFrom, int anotherElfTo) {

        static ElfPairAssignment parse(String pair) {
            var assignments = pair.split(",");
            var oneElfBounds = elfBounds(assignments[0]);
            var anotherElfBounds = elfBounds(assignments[1]);

            return new ElfPairAssignment(oneElfBounds[0], oneElfBounds[1], anotherElfBounds[0], anotherElfBounds[1]);
        }

        private static int[] elfBounds(String assigment) {
            return Arrays.stream(assigment.split("-")).mapToInt(Integer::parseInt).toArray();
        }
    }


}
