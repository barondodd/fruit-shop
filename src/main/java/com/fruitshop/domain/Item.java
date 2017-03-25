package com.fruitshop.domain;

import static java.util.Arrays.stream;

/**
 * Inventory of different items for sale
 *
 * Created by barondodd on 25/03/2017.
 */
public enum Item
{
    APPLE("Apple", new CurrencyAmount(0.60)),
    ORANGE("Orange", new CurrencyAmount(0.25));

    private final String name;

    private final CurrencyAmount cost;

    Item(String name, CurrencyAmount cost)
    {
        this.name = name;
        this.cost = cost;
    }

    public String getName()
    {
        return name;
    }

    public CurrencyAmount getCost()
    {
        return cost;
    }

    public static Item of(String name)
    {
        return stream(values())
                .filter(item -> name.toUpperCase().equals(item.getName().toUpperCase()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Unknown item: %s", name)));
    }
}
