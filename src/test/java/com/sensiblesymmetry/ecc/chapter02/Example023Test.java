package com.sensiblesymmetry.ecc.chapter02;

import java.util.List;

import org.eclipse.collections.api.factory.primitive.IntLists;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.primitive.ImmutableIntList;
import org.eclipse.collections.api.list.primitive.IntList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Example023Test
{
    /**
     * Example 23
     */
    @Test
    public void immutableIntList()
    {
        ImmutableIntList immutableIntlist = IntLists.immutable.with(1, 2, 3);
        ImmutableIntList evenInts = immutableIntlist.select(each -> each % 2 == 0);

        IntList expectedEvens = IntLists.mutable.with(2);
        assertEquals(expectedEvens, evenInts);

        ImmutableList<Integer> evenIntegers = evenInts.collect(Integer::valueOf);

        List<Integer> expectedIntegers = List.of(2);
        assertEquals(expectedIntegers, evenIntegers);
    }
}
