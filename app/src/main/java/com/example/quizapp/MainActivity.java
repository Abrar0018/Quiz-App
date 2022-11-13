package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    List<Question> questions = new ArrayList<Question>();
    Question currentQuestion;
    int correctAnswers = 0,incorrectAnswers=0,questionNumber=0;
    List<RadioButton> optionRadios = new ArrayList<>();
    TextView questionContentView;
    TextView questionNumView;
    Button nextBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    public void onClick(View view) {
        RadioGroup radioButtonGroup = findViewById(R.id.radioGroup);

        //get selected option
        int radioButtonID = radioButtonGroup.getCheckedRadioButtonId();
        View radioButton = radioButtonGroup.findViewById(radioButtonID);
        int idx = radioButtonGroup.indexOfChild(radioButton)+1;

        //check if the selected option is correct
        if(idx == currentQuestion.correctOption)
            correctAnswers++;
        else
            incorrectAnswers++;

        //all questions have been answered
        if(questionNumber==questions.size()-1)
        {
            //launch result activity
            Intent intent = new Intent(this,ResultActivity.class);
            intent.putExtra("IncorrectAnswers",Integer.toString(incorrectAnswers));
            intent.putExtra("CorrectAnswers",Integer.toString(correctAnswers));
            startActivity(intent);
            return;
        }

        //last question is reached
        if(questionNumber==questions.size()-2)
            nextBtn.setText("Finish");



        questionNumView.setText("Question # " + ++questionNumber);
        setQuestion(questions.get(questionNumber));
    }

    public void init()
    {
        //add event listener to the nextBtn
        nextBtn = findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(this);
        //get question content textview
        questionContentView = findViewById(R.id.question);
        //get all for option's radio btns
        optionRadios.add(findViewById(R.id.option1));
        optionRadios.add(findViewById(R.id.option2));
        optionRadios.add(findViewById(R.id.option3));
        optionRadios.add(findViewById(R.id.option4));
        //get question number textview
        questionNumView = findViewById(R.id.questionNum);
        questionNumView.setText("Question # " + questionNumber);
        //initialize questions list
        createQuestions();
        //set first question
        setQuestion(questions.get(questionNumber));
    }

    public void setQuestion(Question question)
    {
        currentQuestion = question;
        questionContentView.setText(question.content);
        optionRadios.get(0).setText(question.option1);
        optionRadios.get(1).setText(question.option2);
        optionRadios.get(2).setText(question.option3);
        optionRadios.get(3).setText(question.option4);
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