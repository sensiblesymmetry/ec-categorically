package com.sensiblesymmetry.ecc.chapter01;

import org.eclipse.collections.api.list.primitive.IntList;
import org.eclipse.collections.impl.list.primitive.IntInterval;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Example003Test
{
    /**
     * Example 3
     */
    @Test
    public void intListSelectRejectForFilteringEvensAndOdds()
    {
        IntList interval = IntInterval.oneTo(10);

        IntList evens = interval.select(each -> each % 2 == 0);

        IntList odds = interval.reject(each -> each % 2 == 0);

        IntList expectedEvens = IntInterval.evensFromTo(1, 10);
        IntList expectedOdds = IntInterval.oddsFromTo(1, 10);

        assertEquals(expectedEvens, evens);
        assertEquals(expectedOdds, odds);
    }
}
