import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        // Создаем несколько продуктов
        Product product1 = new Product("Арбуз", 250);
        Product product2 = new Product("Дыня", 230);
        Product product3 = new Product("Мандарин", 170);

        // Создаем корзину
        ProductBasket basket = new ProductBasket();

        // Добавляем продукты в корзину
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);

        // Пытаемся добавить продукт в заполненную корзину
        basket.addProduct(new Product("Колбаса", 260));
        basket.addProduct(new Product("Бекон", 130));
        basket.addProduct(new Product("Сосиски", 170)); // Невозможно добавить продукт

        // Печать содержимого корзины
        basket.printBasket();

        // Получение общей стоимости корзины
        System.out.println("Общая стоимость корзины: " + basket.getTotalCost());
        // Поиск товара, который есть в корзине
        System.out.println("Есть ли в корзине Арбуз? " + basket.containsProduct("Арбуз"));

        // Поиск товара, которого нет в корзине
        System.out.println("Есть ли в корзине Манго? " + basket.containsProduct("Манго"));

        // Очистка корзины
        basket.clearBasket();

        // Печать содержимого пустой корзины
        basket.printBasket();
        // Получение стоимости пустой корзины
        System.out.println("Общая стоимость пустой корзины: " + basket.getTotalCost());

        // Поиск товара по имени в пустой корзине
        System.out.println("Есть ли в корзине Арбуз? " + basket.containsProduct("Арбуз"));
    }
}
