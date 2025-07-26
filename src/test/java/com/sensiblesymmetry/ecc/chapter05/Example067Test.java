package com.sensiblesymmetry.ecc.chapter05;

import com.sensiblesymmetry.ecc.Generation;
import org.eclipse.collections.api.list.ImmutableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Example067Test
{
    /**
     * Example 67
     */
    @Test
    public void detectWith()
    {
        ImmutableList<Generation> all = Generation.ALL;

        Generation generation1 = all.detectWith(Generation::contains, 2000);

        assertEquals(Generation.Z, generation1);

        Generation generation2 = all.detectWith(Generation::contains, 3000);

        assertNull(generation2);
    }
}
