package com.fruitshop;

import com.fruitshop.domain.CurrencyAmount;
import org.junit.Test;

/**
 * Tests basic checkout sums
 *
 * Created by barondodd on 25/03/2017.
 */
public class BasicCheckoutTest implements CheckoutTester
{
    @Test
    public void checkout1Item()
    {
        checkAmount(new CurrencyAmount("£", 0.60), "Apple");
    }

    @Test
    public void checkout2Items()
    {
        checkAmount(new CurrencyAmount("£", 0.85), "Apple", "Orange");
    }

    @Test
    public void checkout2ItemsOfSameType()
    {
        checkAmount(new CurrencyAmount("£", 1.20), "Apple", "Apple");
    }

    @Test
    public void checkoutExampleInSpec()
    {
        checkAmount(new CurrencyAmount("£", 2.05), "Apple", "Apple", "Orange", "Apple");
    }

    @Override
    public Checkout checkoutImpl()
    {
        return new Checkout();
    }
}
