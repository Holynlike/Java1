package ru.progwards.java1.lessons.io1;

import java.io.IOException;

public class io1_Tests {
    public static void main(String[] args) throws Exception {
        System.out.println(LineCount.calcEmpty("C:\\EULy.txt"));
        CharFilter.filterFile("C:\\JAVATemp\\infile.txt",
                "C:\\JAVATemp\\out.txt",
                "C:\\JAVATemp\\filter.txt");
        // LineCount Работает!

        String ST = "";
        char[] CA = ST.toCharArray();

    }
}
