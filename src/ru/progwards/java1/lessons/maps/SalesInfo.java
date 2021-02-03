package ru.progwards.java1.lessons.maps;
import java.io.FileReader;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class SalesInfo {
    Map<String, AbstractMap.SimpleEntry<Double, Integer>> getcustomers;

    public static void main(String[] args) {
        String Path = "D:/forexp/Пример.csv";
        SalesInfo salesInfo = new SalesInfo();
        int i = salesInfo.loadOrders(Path);
        System.out.println(i);
    }
    public int loadOrders(String fileName){ // вернуть количество успешно загруженных строк
        int rez = 0;
        FileReader reader;
        try {
            reader = new FileReader(fileName);
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                String strFromFile = scanner.nextLine().trim();
                strFromFile = strFromFile.trim();
                String[] strarr = strFromFile.split(",");
                System.out.println(strarr.length);
                if(blnmasParse(strarr)) {rez++;}
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rez;
    }
    boolean blnmasParse(String[] arr){
        if (arr.length != 4){
            System.out.println("blnmasParse = false");
            return false;
        }

        try {
            String stWhat1 = arr[0]; // Проверка на стринг первого значения массива
            String stWhat2 = arr[1]; // Проверка на стринг второго значения массива
            int intWhat1 = Integer.parseInt(arr[2].replaceAll("[\\D]", "")); // Проверка на int третьего значения массива
            int intWhat2 = Integer.parseInt(arr[3].replaceAll("[\\D]", ""));  // Проверка на int четвертого значения массива

            if(getcustomers.containsKey(stWhat1)){
                //double sumPokup = getcustomers.
            }

            return true;
        }catch (Exception e){
            System.out.println("blnmasParse - ошибка при парсинге строки: " + Arrays.toString(arr)); return false;
        }
    }
//    public Map<String, Double> getGoods(){ // вернуть список товаров, отсортированный по наименованию товара
//
//    }
//
//    public Map<String, AbstractMap.SimpleEntry<Double, Integer>> getCustomers(){ // вернуть список покупателей, отсортированный по алфавиту
//
//    }
}
