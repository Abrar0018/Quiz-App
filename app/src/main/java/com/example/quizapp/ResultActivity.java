package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        intent = getIntent();
        setResult();
    }

    public void setResult()
    {
        String incorrectAnswers = intent.getStringExtra("IncorrectAnswers");
        String correctAnswers = intent.getStringExtra("CorrectAnswers");
        TextView correct = findViewById(R.id.corrAnswers);
        TextView incorrect = findViewById(R.id.incorrAnswers);
        correct.setText("Total Correct Answers: "+correctAnswers);
        incorrect.setText("Total InCorrect Answers: "+incorrectAnswers);
    }
}