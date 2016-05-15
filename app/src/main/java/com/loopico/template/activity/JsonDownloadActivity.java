package com.loopico.template.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.loopico.template.R;
import com.loopico.template.utlis.Network;

import java.io.IOException;

public class JsonDownloadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_download);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String data = Network.downloadUrl("http://www.google.com");
                    int size = data.length();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

    }
}
