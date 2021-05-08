package ru.progwards.java1.lessons.maps;

import java.io.FileReader;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;

public class SalesInfo {
    Map<String, AbstractMap.SimpleEntry<Double, Integer>> getcustomers = new TreeMap<>();
    public TreeMap<String, Double> getgoods = new TreeMap<>();
    private int openedOrders = 0;

    public void run(String fileName) {
        FileReader reader;
        try {
            reader = new FileReader(fileName);
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) { // до конца текста
                String strFromFile = scanner.nextLine().trim(); //  читаем следующую строку
                strFromFile = strFromFile.trim(); //  убираем концевые пробелы
                String[] strarr = strFromFile.split(","); // переводим в массив
                if (blnmasParse(strarr)) { // проверяем на корректность массива (4 значения, первые два ходят в стрингах, третий и четвертый - ИНТы.)
                    toMaps(strarr); // вынесу в отдельный метод упаковку в МАПы
                    openedOrders++;
                }
            }
            reader.close(); //  закрываем открытый файл
        } catch (Exception e) {
            e.printStackTrace(); //  на случай ошибки просто кидаем трассировку стэка
        }
    }

    public int loadOrders(String fileName) { // вернуть количество успешно загруженных строк
        run(fileName);
        return openedOrders;
    }

    public void toMaps(String[] args) { //  сюда придёт текстовый массив только если он прошел проверку
        String stWhat1 = args[0].trim(); // клиент
        String stWhat2 = args[1].trim(); // товар

        Integer intWhat1 = Integer.valueOf(args[2].replaceAll("[\\D]", "")); // количество
        Double dblWhat2 = Double.valueOf(args[3].replaceAll("[\\D]", ""));   // цена

        if (getcustomers.size() == 0) { // если пуст
            getcustomers.put(stWhat1, new SimpleEntry(dblWhat2, intWhat1));
        } else {// если не пуст
            for (Map.Entry<String, AbstractMap.SimpleEntry<Double, Integer>> ES : getcustomers.entrySet()) {
                if (ES.getKey().equals(stWhat1)) { // ищем в словаре свежеспарсенное ФИО
                    intWhat1+=ES.getValue().getValue();
                    dblWhat2+=ES.getValue().getKey();
                }
            }
            getcustomers.put(stWhat1, new SimpleEntry<Double, Integer>(dblWhat2, intWhat1));
        }
        //==========геткустомерс заполнен===========//
        Double prod = Double.valueOf(args[3].replaceAll("[\\D]", ""));   // цена
        if (getgoods.size() == 0) { // если пуст
            getgoods.put(stWhat2, dblWhat2);
        } else {
            for (Map.Entry<String, Double> GS : getgoods.entrySet()) { // если не пуст
                if (GS.getKey().equals(stWhat2)) { // ищем в словаре свежеспарсенный товар
                    prod+=GS.getValue();
                }
            }
            getgoods.put(stWhat2, prod);
        }
        //==========getgoods заполнен===========//
    }

    boolean blnmasParse(String[] arr) { // проверка массива
        if (arr.length != 4) {
            System.out.println("blnmasParse = false");
            return false;
        }
        try {
            String stWhat1 = arr[0]; // Проверка на стринг первого значения массива
            String stWhat2 = arr[1]; // Проверка на стринг второго значения массива
            int intWhat1 = Integer.parseInt(arr[2].replaceAll("[\\D]", ""));  // Проверка на int третьего значения массива
            int intWhat2 = Integer.parseInt(arr[3].replaceAll("[\\D]", ""));  // Проверка на int четвертого значения массива
            return true;
        } catch (Exception e) {
            System.out.println("blnmasParse - ошибка при парсинге строки: " + Arrays.toString(arr));
            return false;
        }
    }

    public Map<String, Double> getGoods() { // вернуть список товаров, отсортированный по наименованию товара
        return getgoods;
    }

    public Map<String, AbstractMap.SimpleEntry<Double, Integer>> getCustomers() { // вернуть список покупателей, отсортированный по алфавиту
        return getcustomers;
    }
}