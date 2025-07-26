package com.sensiblesymmetry.ecc.chapter03;

import com.sensiblesymmetry.ecc.Generation;
import org.eclipse.collections.api.block.predicate.Predicate;
import org.eclipse.collections.api.list.ImmutableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Example032Test
{
    /**
     * Example 32
     */
    @Test
    public void countingUsingPredicates()
    {
        ImmutableList<Generation> all = Generation.ALL;

        Predicate<Generation> moreThan = gen -> gen.years().size() > 15;
        int moreThan15Years = all.count(moreThan);
        assertEquals(11, moreThan15Years);

        Predicate<Generation> lessThan = gen -> gen.years().size() < 15;
        int lessThan15Years = all.count(lessThan);
        assertEquals(0, lessThan15Years);

        int equalTo15Years = all.count(gen -> gen.years().size() == 15);
        assertEquals(0, equalTo15Years);

        int equalTo16Years = all.count(gen -> gen.years().size() == 16);
        assertEquals(3, equalTo16Years);

        int equalTo17Years = all.count(gen -> gen.years().size() == 17);
        assertEquals(2, equalTo17Years);
    }
}
