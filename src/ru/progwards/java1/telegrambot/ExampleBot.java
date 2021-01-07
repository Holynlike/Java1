package ru.progwards.java1.telegrambot;

import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import org.telegram.telegrambots.ApiContextInitializer;

import javax.imageio.ImageIO;

public class ExampleBot extends ru.progwards.java1.telegrambot.ProgwardsTelegramBot {

    private final String menu = "У нас есть смартфоны и айфоны";

    private static final String orderKey = "order";
    private static final String addressKey = "address";

    private boolean stop = false;

    // Пердложить группы блюд
    // спросить адрес доставки
    String finishCheck(Integer userid) {
        // проверить что все 4 группы блюд в заказе
        // если какой-то группы нет && бот не предлагал
        // то предложить и учтановить ключ, что бы не предлагать 2 раза

        // спросить адрес доставки
        // проверить что заказ не пуст
        if (getUserData(userid, addressKey) == null) {
            setUserData(userid, addressKey, "*");

            return "Укажите, пожалуйста адрес доставки";
        }
        stop = true;
        // если заказ пуст выдать другое сообщение
        return "Спасибо за заказ.";
    }

    // сохранить в заказ
    void saveOrderItem(Integer userid, FoundTags tags) {
        // считать количество
        Integer count = 0;
        String str = getUserData(userid, orderKey);
        if (str != null)
            count = Integer.parseInt(str);
        // инкрементировать количество
        count++;
        // сохранить количество
        setUserData(userid, orderKey, count.toString());
        // сохранить позицию в заказе как orderKey + count
        // ключи - order1, order2
        // данные - getLastFound(tags)

        // дополнительно 1
        // проверить связанные покупки
        // если он заказывает картошку, то предложить соус, если не предлагали
    }

    String getOrder(Integer userid) {
        // считать количество

        // в цикле по каждому элементу вывести содержимое
        // ключ orderKey + номер
        return "Ваш заказ";
    }

    /**
     * Метод, который возвращает ответ бота
     *
     * @return ответ
     */
    @Override
    public String processMessage(Integer userid, String text) {
        System.out.println(userid + " : " + text);
        // проверяем, спрашивали ли адрес доставки
        if (getUserData(userid, addressKey) != null && getUserData(userid, addressKey).equals("*")) {
            setUserData(userid, addressKey, text);
            return finishCheck(userid);
        }
        // сброс всех данных для пользователя - нужно для тестирования
        if (text.equals("/reset"))
            cleartUserData(userid);

        // ищем подходящие тэги рлд запрос из заданных через addTags
        FoundTags tags = checkTags(text);
        // если найдено всего один вариант
        if (foundCount(tags) == 1) {
            if (checkLastFound(tags, "привет"))
                return "Приветствую тебя, мой повелитель!\nЧто желаешь? " + menu;
            if (checkLastFound(tags, "конец"))
                return finishCheck(userid);
            if (checkLastFound(tags, "дурак"))
                return "Не надо ругаться. Я не волшебник, я только учусь";
            if (checkLastFound(tags, "нет"))
                return "Ну нет, так нет";
            if (checkLastFound(tags, "заказ"))
                return getOrder(userid);
            // Добавить связанные предложения, например если он заказывает картошку, то предложить соус,
            // если отказывается - сохранить флажок, что бы бесконечно не предлагать
            // дополнительно 2
            // реализовать отмену позиции заказа

            saveOrderItem(userid, tags);
            return "Отлично, добавляю в заказ " + getLastFound(tags) + " Желаешь что-то еще?";
        }
        if (foundCount(tags) > 1)
            return "Под твой запрос подходит: \n" + extract(tags) + "Выбери что-то одно, и я добавлю это в заказ.";
        return "Я не понял, возможно у нас этго нет, попробуй сказать по другому. " + menu;
    }


    public Image processMessage(Integer userid, Image image, String text) {
        FoundTags tags = checkTags(text);
        Image image1 = null;
        if (foundCount(tags) == 1) {
            if (checkLastFound(tags, "пицца")) {
                image1 = image;
            }
        }
        return image1;
    }

    public static void main(String[] args) throws Exception {


        System.out.println("Hello bot!");

        ApiContextInitializer.init();

        // инициализируем бота
        ExampleBot bot = new ExampleBot();
        bot.username = "Pizza24javabot";
        bot.token = "904923800:AAE5CjsVcpxBJfT_DG7u4T9rua42sa_nIkY";
        ArrayList file = read("D:\\forexp\\Smartphones_Catalog.txt");

        for (int i = 0; i < file.size(); i++) {
            String[] AAAAA = (String[]) file.get(i);
            bot.addTags(AAAAA[0],AAAAA[1] + "," + AAAAA[2] + "," + AAAAA[3] + "," + AAAAA[4] + "," + AAAAA[5]);
        }
        URL url = new URL("https://static.tildacdn.com/tild3531-3437-4062-a266-613234626332/photo.jpg");
        //Image image = null;
        Image image = ImageIO.read(url);
        bot.addTags(image, "ПИЦЦА");
        // наполняем тэгами
        bot.addTags("привет", "привет, здасьте, здравствуйте, добр, день, вечер, утро, hi, hello");
        bot.addTags("конец", "конец, все, стоп, нет");
        bot.addTags("дурак", "дурак, идиот, тупой");

        // добавлено
        bot.addTags("заказ", "заказ");
        bot.addTags("нет", "нет");

        bot.start();
        //bot.test();
    }



    public static ArrayList read(String fileName) throws Exception{ // Чтение
        ArrayList<String[]> list = new ArrayList();
        FileReader reader;
        try {
            reader = new FileReader(fileName);
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                String[] strFromFile = scanner.nextLine().split("\t");
                list.add(strFromFile);
            }
            reader.close();
        } catch (Exception e) {
            throw new Exception (e);
        }

        return list;
    }
    void test() {
        Scanner in = new Scanner(System.in);
        String input;
        do {
            input = in.nextLine();

            System.out.println(processMessage(123, input));
        } while (!stop);
        in.close();
    }
}
