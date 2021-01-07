package ru.progwards.java1.lessons.sets;

import java.io.FileReader;
import java.util.*;

public class LettersInFile {

    public static void main(String[] args) throws Exception {
        System.out.println(process("D:\\forexp\\123.txt"));
        System.out.println(process("D:\\forexp\\exp.txt"));
    }

    public static String process(String fileName) throws Exception {
        List<Character> list = read(fileName);
        String result = "";
        SortedSet<String> interSet2 = new TreeSet();
        for (Character num : list){interSet2.add(num.toString());}
        Set<Character> alphabet = new TreeSet<>(); // Создадим алфавит (получится без букв ё и Ё)
        for (char cha = 'A'; cha <= 'Z'; cha++) {alphabet.add(cha);}
        for (char cha = 'a'; cha <= 'z'; cha++) {alphabet.add(cha);}
        for (char cha = 'А'; cha <= 'Я'; cha++) {alphabet.add(cha);}
        for (char cha = 'а'; cha <= 'я'; cha++) {alphabet.add(cha);}
        for (Character num : alphabet) {
            if (list.contains(num)) {
                result+=num;
            }
        }
        return result;
    }

    public static List read(String fileName) throws Exception { // Чтение
        String rez = "";
        ArrayList<Character> result = new ArrayList<>();
        FileReader reader;
        try {
            reader = new FileReader(fileName);
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                String strFromFile = scanner.nextLine();
                rez += strFromFile;
            }
            reader.close();
        } catch (Exception e) {
            throw new Exception(e);
        }
        char [] c = rez.toCharArray();
        for (int i = 0; i < rez.length(); i++) {
            result.add(c[i]);
        }
        return result;
    }
}
