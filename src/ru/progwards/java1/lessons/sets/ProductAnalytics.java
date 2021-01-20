package ru.progwards.java1.lessons.sets;

import java.util.*;

class testShop {
    public static void main(String[] args) {
        ArrayDeque ad = new ArrayDeque();
        ad.add(1);
        ad.add(2);
        ad.add(3);
        sumLastAndFirst(ad);
        System.out.println("-----------------------------------------------------");


        Product product1 = new Product("Молоко");
//        Product product2 = new Product("Хлеб");
//        Product product3 = new Product("Мясо");
//        Product product4 = new Product("Сахар");
//        Product product10 = new Product("Стол");
//        Product product20 = new Product("Стул");
//        Product product30 = new Product("Шкаф");
//        Product product40 = new Product("Диван");
        List<Product> Foods1 = new ArrayList();
        Foods1.add(product1);
        Shop food = new Shop((List<Product>) Foods1);
    }

    static int sumLastAndFirst(ArrayDeque<Integer> deque){
        if(deque.isEmpty()){return 0;}
        return deque.getFirst()+deque.getLast();}

}

class compareProd implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {return o1.getCode().compareTo(o2.getCode());}
}

public class ProductAnalytics {
    private List<Shop> shops; private List<Product> products;

    public Set<Product> existInAll() {
        Set<Product> result = new TreeSet<>(new compareProd());
        int shopcountProd = 0;
        for (Product prod : products) {
            for (Shop sho : shops) {
                if (sho.getProducts().contains(prod)) {shopcountProd++;}
            }
            if (shopcountProd == shops.size()) {result.add(prod);}
            shopcountProd = 0;
        }
        return result;
    }

    public ProductAnalytics(List<Product> products, List<Shop> shops) {
        this.shops = shops; this.products = products;
    }

    public Set<Product> existAtListInOne() {//если имеются хотя бы в одном магазине
        Set<Product> result = new TreeSet<>(new compareProd());
        for (Product prod : products) { // товарный ряд магазина
            for (Shop sho : shops) { // Во всех магазинах
                if (sho.getProducts().contains(prod)) { // если товара ещё нет в общей базе
                    result.add(prod);// то добавляем его в общую базу
                    break;
                }
            }
        }
        return result;
    }

    public Set<Product> notExistInShops() {
        Set<Product> result = new TreeSet<>(new compareProd());
        Set<Product> result2 = new TreeSet<>(new compareProd());
        for (Product prod : products) {
            result.add(prod);
            result2.add(prod);
        } // В результ собраны все продукты из каталога
        for (Product prod : result) {
            for (Shop sho : shops) { // Во всех магазинах
                if (sho.getProducts().contains(prod)) {result2.remove(prod);}
            }
        }
        return result2;
    }

    public Set<Product> existOnlyInOne() {
        Set<Product> result = new TreeSet<Product>(new compareProd());
        int intcountProd = 0;
        for (Product prod : products) { // товарный ряд общего каталога
            for (Shop sho : shops) { // Во всех магазинах
                if (sho.getProducts().contains(prod)) {
                    intcountProd++;
                } // если товар есть в магазине
            }
            if (intcountProd == 1) {
                result.add(prod);
            }
            intcountProd = 0;
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