package ru.progwards.java1.lessons.io2;

public class Test_translator {
    public static void main(String[] args) throws Exception {
//        String[] IN = new String[]{"hello", "world"};
//        String[] OUT = new String[]{"привет", "мир"};
//        Translator tran = new Translator(IN, OUT);
//        System.out.println(tran.translate("Hello world!"));
        String[] obscene = {"Java", "Oracle", "Sun", "Microsystems"};
        Censor.censorFile("y:\\forexp\\victim.txt", obscene);
    }
}
