package ru.progwards.java1.lessons.io2;

public class PhoneNumber {
    public static String format(String phone) {
        String result = phone.replaceAll("[\\D]", ""); // Регуляркой сносим всё, кроме чисел
        if (result.length() == 11) {
            result = "+" + result;
        } // Если символов 11, добавляем плюс
        result = printPhone(Long.valueOf(result));
//        result = result.replace("+8", "+7");
//        result = result.replace("+9", "+7");
        return result;
    }
    public static String printPhone(Long phoneNum) {
        StringBuilder sb = new StringBuilder(15);
        StringBuilder temp = new StringBuilder(phoneNum.toString());
        while (temp.length() < 10)
            temp.insert(0, "0");
        char[] chars = temp.toString().toCharArray();
        sb.append("+");
        for (int i = 0; i < chars.length; i++) {

            if (i == 1)
            sb.append("(");
            else if (i == 4)
                sb.append(")");
            else if (i == 7)
                sb.append("-");
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}