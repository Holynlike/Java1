package ru.progwards.java1.lessons.datetime;

import java.time.ZonedDateTime;
import java.util.ArrayList;

public class SessionManager {
    public static void main(String[] args) {
        UserSession us = new UserSession("Иван");
    }
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
    public ArrayList sessions = new ArrayList();

    public SessionManager(int sessionValid) {
        this.sessionValid = sessionValid;
    }

    public void add(UserSession userSession) {
        sessions.add(userSession);
    }

    public UserSession find(String userName) {
        /**
         * - проверяет наличие существующей сессии по userName.
         * Если срок валидности истек, или такой  сессии нет,
         * возвращает null. В противном случае возвращает сессию, обновив ее дату доступа.
         */
        UserSession u;
        for (int i = 0; i < sessions.size(); i++) {
            u = (UserSession) sessions.get(i);
            if(u.getUserName() == userName){
                return u;
            }
        }
        return null;
    }
    public UserSession get(int sessionHandle){
        if (sessions.isEmpty()) {
            return new UserSession("User not Found!");
        }
        for (int i = 0; i < sessions.size(); i++) {
            UserSession u = (UserSession) sessions.get(i);
            if(u.getSessionHandle() == sessionHandle){
                return u;
            }
        }
        return new UserSession("User not Found!");
    }
    public void delete(int sessionHandle){
        for (int i = 0; i < sessions.size(); i++) {
            UserSession u = (UserSession) sessions.get(i);
            if(u.getSessionHandle() == sessionHandle){
                sessions.remove(i);
            }
        }
    }
    public void deleteExpired(){
        if (sessions.isEmpty()) {
            return;
        }
        for (int i = 0; i < sessions.size(); i++) {
            UserSession u = (UserSession) sessions.get(i);
            if(u.getLastAccess().isBefore(ZonedDateTime.now()) ){ // Если последний доступ был ранее, чем текущее время, удаляем (Дичь полная!)
                sessions.remove(i);
            }
        }
    }
}
