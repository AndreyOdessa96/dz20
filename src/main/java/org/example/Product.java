package org.example;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

class Product {
    private String type;
    private double price;
    private boolean discount;
    private LocalDate createDate;

    public Product(String type, double price, boolean discount, LocalDate createDate) {
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.createDate = createDate;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isDiscount() {
        return discount;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public double getDiscountedPrice() {
        if (discount) {
            return price * 0.9;
        } else {
            return price;
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", createDate=" + createDate +
                '}';
    }
}
