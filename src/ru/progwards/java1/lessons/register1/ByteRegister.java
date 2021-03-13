package ru.progwards.java1.lessons.register1;

public class ByteRegister {
    Bit b = new Bit(false);
    public Bit[] value = {b, b, b, b, b, b, b, b};
    public ByteRegister(){} // конструктор по умолчанию
    public ByteRegister(byte value){ // конструктор с параметрами
        String s = Integer.toBinaryString((int) value);
        char[] c=Integer.toBinaryString((int) value).toCharArray();

           try {
               for (int i = 0; i < c.length; i++) {
                   if (c[i] == '1') {
                       this.value[8 - c.length + i] = new Bit(true);
                   }
               }
           }catch(Exception e){
               System.err.println("А вот хуй тебе!");
           }

    }
//    public ByteRegister(int value){ // конструктор с параметрами
//        char[] c=Integer.toBinaryString(value).toCharArray();
//        for (int i = 0; i < c.length; i++) {
//            if (c[i]=='1'){this.value[8-c.length+i] = new Bit(true);}
//        }
//    }
    public String toString(){
        String s = "";
        for (int i = 0; i <8; i++) {
            s+=this.value[i].toString();
        }
        return s;
    }
    public String toDecString(){
        return String.valueOf(Integer.parseInt(toString(),2));
    }

}
class ByteRegister_Test{
    public static void main(String[] args) {
        int tni = 0;
        for (int i = 0; i < 6; i++) {
            tni = tni<<=1;
            System.out.println(tni);
        }
        for (byte i = 12; i < 14; i++) {
            ByteRegister BI = new ByteRegister(i);
            System.out.println(new ByteRegister(i).toDecString());
            System.out.println(new ByteRegister(i).toString() + " - " +i);
        }
    }
}