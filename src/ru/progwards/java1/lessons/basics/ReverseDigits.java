package ru.progwards.java1.lessons.basics;
public class ReverseDigits {
    public static void main(String[] args) {
        System.out.println(reverseDigits(123));     //Работает
    }
    public static int reverseDigits(int number){
        String inputString = Integer.toString(number);
        char[] charArray = inputString.toCharArray();
        String resultString = "";
        for (int i = charArray.length - 1; i >= 0; i--) resultString += charArray[i];
        return Integer.parseInt(resultString);
    }
}