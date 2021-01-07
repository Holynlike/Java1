//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ru.progwards.java1.telegrambot;

import com.google.common.collect.TreeMultimap;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class ProgwardsTelegramBot extends TelegramLongPollingBot {
    public String username;
    public String token;
    private List<ProgwardsTelegramBot.Association> associations = new ArrayList();
    private List<ProgwardsTelegramBot.Association> associations2 = new ArrayList();
    private ConcurrentHashMap<Integer, ConcurrentHashMap<String, String>> userData;

    public ProgwardsTelegramBot() {
        ApiContextInitializer.init();
        this.userData = new ConcurrentHashMap();
    }

    public void addTags(String name, String tags) {
        this.associations.add(new ProgwardsTelegramBot.Association(name, tags));
    }
    public void addTags(Image name, String tags) {
        this.associations2.add(new ProgwardsTelegramBot.Association(name, tags));
    }
    public ProgwardsTelegramBot.FoundTags checkTags(String text) {
        return this.findAssociation(text);
    }

    public boolean checkLastFound(ProgwardsTelegramBot.FoundTags found, String text) {
        return this.getLastFound(found).toLowerCase().equals(text.toLowerCase());
    }

    public String getLastFound(ProgwardsTelegramBot.FoundTags found) {
        Object[] a = found.tags.values().toArray();
        return a.length > 0 ? (String)a[a.length - 1] : "";
    }

    public int foundCount(ProgwardsTelegramBot.FoundTags found) {
        return found.tags.size();
    }

    public Integer getLastWeight(ProgwardsTelegramBot.FoundTags found) {
        Object[] a = found.tags.keys().toArray();
        return a.length > 0 ? (Integer)a[a.length - 1] : 0;
    }

    public String extract(ProgwardsTelegramBot.FoundTags found, int n) {
        Object[] vals = found.tags.values().toArray();
        Object[] keys = found.tags.keys().toArray();
        String res = "";
        int max = this.getLastWeight(found);

        for(int i = 0; i < vals.length; ++i) {
            if (max == 1 || (Integer)keys[i] > 1) {
                res = res + vals[i].toString() + "\n";
            }
        }

        return res;
    }

    public String extract(ProgwardsTelegramBot.FoundTags found) {
        return this.extract(found, found.tags.size());
    }

    private int findAssociation(ProgwardsTelegramBot.Association ass, String text) {
        int weight = 0;
        if (text.toLowerCase().contains(ass.name.toLowerCase())) {
            weight += 10;
        }

        String[] tags = ass.tags.split(",");
        String[] var8 = tags;
        int var7 = tags.length;

        for(int var6 = 0; var6 < var7; ++var6) {
            String s = var8[var6];
            if (text.toLowerCase().contains(s.trim().toLowerCase())) {
                ++weight;
            }
        }

        return weight;
    }

    public ProgwardsTelegramBot.FoundTags findAssociation(String text) {
        TreeMultimap<Integer, String> result = TreeMultimap.create();
        Iterator var4 = this.associations.iterator();

        while(var4.hasNext()) {
            ProgwardsTelegramBot.Association ass = (ProgwardsTelegramBot.Association)var4.next();
            int weight = this.findAssociation(ass, text);
            if (weight > 0) {
                result.put(weight, ass.name);
            }
        }

        return new ProgwardsTelegramBot.FoundTags(result);
    }

    public void setUserData(Integer userid, String name, String data) {
        ConcurrentHashMap thisdata;
        if (this.userData.containsKey(userid)) {
            thisdata = (ConcurrentHashMap)this.userData.get(userid);
        } else {
            thisdata = new ConcurrentHashMap();
            this.userData.put(userid, thisdata);
        }

        thisdata.put(name, data);
    }

    public String getUserData(Integer userid, String name) {
        return this.userData.containsKey(userid) ? (String)((ConcurrentHashMap)this.userData.get(userid)).get(name) : null;
    }

    public void cleartUserData(Integer userid) {
        if (this.userData.containsKey(userid)) {
            this.userData.remove(userid);
        }

    }

    public String getBotToken() {
        return this.token;
    }

    public String getBotUsername() {
        return this.username;
    }

    public void onUpdateReceived(Update update) {
        try {
            if (update.hasMessage() && update.getMessage().hasText()) {
                Message inMessage = update.getMessage();
                String text = inMessage.getText();
                SendMessage outMessage = new SendMessage();
                SendPhoto photo = new SendPhoto();
                outMessage.setChatId(inMessage.getChatId());
                outMessage.setText(this.processMessage(inMessage.getFrom().getId(), text));
                this.execute(outMessage);
            }
        } catch (TelegramApiException var5) {
            var5.printStackTrace();
        }

    }

    public String processMessage(Integer userid, String text) {
        return text;
    }
    public Image processMessage(Integer userid, Image image) {
        return image;
    }

    public void start() {
        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            botsApi.registerBot(this);
        } catch (TelegramApiRequestException var3) {
            var3.printStackTrace();
        }

    }

    static class Association {
        public String name;
        public String tags;
        public Image image;

        public Association(String name, String tags) {
            this.name = name;
            this.tags = tags;
        }
        public Association(Image image, String tags) {
            this.image = image;
            this.tags = tags;
        }
    }

    public static class FoundTags {
        public TreeMultimap<Integer, String> tags;

        public FoundTags(TreeMultimap<Integer, String> tags) {
            this.tags = tags;
        }
    }
}
