package com.example.demo;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by chengxia on 2018/12/4.
 */
public class HttpURLConnectionDemo {
    public String doPost(String URL) {
        OutputStreamWriter out = null;
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        HttpURLConnection conn = null;
        try {
            URL url = new URL(URL);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            //发送POST请求必须设置为true
            conn.setDoOutput(true);
            conn.setDoInput(true);
            //设置连接超时时间和读取超时时间
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(10000);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            //获取输出流
            out = new OutputStreamWriter(conn.getOutputStream());
            String jsonStr = "{\"qry_by\":\"name\", \"name\":\"Tim\"}";
            out.write(jsonStr);
            out.flush();
            out.close();
            //取得输入流，并使用Reader读取
            if (200 == conn.getResponseCode()) {
                in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                String line;
                while ((line = in.readLine()) != null) {
                    result.append(line);
                    System.out.println(line);
                }
            } else {
                System.out.println("ResponseCode is an error code:" + conn.getResponseCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return result.toString();
    }

    public static String doGet(String URL) {
        HttpURLConnection conn = null;
        InputStream is = null;
        BufferedReader br = null;
        StringBuilder result = new StringBuilder();
        try {
            //创建远程url连接对象
            URL url = new URL(URL);
            //通过远程url连接对象打开一个连接，强转成HTTPURLConnection类
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            //设置连接超时时间和读取超时时间
            conn.setConnectTimeout(15000);
            conn.setReadTimeout(60000);
            conn.setRequestProperty("Accept", "application/json");
            //发送请求
            conn.connect();
            //通过conn取得输入流，并使用Reader读取
            if (200 == conn.getResponseCode()) {
                is = conn.getInputStream();
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                String line;
                while ((line = br.readLine()) != null) {
                    result.append(line);
                    System.out.println(line);
                }
            } else {
                System.out.println("ResponseCode is an error code:" + conn.getResponseCode());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            conn.disconnect();
        }
        return result.toString();
    }


    public static void main(String[] args) throws Exception {
        HttpURLConnectionDemo http = new HttpURLConnectionDemo();

        System.out.println("Testing 1 - Do Http GET request");
        String s = http.doGet("http://www.kuaidi100.com/query?type=yunda&postid=4607601521558");
//        String s1 = http.doGet("//www.kuaidi100.com/chaxun?com=yunda&nu=4607601521558");
//        String c = http.doGet("https://restapi.amap.com/v3/weather/weatherInfo?city=110000&key=4790b7c8b3290c65ad638f4b73a35a19");


    }
}