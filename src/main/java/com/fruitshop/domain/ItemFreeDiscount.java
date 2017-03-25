package com.fruitshop.domain;

/**
 * Represents an item discount for an item based upon an amount bought threshold
 *
 * Created by barondodd on 25/03/2017.
 */
public class ItemFreeDiscount
{
    private final Item item;

    private final int threshold;

    private final int itemsFree;

    public ItemFreeDiscount(Item item, int threshold, int itemsFree)
    {
        this.item = item;
        this.threshold = threshold;
        this.itemsFree = itemsFree;
    }

    public Double apply(String itemName, long count)
    {
        if (itemName.equals(this.item.getName()))
        {
            long free = (count / threshold) * itemsFree;
            return free * item.getCost().getAmount();
        }
        return 0.0;
    }
}
