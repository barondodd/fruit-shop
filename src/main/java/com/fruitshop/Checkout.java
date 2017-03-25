package com.fruitshop;

import com.fruitshop.domain.CurrencyAmount;
import com.fruitshop.domain.Item;
import org.apache.commons.lang3.Validate;

import static java.util.Arrays.stream;

/**
 * A checkout for items.
 *
 * Created by barondodd on 25/03/2017.
 */
public class Checkout
{
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

        return new CurrencyAmount(sum);
    }
}
