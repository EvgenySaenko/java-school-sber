package ru.sber.javaschool;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class Main {
    public static void main(String[] args) {
        try{
            //URL url =new URL("https://www.google.com/url?sa=i&url=https%3A%2F%2Fru.motor1.com%2Fnews%2F357302%2Fdodge-ne-vozrodit-challenger-demon-i-ne-budet-delat-charger-demon%2F&psig=AOvVaw14amlfC3rb1HEsJsyxMzSA&ust=1624019636213000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCMiHvuDWnvECFQAAAAAdAAAAABAD");
            URL url =new URL("https://cdn.motor1.com/images/mgl/m9lbq/s1/2018-dodge-challenger-srt-demon.webp");

            String link = URLEncoder.encode(String.valueOf(url), "UTF-8");
            URLConnection connection = new URL(link).openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.106 Safari/537.36");
            connection.connect();
            InputStream is = connection.getInputStream();

            OutputStream outstream = new FileOutputStream(new File("D:\\download\\file.mp3"));
            byte[] buffer = new byte[4096];
            int len;
            while ((len = is.read(buffer)) > 0) {
                outstream.write(buffer, 0, len);
            }
            outstream.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
