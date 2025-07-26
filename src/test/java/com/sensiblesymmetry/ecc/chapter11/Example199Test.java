package com.sensiblesymmetry.ecc.chapter11;

import java.util.List;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.MutableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Example199Test
{
    /**
     * Example 199
     */
    @Test
    public void lazyMutableObjectCollection()
    {
        MutableList<Integer> integers = Lists.mutable.with(1, 2, 3, 4, 5);

        MutableList<String> actual = integers.asLazy()
                .select(each -> each % 2 == 0)
                .collect(Object::toString)
                .toList();

        List<String> expected = List.of("2", "4");
        assertEquals(expected, actual);
    }
}
