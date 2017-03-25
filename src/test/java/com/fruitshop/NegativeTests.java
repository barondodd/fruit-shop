package com.fruitshop;

import com.fruitshop.domain.CurrencyAmount;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Negative tests for checkout and domain objects
 *
 * Created by barondodd on 25/03/2017.
 */
public class NegativeTests  implements CheckoutTester
{

    @Test
    public void checkoutNullItems()
    {
        // this one is debatable?
        try
        {
            checkAmount(new CurrencyAmount("£", 0.00), (String) null);
            fail("Was able to checkout null items");
        }
        catch (NullPointerException e)
        {
            // expected
        }
    }

    @Test
    public void checkoutNoItemsAtAll()
    {
        // this one is debatable?
        try
        {
            checkAmount(new CurrencyAmount(0.00));
            fail("Was able to checkout zero items");
        }
        catch (IllegalArgumentException e)
        {
            // expected
        }
    }

    @Test
    public void checkoutUnknownItem()
    {
        // TODO create checked exception for this case?
        try
        {
            checkAmount(new CurrencyAmount(0.00), "Banana!");
            fail("Was able to checkout an unknown item");
        }
        catch (IllegalArgumentException e)
        {
            // expected
        }
    }

    @Test
    public void testNullSymbol()
    {
        try
        {
            new CurrencyAmount(null, 0.60);
            fail("Was able to create currency amount with null symbol");
        }
        catch(NullPointerException npe)
        {
            // expected
        }
    }

    @Test
    public void testNullAmount()
    {
        try
        {
            new CurrencyAmount("$", null);
            fail("Was able to create currency amount with null amount");
        }
        catch(NullPointerException npe)
        {
            // expected
        }
    }

    @Override
    public Checkout checkoutImpl() {
        return new Checkout();
    }
}
