package com.jaivikpatoliya.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class header_activity extends AppCompatActivity {
    TextView textView;
    String titlename;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header);

        textView = findViewById(R.id.username);
        sharedPreferences = getSharedPreferences(getString(R.string.Preference_file_name), Context.MODE_PRIVATE);
        titlename = sharedPreferences.getString("Title", titlename);
        textView.setText(titlename);
    }
}