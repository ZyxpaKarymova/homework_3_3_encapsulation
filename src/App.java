import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Set;

public class App {
    public static void main(String[] args) {
        changedSearchEngine();
    }

    public static void changedSearchEngine() {
        // Создаем SearchEngine
        SearchEngine searchEngine = new SearchEngine();

        // Добавляем товары и статьи
        searchEngine.add(new SimpleProduct("Яблоко", "Фрукт", 150));
        searchEngine.add(new DiscountedProduct("Манго", "Фрукт", 130, 5));
        searchEngine.add(new Article("Когда можно есть арбуз", "Арбуз можно есть в августе."));
        searchEngine.add(new Article("Где растет дыня", "Дыня растет на бахче."));
        searchEngine.add(new Article("Сок из фруктов", "Сок можно делать из разных фруктов."));
        searchEngine.add(new Article("Польза фруктов", "Фрукты вкусны и полезны."));


        // добавляем дубликат
        searchEngine.add(new Article("Когда можно есть арбуз", "Арбуз можно есть летом."));
        searchEngine.add(new SimpleProduct("Яблоко", "Свежий фрукт", 180));

        System.out.println("Результаты поиска по 'фрукт':");
        printSearchResults(searchEngine.search("фрукт"));

        System.out.println("Результаты поиска по 'арбуз':");
        printSearchResults(searchEngine.search("арбуз"));
    }

    private static void printSearchResults(Set<Searchable> results) {
        if (results.isEmpty()) {
            System.out.println("Ничего не найдено");
            return;
        }
        for (Searchable result : results) {
            System.out.println("- " + result);
        }
    }
}



