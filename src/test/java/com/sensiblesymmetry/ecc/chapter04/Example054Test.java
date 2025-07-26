package com.sensiblesymmetry.ecc.chapter04;

import com.sensiblesymmetry.ecc.Generation;
import com.sensiblesymmetry.ecc.PresidentOfUSA;
import org.eclipse.collections.api.list.ImmutableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class Example054Test
{
    /**
     * Example 54
     */
    @Test
    public void mapAndAnyMatch()
    {
        ImmutableList<PresidentOfUSA> all = PresidentOfUSA.ALL;

        boolean anyPresidentBornInGenerationX =
                all.stream()
                        .map(PresidentOfUSA::getBirthGeneration)
                        .anyMatch(Generation.X::equals);

        assertFalse(anyPresidentBornInGenerationX);
    }
}
