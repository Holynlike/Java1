package ru.progwards.java1.lessons.datetime;

import java.time.ZonedDateTime;
import java.util.ArrayList;

public class SessionManager {
    public static void main(String[] args) {
        UserSession us = new UserSession("Иван");
        UserSession us2 = new UserSession("Иван");
        UserSession us3 = new UserSession("Марья");
        SessionManager su = new SessionManager(3);

        su.add(us);
        su.add(us2);
        su.add(us3);
    }

    private int sessionValid;
    public ArrayList sessions = new ArrayList();

    public SessionManager(int sessionValid) {
        this.sessionValid = sessionValid;
    }

    public void add(UserSession userSession) {
        boolean b = false;
        for (int i = 0; i < sessions.size(); i++) {
            UserSession u = (UserSession) sessions.get(i);
            if(u.getUserName() == userSession.getUserName()){
                b= true;
            }
        }
        if (!b) sessions.add(userSession);
    }

    public UserSession find(String userName) {
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
