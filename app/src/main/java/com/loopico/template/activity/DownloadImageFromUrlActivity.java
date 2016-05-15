package com.loopico.template.activity;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.loopico.template.R;
import com.loopico.template.utlis.Network;

import java.io.IOException;

public class DownloadImageFromUrlActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonThread,buttonHandler,buttonAsyncTask;
    private EditText editTextUrl ;
    private ImageView imageViewDownloaded;
    private Handler handler ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_image_from_url);

        handler = new Handler();

        editTextUrl = (EditText)findViewById(R.id.editTextUrl);
        imageViewDownloaded = (ImageView)findViewById(R.id.imageViewDownloaded);

        //buttons
        buttonThread = (Button)findViewById(R.id.buttonThread);
        buttonHandler = (Button)findViewById(R.id.buttonHandler);
        buttonAsyncTask = (Button)findViewById(R.id.buttonAsyncTask);

        buttonThread.setOnClickListener(this);
        buttonHandler.setOnClickListener(this);
        buttonAsyncTask.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonThread:
                startThread();
                break;
            case R.id.buttonHandler:
                startHandler();
                break;
            case R.id.buttonAsyncTask:
                startAsyncTask();
                break;
            default:
                break;

        }
    }
    private void startThread(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                String imageUrl = editTextUrl.getText().toString();
                //TODO check url pattern
                try {
                    final Bitmap bitmap = Network.downloadBitmap(imageUrl);
                    DownloadImageFromUrlActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            imageViewDownloaded.setImageBitmap(bitmap);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        t.start();
    }
    private void startAsyncTask(){
        new ImageDownloader().execute(editTextUrl.getText().toString());
    }
    private void startHandler(){
        final String imageUrl = editTextUrl.getText().toString();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final Bitmap bitmap = Network.downloadBitmap(imageUrl);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            imageViewDownloaded.setImageBitmap(bitmap);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }


    private class ImageDownloader extends AsyncTask<String,Integer,Bitmap>{

        @Override
        protected Bitmap doInBackground(String... params) {

            Bitmap bitmap = null;
            try {
                bitmap = Network.downloadBitmap(params[0]);
            } catch (IOException e) {
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imageViewDownloaded.setImageBitmap(bitmap);
        }
    }
}
