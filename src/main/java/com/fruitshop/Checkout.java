package com.fruitshop;

import com.fruitshop.domain.CurrencyAmount;
import com.fruitshop.domain.ItemFreeDiscount;
import com.fruitshop.domain.Item;
import org.apache.commons.lang3.Validate;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

/**
 * A checkout for items.
 *
 * Created by barondodd on 25/03/2017.
 */
public class Checkout
{
    private final Collection<ItemFreeDiscount> discounts;

    public Checkout()
    {
        this.discounts = Collections.EMPTY_LIST;
    }

    public Checkout(Collection<ItemFreeDiscount> discounts)
    {
        this.discounts = discounts;
    }

    /**
     * Calculate the cost of a list of 1 to many items.
     *
     * @param itemNames a list of item names to checkout.
     * @return a currency amount representing the sum of the items costs.
     */
    public CurrencyAmount tallyItems(String... itemNames)
    {
        Validate.notEmpty(itemNames);

        Double sum = stream(itemNames)
                .mapToDouble(itemName-> Item.of(itemName).getCost().getAmount())
                .sum();

        if (!discounts.isEmpty())
        {
            sum -= calculateDiscount(itemNames);
        }

        return new CurrencyAmount(sum);
    }

    private Double calculateDiscount(String... itemNames)
    {
        /*
         * discount logic based on assumption that you would need to audit the total amount and discount separate,
         * not simply remove items.
         *
         * (would be more efficient (less loops) to simply running count the items and inline remove them each time
         * discount threshold triggered).
         */
        Double saving = 0.00;

        /*
         * 2nd and final pass through all items, cheaper than passing whole item list though every discount.
         */
        Map<String, Long> itemCounts = stream(itemNames)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (ItemFreeDiscount discount : discounts)
        {
            for (String itemName : itemCounts.keySet())
            {
                saving += discount.apply(itemName, itemCounts.get(itemName));
            }
        }
        return saving;
    }
}
