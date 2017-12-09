package com.assignment.victor.decider;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class DeciderActivity extends AppCompatActivity {

    private ImageView personImg, firsQuestionImg, secondQuestionImg;
    private TextView personNameTV, questionTextTV;
    private ProgressBar lastQuestionResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decider);

        final Intent data = getIntent();
        final String userName = data.getStringExtra(CONST.USERNAME);

        String personNameText = data.getStringExtra(CONST.PERSON_NAME);
        personNameTV = findViewById(R.id.personTV);
        personNameTV.setText(personNameText);

        String questionText = data.getStringExtra(CONST.QUESTION_TEXT);
        questionTextTV = findViewById(R.id.questionTV);
        questionTextTV.setText(questionText);

        lastQuestionResult = findViewById(R.id.progressBar);
        lastQuestionResult.setProgress(0);
        lastQuestionResult.setMax(100);

        personImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagerClickEvent(v,userName);
                updateProgressBar();
                updateQuestionText();
            }
        });
    }

    private void imagerClickEvent(View v, String userName) {
        Intent imageClickIntent = new Intent();
        imageClickIntent.putExtra(CONST.USERNAME, userName);
        imageClickIntent.putExtra(CONST.VOTE, v.getId());
        startActivityForResult(imageClickIntent, CONST.REQUEST_NEXT_IMAGE);
    }

    private void updateProgressBar() {
        lastQuestionResult.incrementProgressBy(num);
    }

    private void updateQuestionText() {
        questionTextTV.setText(someText);
    }

    private void loadUserDetails() {

    }


}
