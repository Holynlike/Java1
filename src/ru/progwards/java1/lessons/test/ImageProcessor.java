package ru.progwards.java1.lessons.test;

//package image;

import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;

class ImageProcessor {
    public static void main(String[] args) {
        try {
            //картинка бэк
            File back = new File("D:/forexp/Kao.jpg");
            BufferedImage sourceBack = ImageIO.read(back);

            //картинка фронт
            File actor = new File("D:/forexp/Velya.jpg");
            BufferedImage sourceActor = ImageIO.read(actor);

            //координаты для вставки
            int xLocation = 10;
            int yLocation = 10;

            //проверка чтобы фронт был минимум в два раза меньше чем бэк
            if (sourceBack.getWidth() < sourceActor.getWidth() / 2 && sourceBack.getHeight() < sourceActor.getHeight() / 2) {
                System.out.println("Actor is too big");
            } else {
                //готовим результат размером с бэк
                BufferedImage result = new BufferedImage(sourceBack.getWidth(), sourceBack.getHeight(), sourceBack.getType());
                //проходим попиксельно бэк
                for (int x = 0; x < sourceBack.getWidth(); x++) {
                    for (int y = 0; y < sourceBack.getHeight(); y++) {
                        //записывем бэк в результат
                        result.setRGB(x, y, sourceBack.getRGB(x, y));
                    }
                }

                //временное хранилище для Y
                int yTest = yLocation;

                //проходим попиксельно фронт
                for (int x = 0; x < sourceActor.getWidth(); x++, xLocation++) {
                    for (int y = 0; y < sourceActor.getHeight(); y++, yLocation++) {
                        //записываем фронт поверх записанного бэка
                        result.setRGB(xLocation, yLocation, sourceActor.getRGB(x, y));
                    }
                    //обнуляем Y
                    yLocation = yTest;
                }

                // Сохраняем результат в новый файл
                File output = new File("D:/forexp/result.jpg");
                ImageIO.write(result, "jpg", output);
            }

        } catch (IOException e) {
            System.out.println("Файл не найден или не удалось сохранить");
        }
        System.out.println("Done");
    }
}