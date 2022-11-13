package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View view) {

    }
}

class Question{
    public String content;
    public String option1;
    public String option2;
    public String option3;
    public String option4;
    public Question(String c,String o1,String o2,String o3,String o4 )
    {
        content = c;
        option1 = o1;
        option2 = o2;
        option3 = o3;
        option4 = o4;
    }

}