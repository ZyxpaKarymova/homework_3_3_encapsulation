import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;

public class App {
    public static void main(String[] args) {
        checkEceptions();
        bestResult();
    }
    public static void checkEceptions() {
        try {
            //Создайте несколько продуктов и нарочно заполните их поля неправильно.
            //Затем обработайте IllegalArgumentException
            // в блоках try и catch
            //В качестве обработки можно просто выводить сообщение из исключения

            SimpleProduct invalidProduct1 = new SimpleProduct("", 500);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            // Цена 0
            SimpleProduct invalidProduct2 = new SimpleProduct("Арбуз", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            // Скидка ниже 0
            DiscountedProduct invalidProduct3 = new DiscountedProduct("Дыня", 100, -5);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

    }

    public static void bestResult() {
        SearchEngine searchEngine = new SearchEngine(10);

        // Добавляем товары и статьи
        searchEngine.add(new SimpleProduct("Арбуз", 150));
        searchEngine.add(new DiscountedProduct("Дыня", 130, 20));
        searchEngine.add(new Article("Когда можно есть арбузы", "Арбузы лучше есть летом в августе."));
        searchEngine.add(new Article("Где растет дыня", "Дыня растет на бахче."));

        // Демонстрация поиска
        try {
            System.out.println("Наиболее подходящий результат для запроса 'арбуз':");
            System.out.println(searchEngine.findBestMatch("Арбуз"));
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            System.out.println("\nНаиболее подходящий результат для запроса 'ананас':");
            System.out.println(searchEngine.findBestMatch("ананас"));
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}





