package com.jaivikpatoliya.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class spalsh_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        new Handler().postDelayed(() -> {
            Intent i = new Intent(spalsh_activity.this,Login_Activity.class);
           startActivity(i);
           finish();
        },1000);
    }
}