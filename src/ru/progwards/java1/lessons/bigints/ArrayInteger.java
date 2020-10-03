package ru.progwards.java1.lessons.bigints;
import java.math.BigInteger;

public class ArrayInteger {
    // Создание массива digits
    byte[] digits;

    ArrayInteger(int n){//- инициализирует класс, с максимальной точностью n цифр (размер массива)
    this.digits = new byte[n]; // Создан байтовый массив в n элементов
 }
void fromInt(BigInteger value){  // - установить свое значение, взяв его из value (уложить BigInteger во внутренний массив)
    String myValue = "" + value; // Удивительно, но это неявное преобразование работает!
    byte digits2[] = myValue.getBytes();
    this.digits = new byte[digits2.length];
    for (int i = 0; i < digits.length; i++) {
        digits[i] = (byte) (digits2[i] - 48); // Костыльно... Но работает!
    }
}
BigInteger toInt() {
//- привести свое значение к BigInteger (преобразовать из массива в BigInteger)
    String tmp="";
    for (int i = 0; i < digits.length; i++) {
        tmp+=Byte.toString(digits[i]);
    }
    return new BigInteger(tmp);
}
boolean add(ArrayInteger num){
// - сложить 2 числа, не используя BigInteger, а используя массив digits,
// результат поместить в экземпляр ArrayInteger, у которого был вызван метод.
// При переполнении вернуть false, при этом само число сбросить в 0
    int mylen = num.digits.length;
    if(digits.length < mylen){
        mylen = digits.length;
    }
    byte[] Digits2 = new byte[digits.length];
    byte[] Digits3 = digits;
    byte rebyte = 0;
    if(num.digits.length >digits.length){
        digits = new byte[digits.length];
        return false;
    }else{
        for (byte i = 0; i < mylen; i++) {
            rebyte = (byte) (Byte.valueOf(Digits3[i]) + Byte.valueOf(num.digits[i]));
            Digits2[i] = rebyte;
        }
        digits = Digits2;
        return true;
    }
}
}