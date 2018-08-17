package com.example.android.questionnaire;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {
    CheckBox b11, b12, b13, b14;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        b11=findViewById(R.id.b11);
        b12=findViewById(R.id.b12);
        b13=findViewById(R.id.b13);
        b14=findViewById(R.id.b14);
        submit=findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b11.isChecked() && !b12.isChecked() && !b13.isChecked() && b14.isChecked())
                {
                    SharedPreferences obj=getSharedPreferences("mydat", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=obj.edit();
                    int score=obj.getInt("score", 0);
                    score+=1;
                    editor.putInt("score", score);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_LONG).show();
                Intent jump=new Intent(getApplicationContext(), Main4Activity.class);
                startActivity(jump);
    }
});
    }
}