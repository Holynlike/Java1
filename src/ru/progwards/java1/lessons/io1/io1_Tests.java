package ru.progwards.java1.lessons.io1;

import java.io.IOException;

public class io1_Tests {
    public static void main(String[] args) throws Exception {
        // LineCount Работает!
        // CharFilter тоже.
        // Осталось кодер добить...
        char[] result = new char[255];
        System.out.println(CharFilter.Exists("D:\\forexp\\myOrig.bin"));

        for (int i = 0; i < result.length; i++) {result[i] = (char) (i+1);}
        System.out.println(result[2]);
        Coder.codeFile("D:\\forexp\\myOrig.bin",
                       "D:\\forexp\\",
                                result,
                          "D:\\forexp\\myRES_LOG1.bin");
CharFilter.write("D:\\forexp\\?","This is Halloween!");
        CharFilter.read("D:\\forexp\\myRES_LOG.bin");
    }
}
