package ru.progwards.java1.lessons.io2;

public class PhoneNumber {
public static String format(String phone) {
        String result = phone.replaceAll("[\\D]", ""); // Регуляркой сносим всё, кроме чисел
        if(result.length() == 11){ result = "+"+result;} // Если символов 11, добавляем плюс
        result = result.replace("+8", "+7");
        result = result.replace("+9", "+7");
        return result;
    }
}