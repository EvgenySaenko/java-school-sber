package ru.sber.javaschool;

import javax.xml.parsers.DocumentBuilder;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class AppMain {
    public static void main(String[] args) {

        String url = "https%3A%2F%2Fdisk.yandex.ru%2Fi%2F9rhaNevn89E22A";
        String path = "D:\\download\\";


        FileOutputStream fos = null;
        BufferedInputStream in = null;
        try{
            String link = URLEncoder.encode(url ,"UTF-8");
            URLConnection connection = new URL(link).openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.106 Safari/537.36");
            connection.connect();
            InputStream is = connection.getInputStream();

            fos =  new FileOutputStream(path + "/dog.jpg");
            byte [] data =  new byte[1024];
            int count;
            while ((count = in.read(data,0,1024)) != -1){
                fos.write(data,0,count);
                fos.flush();
            }
        } catch (FileNotFoundException | MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
