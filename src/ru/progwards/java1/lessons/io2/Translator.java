package ru.progwards.java1.lessons.io2;

public class Translator {
    String[] IN;
    String[] OUT;
    Translator(String[] inLang, String[] outLang) { // Конструктор
        IN = inLang;
        OUT = outLang;
    }

    public static void main(String[] args) {}

    public String translate(String sentence) {
        if (sentence == null) {return null;}
        String my = sentence.toLowerCase(); // Переносим строку в локальную переменную
        for (int i = 0; i < IN.length; i++) {
            my = my.replace(IN[i], OUT[i]); // И в этой переменной просто меняем слова реплейсом
        }
        // Осталось разобраться с строчными и прописными символами.
        String[] toUP = sentence.split(" ");
        String[] toUP2 = my.split(" ");
        // Обе строки - и изначальная и переведенная, переведены в массивы
        for (int i = 0; i < toUP.length; i++) {
            toUP2[i] = (up_low_Str(toUP[i], toUP2[i])); // декомпозиция так-то
        }
        return String.join(" ", toUP2);
    }

    String up_low_Str(String input, String output) {
        char[] out = output.toCharArray();
        if (Character.isUpperCase(input.toCharArray()[0])) { // если первый символ - заглавная буква,
            out[0] = Character.toUpperCase(out[0]); // то первую букву выходной строки переводим в верхний регистр.
        }
        return new String(out);
    }
}