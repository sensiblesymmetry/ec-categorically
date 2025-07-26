package com.sensiblesymmetry.ecc;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.factory.primitive.IntObjectMaps;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.map.primitive.ImmutableIntObjectMap;
import org.eclipse.collections.api.map.primitive.MutableIntObjectMap;
import org.eclipse.collections.impl.list.primitive.IntInterval;

public enum Generation
{
    UNCLASSIFIED("Unclassified", 1776, 1842),
    PROGRESSIVE("Progressive Generation", 1843, 1859),
    MISSIONARY("Missionary Generation", 1860, 1882),
    LOST("Lost Generation", 1883, 1900),
    GREATEST("Greatest Generation", 1901, 1927),
    SILENT("Silent Generation", 1928, 1945),
    BOOMER("Baby Boomers", 1946, 1964),
    X("Generation X", 1965, 1980),
    MILLENNIAL("Millennials", 1981, 1996),
    Z("Generation Z", 1997, 2012),
    ALPHA("Generation Alpha", 2013, 2029);

    public static final ImmutableList<Generation> ALL =
            Lists.immutable.with(Generation.values());

    private static final ImmutableIntObjectMap<Generation> BY_YEAR =
            Generation.groupEachByYear();

    private static ImmutableIntObjectMap<Generation> groupEachByYear()
    {
        // Build an ImmutableIntObjectMap of year (key) to Generation (value)
        // Loop over all Generations and all years for each Generation
        // Inject the map into each Generation and each year
        // Use withKeyValue to map the year to the Generation
        MutableIntObjectMap<Generation> map = IntObjectMaps.mutable.empty();
        return Generation.ALL.injectInto(
                        map, (map1, generation) ->
                                generation.years().injectInto(
                                        map1, (map2, year) ->
                                                map2.withKeyValue(year, generation)))
                .toImmutable();
    }

    public static Generation find(int year)
    {
        // Original (linear time scan):
        // return ArrayIterate.detectWithIfNone(Generation.values(), Generation::contains, year, UNCLASSIFIED);
        // Optimized (constant time lookup):
        return BY_YEAR.getIfAbsent(year, () -> UNCLASSIFIED);
    }

    private final String name;
    private final IntInterval years;

    Generation(String name, int from, int to)
    {
        this.name = name;
        this.years = IntInterval.fromTo(from, to);
    }

    public IntInterval years()
    {
        return this.years;
    }

    public String getName()
    {
        return this.name;
    }

    public boolean yearsCountEquals(int years)
    {
        return this.years.size() == years;
    }

    public boolean contains(int year)
    {
        return this.years().contains(year);
    }

    public boolean isAfter(int year)
    {
        return this.years.getFirst() > year || this.years.contains(year + 1);
    }

    public boolean isBefore(int year)
    {
        return this.years.getFirst() < year || this.years.contains(year - 1);
    }

    public Iterable<PresidentOfUSA> getPresidentsWhoServed()
    {
        return PresidentOfUSA.ALL
                .select(president -> president.getGenerationsServed()
                        .contains(this));
    }
}
