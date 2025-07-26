package com.sensiblesymmetry.ecc.chapter11;

import java.util.List;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.MutableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Example195Test
{
    /**
     * Example 195
     */
    @Test
    public void eagerMutableObjectCollection()
    {
        MutableList<Integer> integers = Lists.mutable.with(1, 2, 3, 4, 5);

        MutableList<String> actual =
                integers.select(each -> each % 2 == 0)
                        .collect(Object::toString);

        List<String> expected = List.of("2", "4");
        assertEquals(expected, actual);
    }
}
