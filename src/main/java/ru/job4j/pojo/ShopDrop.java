package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] leftShift(Product[] products, int index) {
            if (index <= products.length - 1) {
                products[index] = products[products.length - 1];
                products[products.length - 1] = null;
            }
        return products;
    }
}
