package com.sensiblesymmetry.ecc.chapter10;

import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.bag.ImmutableBag;
import org.eclipse.collections.api.factory.Sets;
import org.eclipse.collections.api.multimap.set.SetMultimap;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.tuple.Pair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Example193Test
{
    /**
     * Example 193
     */
    @Test
    public void cartesianProductOfStringsToCreatePlayingCards()
    {
        record Card(String rank, String suit) {}

        ImmutableSet<String> ranks =
                Sets.immutable.with("A,2,3,4,5,6,7,8,9,10,J,Q,K".split(","));

        ImmutableSet<String> suits =
                Sets.immutable.with("SPADES,CLUBS,HEARTS,DIAMONDS".split(","));

        LazyIterable<Pair<String, String>> pairs = ranks.cartesianProduct(suits);

        ImmutableSet<Card> deck =
                pairs.collect(pair -> new Card(pair.getOne(), pair.getTwo()))
                        .toImmutableSet();
        assertEquals(52, deck.size());

        SetMultimap<String, Card> cardsByRank = deck.groupBy(Card::rank);
        assertTrue(cardsByRank.get("2")
                .collect(Card::suit)
                .containsAllIterable(suits));

        SetMultimap<String, Card> cardsBySuit = deck.groupBy(Card::suit);
        assertTrue(cardsBySuit.get("HEARTS")
                .collect(Card::rank)
                .containsAllIterable(ranks));

        ImmutableBag<String> rankCounts = deck.countBy(Card::rank);
        assertEquals(4, rankCounts.occurrencesOf("2"));

        ImmutableBag<String> suitCounts = deck.countBy(Card::suit);
        assertEquals(13, suitCounts.occurrencesOf("CLUBS"));
    }
}
