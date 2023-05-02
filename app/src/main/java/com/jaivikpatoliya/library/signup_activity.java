package com.jaivikpatoliya.library;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class signup_activity extends AppCompatActivity {
    EditText first,last,pass,name;
    Button btn;
    TextView login;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
        setTitle("SignUp");
        first = findViewById(R.id.etfname);
        last = findViewById(R.id.etlname);
        pass  =findViewById(R.id.etsignup_password);
        name  =findViewById(R.id.etusername);
        btn = findViewById(R.id.btnsignup);
        login = findViewById(R.id.txtlogin);
        login.setOnClickListener(view -> {
            Intent i = new Intent(signup_activity.this,Login_Activity.class);
            startActivity(i);
        });
       Intent intent = new Intent(signup_activity.this,Login_Activity.class);

        btn.setOnClickListener(view -> {
            String fname = first.getText().toString();
            String lname = last.getText().toString();
            String validname = name.getText().toString();
            String validpassword = pass.getText().toString();
            if((fname.equals("")) || lname.equals("") || validpassword.equals("") || validname.equals("")){
                Toast.makeText(signup_activity.this, "SignUp failed", Toast.LENGTH_SHORT).show();
            }
            else {
              Bundle bundle = new Bundle();
              bundle.putString("First name",fname);
              bundle.putString("Last name",lname);
              bundle.putString("username",validname);
              bundle.putString("password",validpassword);
              intent.putExtras(bundle);
              startActivity(intent);
              finish();
            }

        });
    }
}