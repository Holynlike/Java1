package ru.progwards.java1.lessons.sets;

import java.util.*;

class testShop {
    public static void main(String[] args) {
        Product product1 = new Product("Молоко");
        Product product2 = new Product("Хлеб");
        Product product3 = new Product("Мясо");
        Product product4 = new Product("Сахар");
        Product product10 = new Product("Стол");
        Product product20 = new Product("Стул");
        Product product30 = new Product("Шкаф");
        Product product40 = new Product("Диван");
        List<Product> Foods1 = new ArrayList();
        Foods1.add(product1);
        Shop food = new Shop((List<Product>) Foods1);
    }
}

public class ProductAnalytics {
    private List<Shop> shops;// список магазинов
    private List<Product> products;// список всех товаров всех магазинов

    // список всех имеющихся в ассортименте товаров. Все товары, присутствующие в магазинах,
    // обязательно присутствуют в products, но так же тут могут быть и товары, которых нет в магазинах
    public Set<Product> existInAll() {
        Set<Product> result = new TreeSet<>();
        for (Product prod : products) {
            result.add(prod);
        }
        return result;
    } //товары из products, которые имеются хотя бы в одном магазине

    public ProductAnalytics(List<Product> products, List<Shop> shops) {
        this.shops = shops;
        this.products = products;
    }
    public Set<Product> existAtListInOne(){
        Set<Product> result = new TreeSet<>();
        for (Shop sho : shops){ // Во всех магазинах
            for (Product prod : products) { // товарный ряд магазина
                if (!result.contains(prod)) { // если товара ещё нет в общей базе
                    result.add(prod);// то добавляем его в общую базу
                }//набор уникальных товаров нсобран!
            }
        }
        return result;
    }
    public Set<Product> notExistInShops() {
        Set<Product> result = new TreeSet<>();
        Set<Product> result2 = new TreeSet<>();
        for (Shop sho : shops){
            for (Product prod : products) {
                result.add(prod); // В результ собраны все продукты в магазинах, теперь сравним с полным каталогом
            }
        }
        for (Product res : products) {
            if (!result.contains(res)) {
                result2.add(res);
            }
        }
        return result2;
    }

    public Set<Product> existOnlyInOne() {
        Set<Product> result = new TreeSet<>();
        for (Shop sho : shops){ // Во всех магазинах
            for (Product prod : products) { // товарный ряд магазина
                if (!result.contains(prod)) { // если товара ещё нет в общей базе
                    result.add(prod);// то добавляем его в общую базу
                }//набор уникальных товаров нсобран!
            }
        }
        return result;
    }
}

class Product { // Товар
    private String code; // Уникальный артикул товара

    public Product(String code) {
        this.code = code;
        System.out.println("Добавлен продкут: " + code);
    }

    public String getCode() {
        return this.code;
    }
}

class Shop { // Магазин
    private List<Product> products; // товары имеющиеся в магазине

    public Shop(List<Product> products) {
        this.products = products;
    } // конструктор

    public List<Product> getProducts() {
        return products;
    }
}