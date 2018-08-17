package com.example.android.questionnaire;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {
    Button score, test;
    TextView scoreshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        score=findViewById(R.id.score);
        test=findViewById(R.id.test);
        scoreshow=findViewById(R.id.scoreshow);
        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences obj=getSharedPreferences("mydat", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=obj.edit();
                int score1=obj.getInt("score", 0);
                editor.commit();
                scoreshow.setText(score1+"");
            }
        });
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent test=new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(test);
            }
        });
    }
}
