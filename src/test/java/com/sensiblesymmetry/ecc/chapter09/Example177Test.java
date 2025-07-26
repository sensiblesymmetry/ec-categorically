package com.sensiblesymmetry.ecc.chapter09;

import java.util.IntSummaryStatistics;

import com.sensiblesymmetry.ecc.Generation;
import com.sensiblesymmetry.ecc.PresidentOfUSA;
import org.eclipse.collections.api.list.ImmutableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Example177Test
{
    /**
     * Example 177
     */
    @Test
    public void summarizeIntForYearsPresidentsHaveServed()
    {
        ImmutableList<PresidentOfUSA> boomerPresidents =
                PresidentOfUSA.bornIn(Generation.BOOMER);

        IntSummaryStatistics intSummaryStatistics =
                boomerPresidents.summarizeInt(PresidentOfUSA::getYearsServed);

        assertEquals(4, intSummaryStatistics.getCount());
        assertEquals(4, intSummaryStatistics.getMin());
        assertEquals(8, intSummaryStatistics.getMax());
        assertEquals(28, intSummaryStatistics.getSum());
        assertEquals(7.0, intSummaryStatistics.getAverage());
    }
}
