package ru.progwards.java1.lessons.datetime;

import java.time.ZonedDateTime;

public class UserSession {
    private int sessionHandle;
    private String userName;
    private ZonedDateTime lastAccess;

    public ZonedDateTime getLastAccess() {
        return lastAccess;
    }

    public String getUserName() {
        return userName;
    }

    public int getSessionHandle() {
        return sessionHandle;
    }

    public void updateLastAccess() {
        // Обновляет время доступа к сессии
        lastAccess = ZonedDateTime.now();
    }

    /**
     * - создать сессию пользователя.
     * Внутри автоматически сгенерировать sessionHanle,
     * для примера использовать просто случайное число через
     * класс Random, а так же установить текущее время доступа.
     *
     * @param userName
     */
    public UserSession(String userName) {
        System.out.println("Вызван конструктор UserSession, = " + userName);
        lastAccess = ZonedDateTime.now();
        sessionHandle = (int) Math.random();
        System.out.println(sessionHandle);
        this.userName = userName;
    }

}
