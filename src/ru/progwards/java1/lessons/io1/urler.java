package ru.progwards.java1.lessons.io1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class urler {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://vk.com/feed");
        InputStream is = url.openStream();
        ByteArrayOutputStream BAOS = new ByteArrayOutputStream();
        int b;
        while((b=is.read())!=-1){
            BAOS.write(b);
        }
        System.out.println(BAOS.toString());
    }
}
