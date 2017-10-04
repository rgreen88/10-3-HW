package com.example.rynel.readwrite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView tvLoad;
    private TextView tvSave;
    private EditText etEditText;
    private Button btnLoad;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEditText = (EditText) findViewById(R.id.etEditText);
        tvSave = (TextView) findViewById(R.id.tvSave);
        tvLoad = (TextView) findViewById(R.id.tvLoad);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnLoad = (Button) findViewById(R.id.btnLoad);
    }

    public void usingExternalStorage(View view) { //always have trouble with accessing classes like
                                                  //like this for some reason

        switch (view.getId()){

            case R.id.btnSave:
                MyAsyncTask myAsyncTask = new MyAsyncTask(tvSave, etEditText.getText().toString());
                myAsyncTask.execute();

                break;
            case R.id.btnLoad:
                AsyncRetrieval asyncRetrieval = new AsyncRetrieval(tvSave, tvLoad);
                asyncRetrieval.execute();
                break;
        }
    }
}