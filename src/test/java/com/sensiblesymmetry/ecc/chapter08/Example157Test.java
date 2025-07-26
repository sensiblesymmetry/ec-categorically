package com.sensiblesymmetry.ecc.chapter08;

import java.util.List;

import com.sensiblesymmetry.ecc.Generation;
import com.sensiblesymmetry.ecc.PresidentOfUSA;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.multimap.Multimap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Example157Test
{
    /**
     * Example 157
     */
    @Test
    public void groupGenerationsByEachPresidentWhoServed()
    {
        ImmutableList<Generation> all = Generation.ALL;

        Multimap<PresidentOfUSA, Generation> multimap =
                all.groupByEach(Generation::getPresidentsWhoServed);

        var expectedFDR = List.of(Generation.SILENT);
        var expectedBC = List.of(Generation.MILLENNIAL, Generation.Z);
        assertEquals(expectedFDR, multimap.get(PresidentOfUSA.FRANKLIN_ROOSEVELT));
        assertEquals(expectedBC, multimap.get(PresidentOfUSA.BILL_CLINTON));
    }
}
