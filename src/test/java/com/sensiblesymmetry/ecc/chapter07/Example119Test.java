package com.sensiblesymmetry.ecc.chapter07;

import com.sensiblesymmetry.ecc.Generation;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.list.ImmutableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Example119Test
{
    /**
     * Example 119
     */
    @Test
    public void lazySelectWithAndCollect()
    {
        ImmutableList<Generation> all = Generation.ALL;

        LazyIterable<Generation> lazy = all.asLazy();
        String names = lazy.selectWith(Generation::isAfter, 2000)
                .collect(Generation::getName)
                .makeString();

        assertEquals("Generation Z, Generation Alpha", names);
    }
}
