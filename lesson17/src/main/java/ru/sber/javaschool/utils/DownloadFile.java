package ru.sber.javaschool.utils;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;

@Component
public class DownloadFile {
    private String PATH;

    @PostConstruct
    public void init(){
        this.PATH = "D:\\download\\";
    }

    public void upload(String url,String fileName){
        try {
            //TODO в основном ошибка java.net.MalformedURLException: no protocol: https%3A%2F%2Fnamobilu.com%2Fdownload%2Fringtones%2Fmps%2F216929
            //todo файлы появляются в дирректории, но битые, раза два хорошо скачалась

            String link = URLEncoder.encode(url, "UTF-8").replace("\\", "%5C").trim();
            URLConnection connection = new URL(link).openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.106 Safari/537.36");
            connection.connect();

            FileUtils.copyURLToFile(connection.getURL(),new File(PATH + fileName + ".jpg"));


//            ReadableByteChannel rbc = Channels.newChannel(connection.getInputStream());
//            FileOutputStream fos = new FileOutputStream(new File(PATH + fileName + ".jpg"));
//            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
//            fos.close();
//            rbc.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
//        try{
//            File file = new File(PATH + fileName + ".jpg");
//            URL link = new URL( URLEncoder.encode(url, "UTF-8"));
//            FileUtils.copyURLToFile(link,file);
//        }catch (IOException e) {
//            throw new RuntimeException("Download failed",e);
//        }
    }
}
