import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.List;

public class App {
    public static void main(String[] args) {
        listDemonstaration();
        changedSearchEngine();
    }


    public static void listDemonstaration() {
        // Создаем корзину
        ProductBasket basket = new ProductBasket();
        // Добавляем товары
        basket.addProduct(new SimpleProduct("Арбуз", 150));
        basket.addProduct(new DiscountedProduct("Дыня", 130, 10));
        basket.addProduct(new FixPriceProduct("Манго"));

        // Печать содержимого корзины
        System.out.println("Содержимое корзины:");
        basket.printBasket();

        // Удаляем продукт по имени
        System.out.println("\nУдаляем продукт 'Арбуз':");
        List<Product> removedProducts = basket.removeProductsByName("Арбуз");
        if (removedProducts.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            System.out.println("Удаленные продукты:");
            for (Product product : removedProducts) {
                System.out.println(product);
            }
        }
        // Печать содержимого корзины после удаления
        System.out.println("\nСодержимое корзины после удаления:");
        basket.printBasket();

        // Попытка удалить несуществующий продукт
        System.out.println("\nУдаляем продукт 'Гуава':");
        removedProducts = basket.removeProductsByName("Гуава");
        if (removedProducts.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            System.out.println("Удаленные продукты:");
            for (Product product : removedProducts) {
                System.out.println(product);
            }
        }

        // Печать содержимого корзины после удаления
        System.out.println("\nСодержимое корзины после удаления:");
        basket.printBasket();

    }

    public static void changedSearchEngine() {
        // Создаем SearchEngine
        SearchEngine searchEngine = new SearchEngine();

        // Добавляем товары и статьи
        searchEngine.add(new SimpleProduct("Арбуз", 150));
        searchEngine.add(new DiscountedProduct("Дыня", 130, 5));
        searchEngine.add(new Article("Когда можно есть арбуз", "Арбуз можно есть в августе."));
        searchEngine.add(new Article("Где растет дыня", "Дыня растет на бахче."));

        // Демонстрация поиска
        System.out.println("Результаты поиска по запросу 'арбуз':");
        List<Searchable> results = searchEngine.search("Арбуз");
        for (Searchable result : results) {
            System.out.println(result);
        }

        System.out.println("\nРезультаты поиска по запросу 'дыня':");
        results = searchEngine.search("Дыня");
        for (Searchable result : results) {
            System.out.println(result);
        }
        System.out.println("\nРезультаты поиска по запросу 'манго':");
        results = searchEngine.search("манго");
        if (results.isEmpty()) {
            System.out.println("Ничего не найдено.");
        } else {
            for (Searchable result : results) {
                System.out.println(result);
            }
        }
    }
}

