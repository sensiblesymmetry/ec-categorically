package com.sensiblesymmetry.ecc.chapter08;

import java.util.List;

import com.sensiblesymmetry.ecc.Generation;
import com.sensiblesymmetry.ecc.PresidentOfUSA;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.multimap.list.MutableListMultimap;
import org.eclipse.collections.impl.factory.Multimaps;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Example156Test
{
    /**
     * Example 156
     */
    @Test
    public void imperativeGroupGenerationsByPresidentsWhoServed()
    {
        ImmutableList<Generation> all = Generation.ALL;

        MutableListMultimap<PresidentOfUSA, Generation> multimap =
                Multimaps.mutable.list.empty();

        for (Generation generation : all)
        {
            for (PresidentOfUSA president : generation.getPresidentsWhoServed())
            {
                multimap.put(president, generation);
            }
        }

        var expectedFDR = List.of(Generation.SILENT);
        var expectedBC = List.of(Generation.MILLENNIAL, Generation.Z);
        assertEquals(expectedFDR, multimap.get(PresidentOfUSA.FRANKLIN_ROOSEVELT));
        assertEquals(expectedBC, multimap.get(PresidentOfUSA.BILL_CLINTON));
    }
}
