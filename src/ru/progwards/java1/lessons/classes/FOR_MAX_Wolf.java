package ru.progwards.java1.lessons.classes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.nio.CharBuffer;

public class FOR_MAX_Wolf {

    public static void main(String[] args) {
        FOR_MAX_Wolf LA = new FOR_MAX_Wolf();
//        System.out.println(LA.test(null));
//        System.out.println(LA.test("l"));
//        System.out.println(LA.test("123456"));
//        System.out.println(LA.test("D:\t.txt"));
    }

    public String test(String filename) throws FileNotFoundException {
        FileReader reader = new FileReader(filename);
        String str = "File processing";
//        try (filename == null) {
//        } catch (Exception e) {
//            str = "File not found";
//            System.out.println(e.getMessage());
//        }
        return str;
    }
}