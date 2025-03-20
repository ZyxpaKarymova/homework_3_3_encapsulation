package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static int FIXED_PRICE = 200; // Пример фиксированной цены

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public int getPrice() {
        return FIXED_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public String getContentType() {
        return "FIX_PRICE_PRODUCT";
    }

    @Override
    public String toString() {
        return getName() + " (" + getContentType() + "): Фиксированная цена " + FIXED_PRICE;
    }
}
