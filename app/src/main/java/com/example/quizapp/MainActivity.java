package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    List<Question> questions = new ArrayList<Question>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View view) {

    }

    public void createQuestions()
    {
        questions.add(new Question("The term 'Islam' means",
                "Submission","Peace","Fortitude","Thankfulness",1));
        questions.add(new Question("Which of the following is not an essential part of Islamic belief?",
                "Oneness of God","Day of Judgment","Sorcery","Prophets",3));
        questions.add(new Question("The chapters of the Qur’an are known as",
                "Surahs","Sunnahs","Shari’ah","Sufis",1));
        questions.add(new Question("The word jihad means",
                "Pilgrimage","To strive or struggle","Fasting","Prophecy",2));
        questions.add(new Question("Which of the following is not one of the Five Pillars of Islam?",
                "Fasting during the month of Ramadan",
                "Jihad","Declaration of faith"," Prayer five times daily",1));
    }
}

class Question{
    public String content;
    public String option1;
    public String option2;
    public String option3;
    public String option4;
    public int correctOption;
    public Question(String c,String o1,String o2,String o3,String o4,int correct )
    {
        content = c;
        option1 = o1;
        option2 = o2;
        option3 = o3;
        option4 = o4;
        correctOption = correct;
    }
}