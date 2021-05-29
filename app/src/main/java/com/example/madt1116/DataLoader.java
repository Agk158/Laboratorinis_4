package com.example.madt1116;

import android.os.AsyncTask;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

public class DataLoader extends AsyncTask<Void, Void, ArrayList<String>> {

    /*protected String doInBackground(String... params) {
        try {
            return DataManager.getRateFromECB(params[0]); //nereikia currency code
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            return sw.toString();
        }
    }*/

    protected ArrayList<String> doInBackground(Void... params) {
        try {
            return DataManager.getRateFromECB(); //nereikia currency code
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
        }
        return null;
    }
}