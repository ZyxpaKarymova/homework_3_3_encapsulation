package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    private final String name;
    public final String description;

    public Product(String name, String description) {
        if (name==null || name.isBlank()){
            throw new IllegalArgumentException ("Название продукта не может быть пустой строкой или null");
        }
        this.name = name;
        this.description=description;
           }

    public String getName() {
        return name;
    }
     public String getDescription(){
        return description;
    }

       public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String getSearchTerm() {
        return getName().toLowerCase()+" "+getDescription().toLowerCase();
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String toString() {
        return getName() + " (" + getContentType() + ")";
    }
}
