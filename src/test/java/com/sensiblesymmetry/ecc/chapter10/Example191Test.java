package com.sensiblesymmetry.ecc.chapter10;

import java.util.Set;

import com.sensiblesymmetry.ecc.Generation;
import com.sensiblesymmetry.ecc.PresidentOfUSA;
import org.eclipse.collections.api.factory.Sets;
import org.eclipse.collections.api.set.ImmutableSet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Example191Test
{
    /**
     * Example 191
     */
    @Test
    public void symmetricDifferenceOfGenZAndGenAlphaPresidents()
    {
        Iterable<PresidentOfUSA> genZIterable = Generation.Z.getPresidentsWhoServed();
        ImmutableSet<PresidentOfUSA> genZSet = Sets.immutable.ofAll(genZIterable);
        Iterable<PresidentOfUSA> genAlphaIterable =
                Generation.ALPHA.getPresidentsWhoServed();
        ImmutableSet<PresidentOfUSA> genAlphaSet =
                Sets.immutable.ofAll(genAlphaIterable);

        ImmutableSet<PresidentOfUSA> symmetricDifference =
                genZSet.symmetricDifference(genAlphaSet);

        ImmutableSet<PresidentOfUSA> intersection = genZSet.intersect(genAlphaSet);

        var expectedGenZSet =
                Set.of(PresidentOfUSA.BILL_CLINTON,
                        PresidentOfUSA.GEORGE_W_BUSH,
                        PresidentOfUSA.BARACK_OBAMA);
        assertEquals(expectedGenZSet, genZSet);

        var expectedGenAlphaSet =
                Set.of(PresidentOfUSA.BARACK_OBAMA,
                        PresidentOfUSA.DONALD_TRUMP,
                        PresidentOfUSA.JOE_BIDEN);
        assertEquals(expectedGenAlphaSet, genAlphaSet);

        var expectedSymmetricDifference =
                Set.of(PresidentOfUSA.BILL_CLINTON, PresidentOfUSA.GEORGE_W_BUSH,
                        PresidentOfUSA.DONALD_TRUMP, PresidentOfUSA.JOE_BIDEN);
        assertEquals(expectedSymmetricDifference, symmetricDifference);

        var expectedIntersection = Set.of(PresidentOfUSA.BARACK_OBAMA);
        assertEquals(expectedIntersection, intersection);
    }
}
