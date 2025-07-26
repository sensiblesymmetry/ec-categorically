package com.sensiblesymmetry.ecc;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.multimap.list.ImmutableListMultimap;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.impl.list.primitive.IntInterval;

public enum PresidentOfUSA
{
    // Name, Birth Year, First Year Elected, Last Year in Office
    THEODORE_ROOSEVELT("Theodore Roosevelt", 1858, 1901, 1909),
    WILLIAM_TAFT("William Howard Taft", 1857, 1909, 1913),
    WOODROW_WILSON("Woodrow Wilson", 1856, 1913, 1921),
    WARREN_G_HARDING("Warren G. Harding", 1865, 1921, 1923),
    CALVIN_COOLIDGE("Calvin Coolidge", 1872, 1923, 1929),
    HERBERT_HOOVER("Herbert Hoover", 1874, 1929, 1933),
    FRANKLIN_ROOSEVELT("Franklin D. Roosevelt", 1882, 1933, 1945),
    HARRY_TRUMAN("Harry S. Truman", 1884, 1945, 1953),
    DWIGHT_EISENHOWER("Dwight D. Eisenhower", 1890, 1953, 1961),
    JOHN_KENNEDY("John F. Kennedy", 1917, 1961, 1963),
    LYNDON_JOHNSON("Lyndon B. Johnson", 1908, 1963, 1969),
    RICHARD_NIXON("Richard M. Nixon", 1913, 1969, 1974),
    GERALD_FORD("Gerald R. Ford", 1913, 1974, 1977),
    JIMMY_CARTER("Jimmy Carter", 1924, 1977, 1981),
    RONALD_REAGAN("Ronald Reagan", 1911, 1981, 1989),
    GEORGE_BUSH("George H.W. Bush", 1924, 1989, 1993),
    BILL_CLINTON("William J. Clinton", 1946, 1993, 2001),
    GEORGE_W_BUSH("George W. Bush", 1946, 2001, 2009),
    BARACK_OBAMA("Barack Obama", 1961, 2009, 2017),
    DONALD_TRUMP("Donald J. Trump", 1946, 2017, 2021),
    JOE_BIDEN("Joseph R. Biden, Jr.", 1942, 2021, 2025);

    public static final ImmutableList<PresidentOfUSA> ALL =
            Lists.immutable.with(PresidentOfUSA.values());

    private static final ImmutableListMultimap<Generation, PresidentOfUSA> BORN_IN =
            ALL.groupBy(PresidentOfUSA::getBirthGeneration);

    public static ImmutableList<PresidentOfUSA> bornIn(Generation generation)
    {
        return BORN_IN.get(generation);
    }

    private final String name;
    private final int birthYear;
    private final IntInterval years;

    PresidentOfUSA(String name, int birthYear, int firstYearElected, int lastYearInOffice)
    {
        this.name = name;
        this.birthYear = birthYear;
        this.years = IntInterval.fromTo(firstYearElected, lastYearInOffice);
    }

    public int getBirthYear()
    {
        return birthYear;
    }

    public String getName()
    {
        return this.name;
    }

    public int getYearsServed()
    {
        return this.years.size() - 1;
    }

    public IntInterval years()
    {
        return years;
    }

    public Generation getBirthGeneration()
    {
        return Generation.find(this.getBirthYear());
    }

    public boolean birthGenerationEquals(Generation generation)
    {
        return this.getBirthGeneration().equals(generation);
    }

    public Generation getFirstGenerationServed()
    {
        return Generation.find(this.years.getFirst());
    }

    public ImmutableSet<Generation> getGenerationsServed()
    {
        return this.years.collect(Generation::find)
                .toImmutableSet();
    }
}
