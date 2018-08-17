package com.example.android.questionnaire;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    Button maths, chem, phy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        maths=findViewById(R.id.maths);
        chem=findViewById(R.id.chem);
        phy=findViewById(R.id.phy);
        maths.setOnClickListener(this);
        chem.setOnClickListener(this);
        phy.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.maths:
                Intent obj1=new Intent(getApplicationContext(), Main3Activity.class);
                startActivity(obj1);
                break;
            case R.id.chem:
                Intent obj2=new Intent(getApplicationContext(), Main5Activity.class);
                startActivity(obj2);
                break;
            case R.id.phy:
                Intent obj3=new Intent(getApplicationContext(), Main6Activity.class);
                startActivity(obj3);
                break;
        }
    }
}
