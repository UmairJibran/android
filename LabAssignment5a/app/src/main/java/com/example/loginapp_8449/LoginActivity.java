package com.example.loginapp_8449;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button btn_sign_in;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username1);
        password = findViewById(R.id.password1);
        btn_sign_in = findViewById(R.id.btn_login);
        DB = new DBHelper(this);

        btn_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("") || pass.equals(""))
                {
                    Toast.makeText(LoginActivity.this, "please enter your name and pasword", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    boolean check_user = DB.check_username_password(user,pass);
                    if(check_user)
                    {
                        Toast.makeText(LoginActivity.this, "SignIn successful ", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        //You should send the user data here in intent to home page
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this, "Username Or password is incorrect", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}
