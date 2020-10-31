package ru.progwards.java1.lessons.io1;

import java.io.IOException;


public class io1_Tests {
Integer ppp =0;
    public static void main(String[] args) throws Exception {
        // LineCount Работает!
        // CharFilter тоже.
        // Осталось кодер добить...
        char[] result = new char[255];

        for (int i = 0; i < result.length; i++) {result[i] = (char) (i+1);}
        System.out.println(result[2]);
        Coder.codeFile("D:\\forexp\\myOrig.bin",
                       "D:\\forexp\\?", result,
                          "D:\\forexp\\myRES_LOG.bin");
//CharFilter.write1("D:\\forexp\\?","This is Halloween!");
    }
}
