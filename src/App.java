import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

public class App {
    public static void main(String[] args) {
        // Создаем несколько продуктов
        SimpleProduct product1 = new SimpleProduct("Арбуз", 250);
        DiscountedProduct product2 = new DiscountedProduct("Дыня", 230, 10);
        FixPriceProduct product3 = new FixPriceProduct("Мандарин");

        Article article1 = new Article("Когда можно есть арбузы", "Арбузы лучше есть летом в августе");
        Article article2 = new Article("Где растет дыня", "Дыня растет на бахче.");

        // Создаем SearchEngine
        SearchEngine searchEngine = new SearchEngine(10);

        // Добавляем товары и статьи в SearchEngine
        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(article1);
        searchEngine.add(article2);

        // Демонстрация поиска
        System.out.println("Результаты поиска по запросу 'арбуз':");
        Searchable[] results = searchEngine.search("Арбуз");
        for (Searchable result : results) {
            if (result != null) {
                System.out.println(result.getStringRepresentation());
            }
        }
        System.out.println("\nРезультаты поиска по запросу 'дыня':");
        results = searchEngine.search("Дыня");
        for (Searchable result : results) {
            if (result != null) {
                System.out.println(result.getStringRepresentation());
            }
        }
    }
}


