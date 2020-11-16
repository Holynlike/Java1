package ru.progwards.java1.lessons.io2;

import java.io.RandomAccessFile;

public class PhoneNumber {
    public static void main(String[] args) {
        // Получить на выходе +7(999)111-2233
        System.out.println(format("- 79991112233"));
        System.out.println(format("8(999)111-22-33"));
        System.out.println(format("8 999 111 22 33"));
    }

    public static String format(String phone) {
        String result = phone.replaceAll("[\\D]", ""); // Регуляркой сносим всё, кроме чисел
        if(result.length() == 11){ result = "+"+result;} // Если символов 11, добавляем плюс
        result = result.replace("+8", "+7");
        result = result.replace("+9", "+7");
        return result;
    }
}
