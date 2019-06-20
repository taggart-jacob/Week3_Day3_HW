package com.example.week3_day3_hw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements ArraySort.AsyncCallback {

    TextView tvDisplay;
    String piDbl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.tvDisplay);
        tvDisplay.setText("");
    }

    public Runnable runnable() {
        tvDisplay.setText("");
        tvDisplay.setTextSize(40);
        final Runnable returnRunnable = new Runnable() {
            @Override
            public void run() {

                try{
                    piDbl = calculatePi();
                    tvDisplay.setText(piDbl);
                } catch(Exception e){
                    e.printStackTrace();
                }

            }
        };
        return returnRunnable;

    }

    private String calculatePi() {
        DecimalFormat df = new DecimalFormat("#.############");
        String dblPi = df.format(Math.PI);

        return dblPi;
    }


    public void onClick(View view) {
        tvDisplay.setTextSize(10);
        ArraySort asyncTask = new ArraySort(this);
        asyncTask.execute("Async Task");
    }


    @Override
    public void returnString(String s) {
        tvDisplay.setText(s);
    }

    public void onClickPi(View view) {
        Thread thrd = new Thread(runnable());
        runOnUiThread(thrd);
    }

    public void onClickFib(View view) {
    }

    public void onClickDB(View view) {
    }
}
