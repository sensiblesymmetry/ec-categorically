package com.sensiblesymmetry.ecc.chapter09;

import com.sensiblesymmetry.ecc.Generation;
import com.sensiblesymmetry.ecc.PresidentOfUSA;
import org.eclipse.collections.api.list.ImmutableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Example175Test
{
    /**
     * Example 175
     */
    @Test
    public void streamMapToIntSumYearsPresidentsHaveServed()
    {
        ImmutableList<PresidentOfUSA> boomerPresidents =
                PresidentOfUSA.bornIn(Generation.BOOMER);

        long sum = boomerPresidents.stream()
                .mapToInt(PresidentOfUSA::getYearsServed)
                .sum();

        assertEquals(28, sum);
    }
}
