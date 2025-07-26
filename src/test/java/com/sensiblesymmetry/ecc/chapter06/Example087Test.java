package com.sensiblesymmetry.ecc.chapter06;

import java.util.List;

import com.sensiblesymmetry.ecc.Generation;
import org.eclipse.collections.api.list.ImmutableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Example087Test
{
    /**
     * Example 87
     */
    @Test
    public void selectGenerationsAfter1980()
    {
        ImmutableList<Generation> all = Generation.ALL;

        ImmutableList<Generation> selected =
                all.select(generation -> generation.isAfter(1980));

        var expected = List.of(Generation.MILLENNIAL, Generation.Z, Generation.ALPHA);
        assertEquals(expected, selected);
    }
}
