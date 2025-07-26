package com.sensiblesymmetry.ecc.chapter03;

import org.eclipse.collections.impl.list.Interval;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Example025Test
{
    /**
     * Example 25
     */
    @Test
    public void countingFromOneToTen()
    {
        Interval interval = Interval.oneTo(10);
        String string = interval.makeString(", ");

        String expected = "1, 2, 3, 4, 5, 6, 7, 8, 9, 10";
        assertEquals(expected, string);
    }
}
