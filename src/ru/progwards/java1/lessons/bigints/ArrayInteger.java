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

    byte Stage = 0;
    byte[] Digits2 = new byte[digits.length];
    byte[] Digits3 = digits;
    Digits2 = Digits3;
    byte rebyte = 0;
    if(num.digits.length >digits.length){
        digits = new byte[digits.length];
        return false;// При переполнении вернуть false, при этом само число сбросить в 0
    }else{
        for (int i = 1; i < Digits2.length-1; i++) {
            rebyte = (byte) (Byte.valueOf(Digits3[Digits3.length-i]) + Byte.valueOf(num.digits[num.digits.length-i])+Stage);
            if (rebyte>9){
                Stage = 1; // два плюс два, один в уме
                rebyte = (byte) (rebyte - (byte) 10);
            }else{
                Stage = 0;
            }
            Digits2[Digits2.length - i] = rebyte;
        }
        if (Stage ==1){
            int i =digits.length - num.digits.length;
            if(i>0){
                digits[i-1]++;
            }else{
                digits = new byte[digits.length];
                return false;// При переполнении вернуть false, при этом само число сбросить в 0
            }
        }
        digits = Digits2;
        return true;
    }
}
}