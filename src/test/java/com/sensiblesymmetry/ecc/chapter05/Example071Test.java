package com.sensiblesymmetry.ecc.chapter05;

import java.util.Optional;

import com.sensiblesymmetry.ecc.Generation;
import org.eclipse.collections.api.list.ImmutableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Example071Test
{
    /**
     * Example 71
     */
    @Test
    public void streamFilterFindFirst()
    {
        ImmutableList<Generation> all = Generation.ALL;

        Optional<Generation> optional1 =
                all.stream()
                        .filter(each -> each.contains(2000))
                        .findFirst();

        assertEquals(Generation.Z, optional1.orElse(Generation.UNCLASSIFIED));

        Optional<Generation> optional2 =
                all.stream()
                        .filter(each -> each.contains(3000))
                        .findFirst();

        assertEquals(Generation.UNCLASSIFIED, optional2.orElse(Generation.UNCLASSIFIED));
    }
}
