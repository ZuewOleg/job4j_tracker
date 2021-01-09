package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] leftShift(Product[] products, int index) {
        for (int i = 0; i < products.length - 1; i++) {
            if (products[i].equals(products[index])) {
                products[i] = products[index + 1];
                products[index + 1] = null;
            } else {
                products[index] = null;
            }
        }
        return products;
    }
}
