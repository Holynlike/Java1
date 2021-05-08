package ru.progwards.java1.lessons.datetime;

import java.time.ZonedDateTime;
import java.util.*;

public class SessionManager {
    /**
     * Реализовать класс для хранения пользовательских сессий для сервера,
     * который проверяет аутентификацию пользователей. Менеджер работает
     * по следующему принципу: при логине (считаем что проверка логин-пароль
     * уже прошла) данные о сессии пользователя заносятся в список и возвращается
     * хэндл сессии. Затем пользователи запрашивают информацию используя хэндл,
     * авторизация идет по хендлу сессии, который валиден определенное время,
     * с момента крайнего запроса. Проверка сессии по хендлу должна работать
     * максимально быстро. У каждого пользователя может быть только одна сессия.
     */
    private int sessionValid;
    //public List<T> sessions = new List();

    public SessionManager(int sessionValid) {
        this.sessionValid = sessionValid;
    }

    public void add(UserSession userSession) {

    }
    public UserSession find(String userName){
        //if(sessions.containsKey(userName)){
        return new UserSession("");
    }



    class UserSession {
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
            lastAccess = ZonedDateTime.now();
            sessionHandle = (int) Math.random();
        }
    }

}
