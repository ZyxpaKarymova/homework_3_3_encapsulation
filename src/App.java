import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        // Создаем несколько продуктов
        SimpleProduct product1 = new SimpleProduct("Арбуз", 250);
        DiscountedProduct product2 = new DiscountedProduct("Дыня", 230, 10);
        FixPriceProduct product3 = new FixPriceProduct("Мандарин");

        // Создаем корзину
        ProductBasket basket = new ProductBasket();

        // Добавляем продукты в корзину
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);

        // Печать содержимого корзины
        basket.printBasket();

        // Получение общей стоимости корзины
        System.out.println("Общая стоимость корзины: " + basket.getTotalCost());

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
