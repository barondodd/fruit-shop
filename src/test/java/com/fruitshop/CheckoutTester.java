package com.fruitshop;

import com.fruitshop.domain.CurrencyAmount;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Test class which exercises a <code>Checkout</code>
 *
 * Created by barondodd on 25/03/2017.
 */
public interface CheckoutTester
{
    default void checkAmount(CurrencyAmount expectedTotal, String... items)
    {
        CurrencyAmount total = new Checkout().tallyItems(items);
        assertThat("Checkout total did not match", total, equalTo(expectedTotal));
    }
}
