package com.atoproduction.ls10jsonhttpconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    String key = "m.pGmXA1bF-MRe-ITyf2uf_.eBAAHKu1d~cHq_t4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            @Override
            public void run() {
                request();
//                requestPost();
            }
        }).start();

    }


    public void request() {
        try {
            URL mUrl = new URL("https://6076b4b81ed0ae0017d699a3.mockapi.io/users");
            HttpURLConnection httpConnection = (HttpURLConnection) mUrl.openConnection();
            httpConnection.setRequestMethod("GET");
            httpConnection.setConnectTimeout(60000);

            httpConnection.connect();
            int responseCode = httpConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line + "\n");
                }
                bufferedReader.close();

                Log.d("thinhvh", "run: " + stringBuilder);
            } else {

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void requestPost() {
        try {

            JSONObject jsonObject = new JSONObject();

            jsonObject.put("id", "thinhvh");
            jsonObject.put("name", "thinhvh");
            jsonObject.put("avatar", "thinhvh");

            URL mUrl = new URL("https://6076b4b81ed0ae0017d699a3.mockapi.io/users");
            HttpURLConnection httpConnection = (HttpURLConnection) mUrl.openConnection();
            httpConnection.setRequestMethod("POST");
            httpConnection.setConnectTimeout(60000);

            OutputStream op = httpConnection.getOutputStream();
            op.write(jsonObject.toString().getBytes());
            op.close();

            httpConnection.connect();
            int responseCode = httpConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_CREATED) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line + "\n");
                }
                bufferedReader.close();
//                        return stringBuilder.toString();

                Log.d("thinhvh", "run: " + stringBuilder);
            } else {

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}