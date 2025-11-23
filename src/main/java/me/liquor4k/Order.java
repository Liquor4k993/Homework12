package me.liquor4k;

import java.util.Arrays;
import java.util.Objects;

public class Order {
    private String customer;
    private Product[] basket;

    public Order(String customer, Product[] basket) {
        this.customer = customer;
        this.basket = basket;
    }

    @Override
    public String toString() {
        return "Order[customer=" + customer + ", basket=" + Arrays.toString(basket) + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Order order = (Order) obj;

        // Сравниваем customer
        if (!Objects.equals(customer, order.customer)) {
            return false;
        }

        // Сравниваем массивы товаров
        if (basket == null && order.basket == null) {
            return true;
        }
        if (basket == null || order.basket == null) {
            return false;
        }
        if (basket.length != order.basket.length) {
            return false;
        }

        // Поэлементное сравнение товаров с учетом порядка
        for (int i = 0; i < basket.length; i++) {
            Product product1 = basket[i];
            Product product2 = order.basket[i];

            if (product1 == null && product2 == null) {
                continue;
            }
            if (product1 == null || product2 == null) {
                return false;
            }
            if (!product1.equals(product2)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(customer);
        result = 31 * result + Arrays.hashCode(basket);
        return result;
    }

    // Геттеры
    public String getCustomer() {
        return customer;
    }
    public Product[] getBasket() {
        return basket;
    }
}

