package com.example.android.questionnaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText email, phone;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=findViewById(R.id.email);
        phone=findViewById(R.id.mobile);
        login=findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (phone.getText().toString().length()<10) {
                    Toast.makeText(MainActivity.this, "Contact must be 10 digits", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                    Intent obj=new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(obj);
                }
            }
        });

    }
}
