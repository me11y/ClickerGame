package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Server {
    public static void getAccs(String request){
        String query = "http://localhost:8080/" + request;
        HttpURLConnection connection = null;

        try {
            connection = (HttpURLConnection) new URL(query).openConnection();
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setConnectTimeout(250);
            connection.setReadTimeout(250);

            connection.connect();
            StringBuilder sb = new StringBuilder();

            if(HttpURLConnection.HTTP_OK == connection.getResponseCode()){
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = in.readLine()) != null){
                    sb.append(line);
                    sb.append("\n");
                }
                System.out.println(sb.toString());
            }else {
                System.out.println("fail" + connection.getResponseCode());
            }
        } catch (Throwable cause){
            cause.printStackTrace();
        } finally {
            if(connection != null){
                connection.disconnect();
            }
        }
    }
    public static void register(String login, String password){
        String query = "http://localhost:8080/addacc" + "?login=" + login + "&password=" + password;
        HttpURLConnection connection = null;

        try {
            connection = (HttpURLConnection) new URL(query).openConnection();
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setConnectTimeout(250);
            connection.setReadTimeout(250);

            connection.connect();
            StringBuilder sb = new StringBuilder();

            if(HttpURLConnection.HTTP_OK == connection.getResponseCode()){
                System.out.println("OK");
            }else {
                System.out.println("NOT OK");
            }
        } catch (Throwable cause){
            cause.printStackTrace();
        } finally {
            if(connection != null){
                connection.disconnect();
            }
        }
    }
}
