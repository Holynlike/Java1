package ru.progwards.java1.lessons.sets;

import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

class testShop{
    public static void main(String[] args) {
        Product product1 = new Product("Молоко");
        Product product2 = new Product("Хлеб");
        Product product3 = new Product("Мясо");
        Product product4 = new Product("Сахар");
        Product product10 = new Product("Стол");
        Product product20 = new Product("Стул");
        Product product30 = new Product("Шкаф");
        Product product40 = new Product("Диван");
        SortedSet<Product> Foods1 = new TreeSet();
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
        return null;
    } //товары из products, которые имеются хотя бы в одном магазине

    public ProductAnalytics(List<Product> products, List<Shop> shops) {
    }
    public Set<Product> notExistInShops(){return null;}
    public Set<Product> existOnlyInOne(){return null;}
}

class Product { // Товар
    private String code; // Уникальный артикул товара
    public Product(String code) {this.code = code;}
    public String getCode() {return this.code;}
}

class Shop { // Магазин
    private List<Product> products; // товары имеющиеся в магазине
    public Shop(List<Product> products) {this.products = products;} // конструктор
    public List<Product> getProducts() {return products;}
}