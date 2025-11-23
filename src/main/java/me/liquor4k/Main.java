package me.liquor4k;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("ТЕСТИРОВАНИЕ КЛАССА PRODUCT");

        // Создаем тестовые товары
        Product product1 = new Product(1001, "iPhone 15", 999, "Смартфоны");
        Product product2 = new Product(1001, "iPhone 15 Pro", 1299, "Смартфоны");
        Product product3 = new Product(1001, "iPhone 15", 999, "Электроника");
        Product product4 = new Product(2001, "MacBook Air", 1199, "Ноутбуки");
        Product product5 = new Product(1001, "iPhone 15", 999, "Смартфоны");

        // Выводим товары на экран
        System.out.println("Товар 1: " + product1);
        System.out.println("Товар 2: " + product2);
        System.out.println("Товар 3: " + product3);
        System.out.println("Товар 4: " + product4);
        System.out.println("Товар 5: " + product5);

        // Тестируем сравнение товаров
        System.out.println("\nРезультаты сравнения товаров:");
        System.out.println("product1.equals(product2): " + product1.equals(product2)); // true (одинаковые id и category)
        System.out.println("product1.equals(product3): " + product1.equals(product3)); // false (разные category)
        System.out.println("product1.equals(product4): " + product1.equals(product4)); // false (разные id)
        System.out.println("product1.equals(product5): " + product1.equals(product5)); // true (одинаковые id и category)
        System.out.println("product1.equals(null): " + product1.equals(null)); // false

        System.out.println("\nТЕСТИРОВАНИЕ КЛАССА ORDER");

        // Создаем массивы товаров для заказов
        Product[] basket1 = {product1, product4};
        Product[] basket2 = {product2, product4}; // product2 имеет те же id и category что и product1
        Product[] basket3 = {product1, product4};
        Product[] basket4 = {product4, product1}; // другой порядок
        Product[] basket5 = {product1};

        // Создаем заказы
        Order order1 = new Order("Иван Иванов", basket1);
        Order order2 = new Order("Иван Иванов", basket2);
        Order order3 = new Order("Иван Иванов", basket3);
        Order order4 = new Order("Петр Петров", basket1);
        Order order5 = new Order("Иван Иванов", basket4);
        Order order6 = new Order("Иван Иванов", basket5);

        // Выводим заказы на экран
        System.out.println("Заказ 1: " + order1);
        System.out.println("Заказ 2: " + order2);
        System.out.println("Заказ 3: " + order3);
        System.out.println("Заказ 4: " + order4);
        System.out.println("Заказ 5: " + order5);
        System.out.println("Заказ 6: " + order6);

        // Тестируем сравнение заказов
        System.out.println("\nРезультаты сравнения заказов:");
        System.out.println("order1.equals(order2): " + order1.equals(order2)); // true (товары равны по equals)
        System.out.println("order1.equals(order3): " + order1.equals(order3)); // true
        System.out.println("order1.equals(order4): " + order1.equals(order4)); // false (разные customer)
        System.out.println("order1.equals(order5): " + order1.equals(order5)); // false (разный порядок товаров)
        System.out.println("order1.equals(order6): " + order1.equals(order6)); // false (разное количество товаров)
        System.out.println("order1.equals(null): " + order1.equals(null)); // false

        // Тестирование с null значениями
        System.out.println("\n=== ТЕСТИРОВАНИЕ С NULL ЗНАЧЕНИЯМИ ===");

        Product productWithNull = new Product(3001, null, 500, null);
        Product productWithNull2 = new Product(3001, "Тестовый товар", 500, null);

        System.out.println("Товар с null: " + productWithNull);
        System.out.println("Товар с null2: " + productWithNull2);
        System.out.println("productWithNull.equals(productWithNull2): " +
                productWithNull.equals(productWithNull2)); // true (одинаковые id и category=null)

        Product[] basketWithNull = {productWithNull, null};
        Order orderWithNull = new Order(null, basketWithNull);
        Order orderWithNull2 = new Order(null, basketWithNull);

        System.out.println("Заказ с null: " + orderWithNull);
        System.out.println("orderWithNull.equals(orderWithNull2): " +
                orderWithNull.equals(orderWithNull2)); // true
    }
}