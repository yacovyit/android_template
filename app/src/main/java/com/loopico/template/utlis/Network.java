package com.loopico.template.utlis;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by yacovyitzhak on 10/05/2016.
 */
public class Network {
    public static String downloadUrl(String myurl) throws IOException {
        InputStream is = null;
        try{
            URL url = new URL(myurl);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            //connection settings
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(15000);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);

            //connect
            connection.connect();

            int response = connection.getResponseCode();
            is = connection.getInputStream();

            String contentAsString = readIt(is,"UTF-8");

            return contentAsString;


        }finally {
            if (is!=null){
                is.close();
            }
        }
    }

    public static Bitmap downloadBitmap(String myurl) throws IOException {
        InputStream is = null;
        try{
            URL url = new URL(myurl);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            //connection settings
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(15000);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);

            //connect
            connection.connect();

            int response = connection.getResponseCode();
            is = connection.getInputStream();

            Bitmap bitmap = bitmapIt(is);

            return bitmap;


        }finally {
            if (is!=null){
                is.close();
            }
        }
    }

    public static String readIt(InputStream inputStream,String charsetDecoder) throws IOException {
        Reader reader = null;
        reader = new InputStreamReader(inputStream,charsetDecoder);//"UTF-8";
        StringBuffer sb = new StringBuffer();
        char[] buffer = new char[1024];
        for (;;){
            int length =reader.read(buffer, 0, buffer.length);
            if (length==-1)
                break;
            sb.append(buffer, 0, length);
        }
        return sb.toString();
    }
    public static Bitmap bitmapIt(InputStream inputStream){
       return BitmapFactory.decodeStream(inputStream);
    }
    public static void setImageViewFromUrl(ImageView iv,String url){
        try {
            Bitmap bitmap = downloadBitmap(url);
            iv.setImageBitmap(bitmap);
        }catch (Exception exc){

        }
    }
    public static void setImageViewFromUrl(ImageView iv,Bitmap bitmap){
        iv.setImageBitmap(bitmap);
    }
}
