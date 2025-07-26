package com.sensiblesymmetry.ecc.chapter02;

import java.util.List;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.factory.primitive.IntLists;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.primitive.ImmutableIntList;
import org.eclipse.collections.api.list.primitive.IntList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Example014Test
{
    /**
     * Example 14
     */
    @Test
    public void immutableList()
    {
        ImmutableList<Integer> immutableList = Lists.immutable.with(1, 2, 3);
        ImmutableList<Integer> evens = immutableList.select(each -> each % 2 == 0);

        List<Integer> expectedEvens = List.of(2);
        assertEquals(expectedEvens, evens);

        ImmutableIntList evenInts = evens.collectInt(Integer::intValue);

        IntList expectedInts = IntLists.mutable.with(2);
        assertEquals(expectedInts, evenInts);
    }
}
