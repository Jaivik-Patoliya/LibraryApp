package com.jaivikpatoliya.library;
import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class Login_Activity extends AppCompatActivity {


    Button button;
    EditText name;
    EditText pass;
    TextView signup;
    SharedPreferences sharedPreferences;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        button = findViewById(R.id.btnlogin);
        name = findViewById(R.id.etname);
        pass = findViewById(R.id.etPassword);
        signup = findViewById(R.id.txtsignup);
        String validname = getIntent().getStringExtra("username");
        String validpassword = getIntent().getStringExtra("password");
        sharedPreferences = getSharedPreferences(getString(R.string.Preference_file_name), Context.MODE_PRIVATE);
        boolean isloggedin = sharedPreferences.getBoolean("isloggedin",false);
        if(isloggedin){
        Intent a = new Intent(Login_Activity.this,Home_activity.class);
            startActivity(a);
            finish();
       }
        button.setOnClickListener(view -> {
            String user = name.getText().toString();
            String password = pass.getText().toString();
            if ((user.equals(validname)) && (password.equals(validpassword))) {
                savepreferences(validname);
                Intent intent = new Intent(Login_Activity.this, Home_activity.class);
                startActivity(intent);
            } else {
                Toast.makeText(Login_Activity.this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
        });
        signup.setOnClickListener(view -> {
            Intent i = new Intent(Login_Activity.this,signup_activity.class);
            startActivity(i);
        });
    }
        public void onPause(){
      super.onPause();
      finish();
    }
    void savepreferences(String title){
        sharedPreferences.edit().putBoolean("isloggedin",true).apply();
        sharedPreferences.edit().putString("Title",title).apply();
    }
}