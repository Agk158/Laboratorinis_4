package com.example.madt1116;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {
    public ListView sarasas;
    public ArrayAdapter listAdapter;


    TextView tvContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.tvContent = findViewById(R.id.tvContent);
        sarasas = findViewById( R.id. sarasas );
    }

    public void onBtnDownloadClick(View view) {
        this.tvContent.setText("Loading...");
        new DataLoader(){
            @Override
            public void onPostExecute(ArrayList<String> kursuSarasas)
            {
                tvContent.setText(""); //priskirti listview kaip antram darbe, reikia adapterio, arraylistas
                //kursuSarasas = new ArrayList<String>(sp.getStringSet("notes", new HashSet<String>()));
                listAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, kursuSarasas);
                sarasas.setAdapter(listAdapter);

            }

        }.execute(); // turi grazinti array
    }
}