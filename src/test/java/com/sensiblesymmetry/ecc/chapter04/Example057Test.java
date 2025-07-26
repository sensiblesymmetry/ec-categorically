package com.sensiblesymmetry.ecc.chapter04;

import com.sensiblesymmetry.ecc.Generation;
import com.sensiblesymmetry.ecc.PresidentOfUSA;
import org.eclipse.collections.api.list.ImmutableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class Example057Test
{
    /**
     * Example 57
     */
    @Test
    public void containsBy()
    {
        ImmutableList<PresidentOfUSA> all = PresidentOfUSA.ALL;

        boolean anyPresidentBornInGenerationX =
                all.containsBy(
                        PresidentOfUSA::getBirthGeneration,
                        Generation.X);

        assertFalse(anyPresidentBornInGenerationX);
    }
}
