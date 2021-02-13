package ru.progwards.java1.lessons.maps;

import java.io.File;
import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UsageFrequency {
    Map Exchar = new TreeMap<Character, Integer>(); // Список исключаемых знаков препинания
    public static String TextFromFile = ""; // Здесь будет весь текст файла
    public static void main(String[] args) {
        long starttime = System.currentTimeMillis();
        UsageFrequency UF = new UsageFrequency();
        UF.processFile("C:/forexp/wiki.train.tokens");
        UF.getWords();
        UF.getLetters();
        UF.processFile("D:/forexp/wiki.test.tokens");
        UF.getWords();
        UF.getLetters();
        System.out.println(System.currentTimeMillis() - starttime);
    }
    public void processFile(String fileName){
        // загрузить содержимое файла
        String inout = "";
        try {
            inout = read(fileName); // Читаем файл
        } catch (Exception e) {
            e.printStackTrace();
        }
        TextFromFile = inout;
    }
    void delimiters(){  // Здесь наполняется мап символов-знаков препинания, которые должны быть исключены (или являться разделителями)
            Integer I = 0;
            Exchar.put("'",I);
            Exchar.put("\"",++I); // двойная кавычка
            Exchar.put(">",++I);
            Exchar.put("<",++I);
            Exchar.put("=",++I);
            Exchar.put("-",++I);
            Exchar.put("–",++I);
            Exchar.put("+",++I);
            Exchar.put("/",++I);
            Exchar.put("*",++I);
            Exchar.put("\\",++I); // 10
            Exchar.put("^",++I);
            Exchar.put("%",++I);
            Exchar.put("$",++I);
            Exchar.put("#",++I);
            Exchar.put("@",++I);
            Exchar.put("!",++I);
            Exchar.put("?",++I);
            Exchar.put("`",++I);
            Exchar.put("№",++I);
            Exchar.put(";",++I); // 20
            Exchar.put("&",++I);
            Exchar.put("|",++I);
            Exchar.put("(",++I);
            Exchar.put(")",++I);
            Exchar.put("{",++I);
            Exchar.put("}",++I);
            Exchar.put("[",++I);
            Exchar.put("]",++I);
            Exchar.put(":",++I);
            Exchar.put("_",++I); // 30
            Exchar.put(".",++I);
            Exchar.put(",",++I);
            Exchar.put(" ",++I);
    } // Наполнение карты знаками препинания
    public Map<Character, Integer> getLetters(){
        if (Exchar.isEmpty()){delimiters();} // Если словарь знаков препинания пуст, наполняем его.
        long IN = System.currentTimeMillis();
        Map map = new TreeMap<Character, Integer>();
        if(TextFromFile ==""){System.err.println("Текста нет, будет возвращен пустой словарь"); return map;}
        Integer tmp = 0; Character num = ' ';
        char[] text = TextFromFile.toCharArray(); // Переводим текст файла в чар-массив
        for (int i = 0; i < text.length; i++) {
            num = text[i];
            if(!Exchar.containsKey(num.toString())){ // Если не является знаком препинания
                if (map.containsKey((Character) text[i])){ // Если найден в словаре
                    tmp = (Integer) map.get((Character) text[i]); // добавляем +1 к счетчику
                    map.put((Character) text[i], tmp+1);
                }else{
                    map.put((Character) text[i], 1); // Иначе добавляем символ и единицу (одно нахождение символа)
                }
            }
        }
        return map;
    }

    public Map<String, Integer> getWords(){
        if (Exchar.isEmpty()){delimiters();} // Если словарь знаков препинания пуст, наполняем его.
        Map map = new TreeMap<String, Integer>();
        Integer tmp = 0;
        long IN = System.currentTimeMillis();
        if(TextFromFile ==""){System.err.println("Текста нет, будет возвращен пустой словарь"); return map;}
        char[] fromtextchar = TextFromFile.toCharArray();
        Character num;
        for (int i = 0; i < fromtextchar.length; i++) {
            num = fromtextchar[i];
            if(Exchar.containsKey(num.toString())){
                fromtextchar[i]=' ';
            }
        }
        TextFromFile = String.valueOf(fromtextchar);
        TextFromFile = TextFromFile.replaceAll(" +"," "); // замена множественных пробелов одинарными
        String[] textarr = TextFromFile.trim().split(" "); // Получаем массив слов
        for (String str : textarr) {
            if (map.isEmpty() && !map.containsKey(str)){
                map.put(str,1);
            }else{
                tmp = (Integer) map.get(str);
                if (tmp == null) tmp =0;
                map.put(str, tmp +1);
            }
        }
        return map;
    }

    public String read(String fileName) { // Чтение
        long timeONE = System.currentTimeMillis();
        String rez = ""; FileReader reader;
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                rez += scanner.nextLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - timeONE + " - Время чтения файла, мсек.");
        return rez;
    }
}