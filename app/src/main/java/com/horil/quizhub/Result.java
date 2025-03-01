package com.horil.quizhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.horil.quizhub.QuizViewHandlers.QuizActIndia;

public class Result extends AppCompatActivity {
    private final String TAG = Result.class.getSimpleName();

    TextView cAnswers, wAnswers, sQuestions;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_result);
        //Code to receive Intent
        Intent cAintent = getIntent();
        int correctanswers = cAintent.getIntExtra(QuizActIndia.Correct_Answered, 0);

        //Code to receive Intent
        Intent wAintent = getIntent();
        int wronganwers = wAintent.getIntExtra(QuizActIndia.Wrong_Answered, 0);

        //Code to receive skipped questions Intent
        Intent sQuistions = getIntent();
        int sQuistionsn = sQuistions.getIntExtra(QuizActIndia.Skipped_Questions, 0);


        cAnswers = (TextView)findViewById(R.id.correctAnswers);
        wAnswers = (TextView)findViewById(R.id.wrongAnswers);
        sQuestions = (TextView)findViewById(R.id.skipped);


        sQuestions.setText("" +sQuistionsn);
        cAnswers.setText("" +correctanswers);
        wAnswers.setText("" +wronganwers);
    }

    public void onBackPressed() {
        super.onBackPressed();
        Intent in = new Intent(getApplicationContext(), MainActivity.class);
        in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(in);

    }
}