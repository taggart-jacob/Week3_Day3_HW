package com.example.week3_day3_hw;
//Use AsyncTask to sort an array of 1000 randomly generated numbers

import android.os.AsyncTask;

import java.util.Arrays;
import java.util.Random;

public class ArraySort extends AsyncTask<String, String, String> {

    AsyncCallback asyncCallback;

    public ArraySort(AsyncCallback asyncCallback) {
        this.asyncCallback = asyncCallback;
    }

    @Override
    protected String doInBackground(String... s) {

        String sortArray[] = new String[1000];
        Integer intArray[] = new Integer[1000];

        //randomization
        Random random = new Random();

        String string = "";

        for (int i = 0; i < 1000; i++){
            intArray[i] = random.nextInt(1000);
        }

        Arrays.sort(intArray);

        for (int j = 0; j < 1000; j++) {
            sortArray[j] = Integer.toString(intArray[j]);
            string += sortArray[j] + ",";
        }

        return string;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(String... s) {
        super.onProgressUpdate(s);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        asyncCallback.returnString(s);
    }

    interface AsyncCallback {
        void returnString(String s);
    }
}
