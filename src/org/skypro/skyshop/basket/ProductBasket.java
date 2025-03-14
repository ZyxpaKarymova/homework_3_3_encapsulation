package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products;
    private int count;

    public ProductBasket() {
        this.products = new Product[5];
        this.count = 0;
    }

    //Метод добавления продукта в корзину: метод принимает в себя продукт и ничего не возвращает.
    public void addProduct(Product product) {
        if (count < products.length) {
            products[count] = product;
            count++;
        } else {
            System.out.println("Невозможно добавить продукт");
        }
    }

    //Метод получения общей стоимости корзины: метод ничего не принимает и возвращает целое число.
    public int getTotalCost() {
        int totalCost = 0;
        for (int i = 0; i < count; i++) {
            totalCost += products[i].getPrice();
        }
        return totalCost;
    }

    //Изменили метод вывода, который печатает содержимое корзины, чтобы результат выводился в следующем виде:
    //<имя продукта>: <стоимость>
    //<имя продукта со скидкой>: <стоимость> (<скидка>%)
    //<имя продукта c фиксированной ценой>: Фиксированная цена <значение константы фиксированной цены>
    //Итого: <общая стоимость корзины>
    //Специальных товаров: <Количество специальных товаров>
    public void printBasket() {
        if (count == 0) {
            System.out.println("в корзине пусто");
        } else {
            int specialCount = 0;
                    for (int i = 0; i < count; i++) {
                        System.out.println(products[i].toString());
                        if (products[i].isSpecial()) {
                            specialCount++;
                        }
                    }
            System.out.println("Итого: " + getTotalCost());
            System.out.println("Специальных товаров: " + specialCount);
        }
    }

    //Метод, проверяющий продукт в корзине по имени: метод принимает в себя строку имени и возвращает boolean
    //в зависимости от того, есть продукт в корзине или его нет.
    public boolean containsProduct(String productName) {
        for (int i = 0; i < count; i++) {
            if (products[i].getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    //Метод очистки корзины: метод ничего не принимает и очищает массив, проставляя всем его элементам null
    public void clearBasket() {
        for (int i = 0; i < count; i++) {
            products[i] = null;
        }
        count = 0;
    }
}

