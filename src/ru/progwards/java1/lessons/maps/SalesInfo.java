package ru.progwards.java1.lessons.maps;
import java.io.FileReader;
import java.util.*;

public class SalesInfo {
    Map<String, AbstractMap.SimpleEntry<Double, Integer>> getcustomers = new HashMap<>();
    public Map<String, Double> getgoods;

    public static void main(String[] args) {
        String Path = "D:/forexp/Пример.csv";
        SalesInfo salesInfo = new SalesInfo();
        int i = salesInfo.loadOrders(Path);
        System.out.println(i);
    }

    public int loadOrders(String fileName) { // вернуть количество успешно загруженных строк
        int rez = 0;
        FileReader reader;
        try {
            reader = new FileReader(fileName);
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) { // до конца текста
                String strFromFile = scanner.nextLine().trim(); //  читаем следующую строку
                strFromFile = strFromFile.trim(); //  убираем концевые пробелы
                String[] strarr = strFromFile.split(","); // переводим в массив
                if (blnmasParse(strarr)) { // проверяем на корректность массива (4 значения, первые два ходят в стрингах, третий и четвертый - ИНТы.)
                    rez++; // постфиксно инкрементируем локальный счетчик
                    toMaps(strarr); // вынесу в отдельный метод упаковку в МАПы
                }
            }
            reader.close(); //  закрываем открытый файл
        } catch (Exception e) {
            e.printStackTrace(); //  на случай ошибки просто кидаем трассировку стэка
        }
        return rez; // ну и результ!
    }

    public void toMaps(String[] args){ //  сюда придёт текстовый массив только если он прошел проверку
        Double tmp;
        String stWhat1 = args[0];
        String stWhat2 = args[1];

        int intWhat1 = Integer.parseInt(args[2].replaceAll("[\\D]", ""));
        int intWhat2 = Integer.parseInt(args[3].replaceAll("[\\D]", ""));
        try { // если словарь пуст, добавляем в него и сразу выходим
            if(getcustomers.size() ==0){getcustomers.put(stWhat1,new AbstractMap.SimpleEntry(intWhat1,intWhat2));return;}

            for (Map.Entry<String, AbstractMap.SimpleEntry<Double, Integer>> ES : getcustomers.entrySet()) { // если не пуст
                if(ES.getKey() == stWhat1){ // ищем в словаресвежеспарсенное ФИО
                    tmp = ES.getValue().getKey() + intWhat1; // найдя, суммируем покупки к этому покупателю
                    //ES = new AbstractMap.SimpleEntry<Double, Integer>();
                    //ES.setValue(tmp, Integer.valueOf(intWhat2));
                }
            }

        } catch (Exception e) {

        }
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
