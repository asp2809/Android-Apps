package com.example.android.scorekeeperapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView ball1, ball2, ball3, ball4, ball5, ball6, score;
    Button dot, one, two, three, four, six, wide, noball, wicket, reset;
    int score1=0, wicket1=0, ballcount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ball1=findViewById(R.id.firstball);
        ball2=findViewById(R.id.secondball);
        ball3=findViewById(R.id.thirdball);
        ball4=findViewById(R.id.fourthball);
        ball5=findViewById(R.id.fifthball);
        ball6=findViewById(R.id.sixthball);
        dot=findViewById(R.id.dot);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        six=findViewById(R.id.six);
        wide=findViewById(R.id.wide);
        wicket=findViewById(R.id.wicket);
        noball=findViewById(R.id.noball);
        score=findViewById(R.id.score);
        reset=findViewById(R.id.reset);
    }
    public void reset1(View v) {
        score1=0;
        wicket1=0;
        score.setText("0/0");
        ballcount=0;
    }
    public void adddot(View v) {
        if (ballcount==6) {
            ballcount=0;
            ball1.setText(" ");
            ball2.setText(" ");
            ball3.setText(" ");
            ball4.setText(" ");
            ball5.setText(" ");
            ball6.setText(" ");
        }
        switch (ballcount) {
            case 0:
                ball1.setText(".");
                break;
            case 1:
                ball2.setText(".");
                break;
            case 2:
                ball3.setText(".");
                break;
            case 3:
                ball4.setText(".");
                break;
            case 4:
                ball5.setText(".");
                break;
            case 5:
                ball6.setText(".");
        }
        ballcount++;
    }
    public void addone(View v) {
        if (ballcount==6) {
            ballcount=0;
            ball1.setText(" ");
            ball2.setText(" ");
            ball3.setText(" ");
            ball4.setText(" ");
            ball5.setText(" ");
            ball6.setText(" ");
        }
        switch (ballcount) {
            case 0:
                ball1.setText("1");
                break;
            case 1:
                ball2.setText("1");
                break;
            case 2:
                ball3.setText("1");
                break;
            case 3:
                ball4.setText("1");
                break;
            case 4:
                ball5.setText("1");
                break;
            case 5:
                ball6.setText("1");
        }
        score1+=1;
        score.setText(score1 + "/" + wicket1);
        ballcount++;
    }
    public void addtwo(View v) {
        if (ballcount==6) {
            ballcount=0;
            ball1.setText(" ");
            ball2.setText(" ");
            ball3.setText(" ");
            ball4.setText(" ");
            ball5.setText(" ");
            ball6.setText(" ");
        }
        switch (ballcount) {
            case 0:
                ball1.setText("2");
                break;
            case 1:
                ball2.setText("2");
                break;
            case 2:
                ball3.setText("2");
                break;
            case 3:
                ball4.setText("2");
                break;
            case 4:
                ball5.setText("2");
                break;
            case 5:
                ball6.setText("2");
        }
        score1+=2;
        score.setText(score1 + "/" + wicket1);
        ballcount++;
    }
    public void addthree(View v) {
        if (ballcount==6) {
            ballcount=0;
            ball1.setText(" ");
            ball2.setText(" ");
            ball3.setText(" ");
            ball4.setText(" ");
            ball5.setText(" ");
            ball6.setText(" ");
        }
        switch (ballcount) {
            case 0:
                ball1.setText("3");
                break;
            case 1:
                ball2.setText("3");
                break;
            case 2:
                ball3.setText("3");
                break;
            case 3:
                ball4.setText("3");
                break;
            case 4:
                ball5.setText("3");
                break;
            case 5:
                ball6.setText("3");
        }
        score1+=3;
        score.setText(score1 + "/" + wicket1);
        ballcount++;
    }
    public void addfour(View v) {
        if (ballcount==6) {
            ballcount=0;
            ball1.setText(" ");
            ball2.setText(" ");
            ball3.setText(" ");
            ball4.setText(" ");
            ball5.setText(" ");
            ball6.setText(" ");
        }
        switch (ballcount) {
            case 0:
                ball1.setText("4");
                break;
            case 1:
                ball2.setText("4");
                break;
            case 2:
                ball3.setText("4");
                break;
            case 3:
                ball4.setText("4");
                break;
            case 4:
                ball5.setText("4");
                break;
            case 5:
                ball6.setText("4");
        }
        score1+=4;
        score.setText(score1 + "/" + wicket1);
        ballcount++;
    }
    public void addsix(View v) {
        if (ballcount==6) {
            ballcount=0;
            ball1.setText(" ");
            ball2.setText(" ");
            ball3.setText(" ");
            ball4.setText(" ");
            ball5.setText(" ");
            ball6.setText(" ");
        }
        switch (ballcount) {
            case 0:
                ball1.setText("6");
                break;
            case 1:
                ball2.setText("6");
                break;
            case 2:
                ball3.setText("6");
                break;
            case 3:
                ball4.setText("6");
                break;
            case 4:
                ball5.setText("6");
                break;
            case 5:
                ball6.setText("6");
        }
        score1+=6;
        score.setText(score1 + "/" + wicket1);
        ballcount++;
    }
    public void addwicket(View v) {
        if (ballcount==6) {
            ballcount=0;
            ball1.setText(" ");
            ball2.setText(" ");
            ball3.setText(" ");
            ball4.setText(" ");
            ball5.setText(" ");
            ball6.setText(" ");
        }
        if (wicket1 < 10)
        {
            switch (ballcount) {
                case 0:
                    ball1.setText("W");
                    break;
                case 1:
                    ball2.setText("W");
                    break;
                case 2:
                    ball3.setText("W");
                    break;
                case 3:
                    ball4.setText("W");
                    break;
                case 4:
                    ball5.setText("W");
                    break;
                case 5:
                    ball6.setText("W");
            }
            wicket1+=1;
            score.setText(score1 + "/" + wicket1);
            ballcount++;
        }


    }
    public void addwide(View v) {
        if (ballcount==6) {
            ballcount=0;
            ball1.setText(" ");
            ball2.setText(" ");
            ball3.setText(" ");
            ball4.setText(" ");
            ball5.setText(" ");
            ball6.setText(" ");
        }
        score1+=1;
        score.setText(score1 + "/" + wicket1);
    }
    public void addnoball(View v) {
        if (ballcount==6) {
            ballcount=0;
            ball1.setText(" ");
            ball2.setText(" ");
            ball3.setText(" ");
            ball4.setText(" ");
            ball5.setText(" ");
            ball6.setText(" ");
        }
        score1+=1;
        score.setText(score1 + "/" + wicket1);
    }
}
