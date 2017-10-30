package com.example.rynel.readwrite;

/**
 * Created by rynel on 10/4/2017.
 */


import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Admin on 10/3/2017.
 */

public class AsyncRetrieval extends AsyncTask<String, String, String> {

    @SuppressLint("StaticFieldLeak")
    private TextView textView, tvTextView;
    private String readData;


    //fixme add method to external and .setText on view to readData

    //adding parameters for Async
    public AsyncRetrieval(TextView textView, TextView tvTextView) {
        this.textView = textView;
        this.tvTextView = tvTextView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        textView.setText("Reading Setup");
    }

    @Override
    protected String doInBackground(String... params) {
        //retrieving from sd card external
        try {
            publishProgress("Reading Data");
            File myFile = new File("/sdcard/","ClassProject");
            FileInputStream fis = new FileInputStream(myFile);
            byte[] dataArray = new byte[fis.available()];

            while (fis.read(dataArray) != -1) {
                readData = new String(dataArray);
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        return readData;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        textView.setText(values[0]);
    }

    @Override
    //displaying data retrieved
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        textView.setText(readData);

        tvTextView.setText(s);
    }
}