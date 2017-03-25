package com.fruitshop;

import com.fruitshop.domain.CurrencyAmount;
import com.fruitshop.domain.ItemFreeDiscount;
import com.fruitshop.domain.Item;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Test checkout with some discounts
 *
 * Created by barondodd on 25/03/2017.
 */
public class DiscountTests implements CheckoutTester
{
    private static final ItemFreeDiscount BUY_1_APPLE_1_FREE = new ItemFreeDiscount(Item.APPLE, 2, 1);
    private static final ItemFreeDiscount BUY_2_ORANGE_1_FREE = new ItemFreeDiscount(Item.ORANGE, 3, 1);

    Collection<ItemFreeDiscount> discounts = new ArrayList<>();

    @Test
    public void buyOneGetOneFreeApple()
    {
        discounts.add(BUY_1_APPLE_1_FREE);
        checkAmount(new CurrencyAmount(0.60), "Apple", "Apple");
    }

    @Test
    public void buyOneGetOneFreeAppleWithOtherItems()
    {
        discounts.add(BUY_1_APPLE_1_FREE);
        checkAmount(new CurrencyAmount(1.10), "Apple", "Apple", "Orange", "Orange");
    }

    @Test
    public void buyOneAppleNoDiscount()
    {
        discounts.add(BUY_1_APPLE_1_FREE);
        checkAmount(new CurrencyAmount(0.60), "Apple");
    }

    @Test
    public void buy4Apples2shouldBeFree()
    {
        discounts.add(BUY_1_APPLE_1_FREE);
        checkAmount(new CurrencyAmount(1.20), "Apple", "Apple", "Apple", "Apple");
    }

    @Test
    public void buyThreeGetOneFreeOrange()
    {
        discounts.add(BUY_2_ORANGE_1_FREE);
        checkAmount(new CurrencyAmount(0.50), "Orange", "Orange", "Orange");
    }

    @Test
    public void buyTwoOrangesNoDiscount()
    {
        discounts.add(BUY_2_ORANGE_1_FREE);
        checkAmount(new CurrencyAmount(0.50), "Orange", "Orange");
    }

    @Override
    public Checkout checkoutImpl() {
        return new Checkout(discounts);
    }
}
