package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductBasket {
    private final Map<String, List<Product>> productsMap;

    public ProductBasket() {
        this.productsMap = new HashMap<>();
    }

    public void addProduct(Product product) {
        String name = product.getName();
        if (!productsMap.containsKey(name)) {
            productsMap.put(name, new ArrayList<>());
        }
        productsMap.get(name).add(product);
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = productsMap.remove(name);
        return removedProducts != null ? removedProducts : new ArrayList<>();
    }
    public int getTotalCost() {
        int totalCost = 0;
        for (List<Product> products : productsMap.values()) {
            for (Product product : products) {
                totalCost += product.getPrice();
            }
        }
        return totalCost;
    }

    public void printBasket() {
        if (productsMap.isEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            for (List<Product> products : productsMap.values()) {
                for (Product product : products) {
                    System.out.println(product);
                }
            }
            System.out.println("Итого: " + getTotalCost());
        }
    }

    public boolean containsProduct(String productName) {
        return productsMap.containsKey(productName);
    }

    public void clearBasket() {
        productsMap.clear();
    }
}

