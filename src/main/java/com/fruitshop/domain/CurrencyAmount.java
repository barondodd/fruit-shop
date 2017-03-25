package com.fruitshop.domain;

import org.apache.commons.lang3.Validate;

/**
 * An amount of money in a given currency.
 *
 * Created by barondodd on 25/03/2017.
 */
public class CurrencyAmount
{
    private static final String DEFAULT_CURRENCY = "£";

    private final String symbol;

    private final Double amount;

    public CurrencyAmount(Double amount)
    {
        this(DEFAULT_CURRENCY, amount);
    }

    public CurrencyAmount(String symbol, Double amount)
    {
        Validate.notNull(symbol, "Symbol is required");
        Validate.notNull(amount, "Amount is required");
        this.symbol = symbol;
        this.amount = amount;
    }

    public Double getAmount()
    {
        return amount;
    }

    @Override
    public String toString()
    {
        return symbol + amount;
    }

    // IDEA generated methods
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurrencyAmount that = (CurrencyAmount) o;

        if (symbol != null ? !symbol.equals(that.symbol) : that.symbol != null) return false;
        return amount != null ? amount.equals(that.amount) : that.amount == null;
    }

    @Override
    public int hashCode()
    {
        int result = (symbol != null) ? symbol.hashCode() : 0;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }
}
