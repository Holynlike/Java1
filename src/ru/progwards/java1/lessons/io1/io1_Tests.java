package ru.progwards.java1.lessons.io1;

import java.io.IOException;


public class io1_Tests {
Integer ppp =0;
    public static void main(String[] args) throws Exception {
        // LineCount ��������!
        // CharFilter ����.
        // �������� ����� ������...
        char[] result = new char[255];

        for (int i = 0; i < result.length; i++) {
              result[i] = (char) (i+1);
        }System.out.println(result[2]);
        Coder.codeFile("C:\\Users\\Magic\\Desktop\\����������������\\myOrig.bin",
                      "C:\\Users\\Magic\\Desktop\\����������������\\myRESul.bin", result,
                        "C:\\Users\\Magic\\Desktop\\����������������\\myRES_LOG.bin");

    }
}
