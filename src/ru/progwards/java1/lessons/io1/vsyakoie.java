package ru.progwards.java1.lessons.io1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class vsyakoie {
    public static void main(String[] args) {
        vsyakoie vs = new vsyakoie();
        //vs.scanLines();
        //System.out.println(vs.invertWords("Буря мглою небо кроет"));
        System.out.println(vs.setStars("y:/forexp/222.txt"));
        System.out.println(vs.setStars("d:/forexp/222.txt"));
        System.out.println(vs.setStars("d:/forexp/221.txt"));
        System.out.println(vs.setStars("d:/forexp/223.txt"));
    }

    public void scanLines() {
        Scanner scanner = new Scanner(System.in);
        String iostring = scanner.nextLine();
        while (iostring.contains("/stop") == false) {
            if (iostring.contains("Привет")) {
                System.out.println("Здравствуйте!");
            } else if (iostring.contains("как дела")) {
                System.out.println("Хорошо");
            } else if (iostring.contains("/stop")) {
                return;
            } else {
                System.out.println(iostring);
            }
            iostring = scanner.nextLine();
        }
    }

    public String invertWords(String sentence) {
        String[] rez = sentence.split(" ");
        String rez2 = "";
        for (int i = rez.length - 1; i >= 0; i--) {
            rez2 += rez[i];
            if (i > 0) {
                rez2 += ".";
            }
        }
        return rez2;
    }

    public String setStars(String filename) {
        String u = "";
        try {
            RandomAccessFile RA = new RandomAccessFile(filename, "rw");
            String t = RA.readLine();
            for (int i = 9; i < RA.length(); i += 10) {
                if (i < RA.length()) {
                    RA.seek(i);
                    u = u + (char) RA.read();
                    RA.seek(i);
                    RA.write(42);
                }
            }
            RA.seek(0);
            t = RA.readLine();
        } catch (Exception e) {
            u = e.getMessage();
        } finally {
        }
        return u;
    }
}