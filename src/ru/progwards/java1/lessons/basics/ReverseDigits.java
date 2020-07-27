package ru.progwards.java1.lessons.basics;

public class ReverseDigits {
    public static void main(String[] args) {
        System.out.println(reverseDigits(123));     //Работает
    }
    public static String reverseDigits(int number){
        String inputString = Integer.toString(number);      // Переведём примитив в строку
        char[] charArray = inputString.toCharArray();       // Представим строку как массив однобайтовых чаров
        String resultString = "";                           // Переменная для сбора реверсируемой строки из чаров
        // Циклом реверсим строку
        for (int i = charArray.length - 1; i >= 0; i--) resultString += charArray[i];
        return resultString;
    }
}