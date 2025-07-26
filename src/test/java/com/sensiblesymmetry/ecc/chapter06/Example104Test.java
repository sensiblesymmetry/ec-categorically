package com.sensiblesymmetry.ecc.chapter06;

import com.sensiblesymmetry.ecc.Generation;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.partition.list.PartitionImmutableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Example104Test
{
    /**
     * Example 104
     */
    @Test
    public void partitionGenerationsAfter1980()
    {
        ImmutableList<Generation> all = Generation.ALL;

        PartitionImmutableList<Generation> partitioned =
                all.partition(generation -> generation.isAfter(1980));

        ImmutableList<Generation> selected = partitioned.getSelected();
        ImmutableList<Generation> rejected = partitioned.getRejected();

        ImmutableList<Generation> expectedSelected =
                all.select(generation -> generation.isAfter(1980));
        ImmutableList<Generation> expectedRejected =
                all.reject(generation -> generation.isAfter(1980));
        assertEquals(expectedSelected, selected);
        assertEquals(expectedRejected, rejected);
    }
}
