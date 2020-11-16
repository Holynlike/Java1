package ru.progwards.java1.lessons.io1;

import java.util.Scanner;

public class io1_Tests {
    public static void main(String[] args) throws Exception {

        char[] result = new char[255];
        for (int i = 0; i < result.length; i++) {
            result[i] = (char) (i + 1);
        }

//        System.out.println("вызов кодера с корректными параметрами");
//        Coder.codeFile("D:\\forexp\\Halloween.txt", "D:\\forexp\\Halloween_1.txt", result,"D:\\forexp\\Halloween_LOG1.bin");
//        // При адекватных параметрах всё работает

        System.out.println("\n\nвызов кодера с некорректными параметрами (некорректный файл ввода)");
        Coder.codeFile(null, "D:\\forexp\\Halloween_2.txt", result, "D:\\forexp\\Halloween_LOG2.bin");
        // При адекватных параметрах всё работает (некорректный ввод -> идет запись в лог, файл вывода остается пустым)

        System.out.println("\n\nвызов кодера с некорректными параметрами (некорректный файл вывода)");
        Coder.codeFile("D:\\forexp\\Halloween.txt", null, result, "D:\\forexp\\Halloween_LOG3.bin");


        System.out.println("\n\nвызов кодера с некорректными параметрами (некорректный файл лога)");
        Coder.codeFile(null, "D:\\forexp\\Halloween_4.txt", result, null);

        System.out.println("\n\nвызов кодера с некорректными параметрами (все файлы некорректны)");
        Coder.codeFile(null, null, result, null);
    }
    public void scanLines() {
        try (Scanner scanner = new Scanner(System.in)) {
            String iostring = scanner.nextLine();
            if (iostring.contains("Привет")){
                System.out.println("Здравствуйте!");
            }else if (iostring.contains("как дела")){
                System.out.println("Хорошо!");
            }else if (iostring.contains("/stop")){
                return;
            }
        }
    }
}
