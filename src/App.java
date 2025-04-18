import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;

public class App {
    public static void main(String[] args) {
        changedToStreams();
    }

    public static void changedToStreams() {
        // Создаем SearchEngine
        ProductBasket basket = new ProductBasket();

        basket.addProduct(new SimpleProduct("Арбуз", "Фрукт", 150));
        basket.addProduct(new DiscountedProduct("Манго", "Фрукт", 130, 5));

        System.out.println("Содержимое корзины:");
        basket.printBasket();

        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(new SimpleProduct("Арбуз", "Фрукт", 150));
        searchEngine.add(new DiscountedProduct("Манго египетское", "Фрукт", 130, 5));
        searchEngine.add(new Article("Когда можно есть арбуз", "Арбуз можно есть в августе."));
        searchEngine.add(new Article("Где растет дыня", "Дыня растет на бахче."));
        searchEngine.add(new Article("Соки из фруктов", "Сок можно делать из разных фруктов."));
        searchEngine.add(new Article("Польза фруктов", "Фрукты вкусны и полезны."));

        System.out.println("\nРезультаты поиска по 'фрукт':");
        searchEngine.search("фрукт").forEach(System.out::println);
    }


}



