package org.example;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Задача 1
        List<Product> products = Arrays.asList(
                new Product("Book", 300, false, LocalDate.now()),
                new Product("Toy", 100, true, LocalDate.now()),
                new Product("Book", 200, true, LocalDate.now())
        );
        List<Product> filteredProducts = products.stream()
                .filter(p -> p.getType().equals("Book") && p.getPrice() > 250).toList();
        System.out.println("Отфильтрованный список продуктов: " + filteredProducts);

        // Задача 2
        List<Product> discountedProducts = products.stream()
                .filter(p -> p.getType().equals("Book") && p.isDiscount())
                .map(p -> new Product(p.getType(), p.getDiscountedPrice(), p.isDiscount(), p.getCreateDate())).toList();
        System.out.println("Список продуктов со скидкой: " + discountedProducts);

        // Задача 3
        Optional<Product> cheapestProduct = products.stream()
                .filter(p -> p.getType().equals("Book"))
                .min(Comparator.comparing(Product::getPrice));
        if (cheapestProduct.isPresent()) {
            System.out.println("Самый дешевый продукт: " + cheapestProduct.get());
        } else {
            throw new RuntimeException("Продукт [категория: Book] не найден");
        }

        // Задача 4
        List<Product> lastThreeProducts = products.stream()
                .sorted(Comparator.comparing(Product::getCreateDate).reversed())
                .limit(3).toList();
        System.out.println("Три последних добавленных продукта: " + lastThreeProducts);

        // Задача 5
        double totalCost = products.stream()
                .filter(p -> p.getCreateDate().getYear() == LocalDate.now().getYear())
                .filter(p -> p.getType().equals("Book"))
                .filter(p -> p.getPrice() <= 75)
                .mapToDouble(Product::getPrice)
                .sum();
        System.out.println("Общая стоимость продуктов: " + totalCost);

        // Задача 6
        Map<String, List<Product>> groupedProducts = products.stream()
                .collect(Collectors.groupingBy(Product::getType));
        System.out.println("Сгруппированные продукты: " + groupedProducts);
    }
}
