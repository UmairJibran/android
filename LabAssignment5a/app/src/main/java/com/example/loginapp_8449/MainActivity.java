package com.example.loginapp_8449;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText username, password, retype_password;
    Button sign_in, sign_up;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        retype_password = findViewById(R.id.retype_password);
        sign_up = findViewById(R.id.btn_sign_up);
        sign_in = findViewById(R.id.btn_sign_in);
        DB = new DBHelper(this);


        //Register listener
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String retype_pass = retype_password.getText().toString();

                if(user.equals("") || pass.equals("") || retype_pass.equals(""))
                {
                    Toast.makeText(MainActivity.this, "Text boxes should not be empty",Toast.LENGTH_LONG).show();
                }
                else
                {
                    if (pass.equals(retype_pass))
                    {
                        boolean check_username = DB.check_username(user);
                        if(!check_username)
                        {
                            Boolean insert = DB.insertData(user,pass);
                            if(insert)
                            {
                                Toast.makeText(MainActivity.this, "Register Successful!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                                //You should send the user data here in intent to home page
                                startActivity(intent);
                            }
                            else
                                {
                                    Toast.makeText(MainActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                                }
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "User Already exist", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Password Not matching", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });


        //Login listener
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
