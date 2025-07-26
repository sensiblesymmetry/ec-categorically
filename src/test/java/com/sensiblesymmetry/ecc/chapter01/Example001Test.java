package com.sensiblesymmetry.ecc.chapter01;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Example001Test
{
    /**
     * Example 1
     */
    @Test
    public void streamFilterForFilteringEvensAndOdds()
    {
        List<Integer> numbers =
                IntStream.rangeClosed(1, 10)
                        .boxed()
                        .toList();

        List<Integer> evens =
                numbers.stream()
                        .filter(each -> each % 2 == 0)
                        .toList();

        List<Integer> odds =
                numbers.stream()
                        .filter(each -> each % 2 != 0)
                        .toList();

        List<Integer> expectedEvens = List.of(2, 4, 6, 8, 10);
        List<Integer> expectedOdds = List.of(1, 3, 5, 7, 9);

        assertEquals(expectedEvens, evens);
        assertEquals(expectedOdds, odds);
    }
}
