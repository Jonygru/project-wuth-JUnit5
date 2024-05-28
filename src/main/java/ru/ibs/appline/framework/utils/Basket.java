package ru.ibs.appline.framework.utils;

import java.util.LinkedList;
import java.util.List;

public class Basket {
    private Integer price = 0;

    public Integer getPrice() {
        return price;
    }

    List<Product> productsInBascet = new LinkedList<>();

    public void increaseBasket(Integer almont) {
        price += almont;
    }

    public List<Product> getProductsInBascet() {
        return productsInBascet;
    }

    public void decreaseBasket(Integer almont) {
        price -= almont;
    }

    public void addProductInBasket(Product product) {
        try {
            productsInBascet.add(product);
            increaseBasket(product.price);
        } catch (NullPointerException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeProductInBasket(String s) {

        for (int i = 0; i < productsInBascet.size(); i++) {

            if (productsInBascet.get(i).getName().equals(s)) {
                productsInBascet.remove(i);
                decreaseBasket(productsInBascet.get(i).price);
                break;
            }

        }
    }
}
