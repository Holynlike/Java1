package ru.progwards.java1.lessons.io2;

public class Test_translator {
    public static void main(String[] args) throws Exception {
        //System.out.println(PhoneNumber.format("- 79991112233"));

//        String[] IN = new String[]{"hello", "world"};
//        String[] OUT = new String[]{"привет", "мир"};
//        Translator tran = new Translator(IN, OUT);
//        System.out.println(tran.translate("Hello world!"));
        String[] obscene = {"Java", "Oracle", "Sun", "Microsystems"};
        try {
            //Censor.censorFile("D:/forexp/victim.txt", obscene);
            Censor.censorFile(null, obscene);
        }catch (Exception e){
            System.err.println(e.toString());
        }
    }
}
