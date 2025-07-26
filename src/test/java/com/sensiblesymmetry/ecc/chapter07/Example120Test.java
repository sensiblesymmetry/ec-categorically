package com.sensiblesymmetry.ecc.chapter07;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.sensiblesymmetry.ecc.Generation;
import org.eclipse.collections.api.list.ImmutableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Example120Test
{
    /**
     * Example 120
     */
    @Test
    public void lazyFilterAndMap()
    {
        ImmutableList<Generation> all = Generation.ALL;

        Stream<Generation> lazy = all.stream();
        String names = lazy.filter(generation -> generation.isAfter(2000))
                .map(Generation::getName)
                .collect(Collectors.joining(", "));

        assertEquals("Generation Z, Generation Alpha", names);
    }
}
