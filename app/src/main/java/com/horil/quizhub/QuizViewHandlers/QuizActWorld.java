package com.horil.quizhub.QuizViewHandlers;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.horil.quizhub.DBHelpers.DBHelperForSC_Two;
import com.horil.quizhub.ListViewHandlers.SubCategoryTwoQuiz;
import com.horil.quizhub.R;
import com.horil.quizhub.Result;

import java.io.IOException;

public class QuizActWorld extends AppCompatActivity {

    AdView adView;
    InterstitialAd interstitialAd;
    //For Sqlite
    public static int Questionnumber = 0;
    public String[] data = new String[8];
    DBHelperForSC_Two dbhelper;
    //
    LinearLayout optionA, optionB, optionC, optionD;
    TextView questiontext, qnumber, optionatext, optionbtext, optionctext, optiondtext, selectedquiz;
    Button nextbtn,  fbsharebtn, washarebtn;
    public static int CurrentQuestion = 0;
    public static int Lastquestion = 0;
    public static int correctanswer = 0;
    public static int firstclick = 0;
    public static int skippedq = 0;
    public static int qcounter = 1;
    public static int wronganswer = 0;
    public static int selectedquizn = 0;
    int click = 0;
    public static final String Correct_Answered = "com.quizguru.correctanswered";
    public static final String Wrong_Answered = "com.quizguru.wronganswered";
    public static final String Skipped_Questions = "com.quizguru.skippedquestions";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.quiz_view);


        adView = (AdView) findViewById(R.id.banner_ad);
        MobileAds.initialize(this, "" + getResources().getString(R.string.admob_app_id));
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getResources().getString(R.string.interstitial_ad_unit));
        interstitialAd.loadAd(adRequest);

        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                interstitialAd.show();
            }
        });
        //SQLITE
        this.dbhelper = new DBHelperForSC_Two(this);
        try {
            this.dbhelper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Cursor cur;
        StringBuffer sb;

        //Code to receive Intent
        Intent in = getIntent();
        int clickindex = in.getIntExtra(SubCategoryTwoQuiz.Click_Index, 0);

        qcounter = 1;
        correctanswer = 0;
        wronganswer = 0;
        skippedq = 0;

        optionA = (LinearLayout) findViewById(R.id.optionA);
        optionB = (LinearLayout) findViewById(R.id.optionB);
        optionC = (LinearLayout) findViewById(R.id.optionC);
        optionD = (LinearLayout) findViewById(R.id.optionD);
        optionatext = (TextView) findViewById(R.id.optionAtext);
        optionbtext = (TextView) findViewById(R.id.optionBtext);
        optionctext = (TextView) findViewById(R.id.optionCtext);
        optiondtext = (TextView) findViewById(R.id.optionDtext);

        selectedquiz = (TextView) findViewById(R.id.selectedquiz);
        questiontext = (TextView) findViewById(R.id.question_Text);
        qnumber = (TextView) findViewById(R.id.qnumber);
        nextbtn = (Button) findViewById(R.id.nextqbtn);
        fbsharebtn= (Button) findViewById(R.id.fbsharebtn);
        washarebtn= (Button) findViewById(R.id.washarebtn);

// Code to select question number and options from Array
        if (clickindex == 0) {
            CurrentQuestion = clickindex+1;
        } else {
            CurrentQuestion = clickindex * 10 + 1;
        }
        selectedquizn = clickindex + 1;
        Questionnumber = CurrentQuestion;
        cur = this.dbhelper.getData();
        Lastquestion = CurrentQuestion + 10;

        if (cur.getCount() == 0) {
            Toast.makeText(getApplicationContext(), "No Question Available", Toast.LENGTH_SHORT).show();
            return;
        }
        sb = new StringBuffer();
        while (cur.moveToNext()) {
            this.data[0] = cur.getString(0);
            this.data[1] = cur.getString(1);
            this.data[2] = cur.getString(2);
            this.data[3] = cur.getString(3);
            this.data[4] = cur.getString(4);
            this.data[5] = cur.getString(5);
            this.data[6] = cur.getString(6);
        }

        this.selectedquiz.setText("Quiz: " +selectedquizn);
        ((TextView) findViewById(R.id.qnumber)).setText("1/10");
        this.questiontext.setText(" " + this.data[1]);
        this.optionatext.setText(this.data[2]);
        this.optionbtext.setText(this.data[3]);
        this.optionctext.setText(this.data[4]);
        this.optiondtext.setText(this.data[5]);


        //Share on WA
        washarebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent("android.intent.action.SEND");
                i.setType("text/plain");
                i.putExtra("android.intent.extra.SUBJECT", "" + getString(R.string.app_name));
                i.putExtra("android.intent.extra.TEXT", "" + (questiontext.getText() + "\n" + "A. " + optionatext.getText() + "\n" + "B. " + optionbtext.getText() + "\n" + "C. " + optionctext.getText() + "\n" + "D. " + optiondtext.getText()) + "\n\n" + getString(R.string.link) + getString(R.string.playlink));
                startActivity(Intent.createChooser(i, "Share It :--"));
            }
        });
        //Share on Messesnger
        fbsharebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent("android.intent.action.SEND");
                i.setType("text/plain");
                i.putExtra("android.intent.extra.SUBJECT", "" + getString(R.string.app_name));
                i.putExtra("android.intent.extra.TEXT", "" + (questiontext.getText() + "\n" + "A. " + optionatext.getText() + "\n" + "B. " + optionbtext.getText() + "\n" + "C. " + optionctext.getText() + "\n" + "D. " + optiondtext.getText()) + "\n\n" + getString(R.string.link) + getString(R.string.playlink));
                startActivity(Intent.createChooser(i, "Share It :--"));
            }
        });
        //Next Button onClick
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nextbtn.getText().toString().equals("Skip"))
                {
                    skippedq ++;
                }
                CurrentQuestion++;
                if (CurrentQuestion >= Lastquestion) {
                    Intent in = new Intent(getApplicationContext(), Result.class);
                    in.putExtra(Correct_Answered, correctanswer);
                    in.putExtra(Wrong_Answered, wronganswer);
                    in.putExtra(Skipped_Questions, skippedq);
                    startActivity(in);
                }

                else {
                    qcounter++;
                    Questionnumber++;
                    firstclick = 0;
                    nextbtn.setText("Skip");
                    Cursor cur = dbhelper.getData();
                    StringBuffer sb = new StringBuffer();
                    while (cur.moveToNext()) {
                        data[0] = cur.getString(0);
                        data[1] = cur.getString(1);
                        data[2] = cur.getString(2);
                        data[3] = cur.getString(3);
                        data[4] = cur.getString(4);
                        data[5] = cur.getString(5);
                        data[6] = cur.getString(6);
                    }
                    ((TextView) findViewById(R.id.qnumber)).setText(String.valueOf(qcounter) + "/10");
                    optionA.setEnabled(true);
                    optionB.setEnabled(true);
                    optionC.setEnabled(true);
                    optionD.setEnabled(true);
                    optionA.setBackgroundResource(R.drawable.buttongradoptionback);
                    optionB.setBackgroundResource(R.drawable.buttongradoptionback);
                    optionC.setBackgroundResource(R.drawable.buttongradoptionback);
                    optionD.setBackgroundResource(R.drawable.buttongradoptionback);
                    questiontext.setText(" " + data[1]);
                    optionatext.setText(data[2]);
                    optionbtext.setText(data[3]);
                    optionctext.setText(data[4]);
                    optiondtext.setText(data[5]);
                }
            }
        });


        optionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                optionAclicked();
            }
        });
        optionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                optionBclicked();
            }
        });
        optionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                optionCclicked();
            }
        });
        optionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                optionDclicked();
            }
        });
    }


    public void optionAclicked() {
        nextbtn.setText("Next");
        String clickedans = this.data[6];
        if (this.optionatext.getText().toString().equals(clickedans)) {

            correctanswer++;
            this.optionA.setEnabled(false);
            this.optionB.setEnabled(false);
            this.optionC.setEnabled(false);
            this.optionD.setEnabled(false);
            Toast.makeText(getApplicationContext(), "Correct Ans", Toast.LENGTH_SHORT).show();
            this.optionA.setBackgroundResource(R.drawable.buttongradcorrect);
        } else if (clickedans.equals(this.optionbtext.getText().toString())) {

            wronganswer++;
            this.optionA.setEnabled(false);
            this.optionB.setEnabled(false);
            this.optionC.setEnabled(false);
            this.optionD.setEnabled(false);
            Toast.makeText(getApplicationContext(), "Incorrect Ans", Toast.LENGTH_SHORT).show();
            this.optionA.setBackgroundResource(R.drawable.buttongradwrong);
            this.optionB.setBackgroundResource(R.drawable.buttongradcorrect);
        } else if (clickedans.equals(this.optionctext.getText().toString())) {

            wronganswer++;
            this.optionA.setEnabled(false);
            this.optionB.setEnabled(false);
            this.optionC.setEnabled(false);
            this.optionD.setEnabled(false);
            Toast.makeText(getApplicationContext(), "Incorrect Ans", Toast.LENGTH_SHORT).show();
            this.optionA.setBackgroundResource(R.drawable.buttongradwrong);
            this.optionC.setBackgroundResource(R.drawable.buttongradcorrect);
        } else if (clickedans.equals(this.optiondtext.getText().toString())) {

            wronganswer++;
            this.optionA.setEnabled(false);
            this.optionB.setEnabled(false);
            this.optionC.setEnabled(false);
            this.optionD.setEnabled(false);

            Toast.makeText(getApplicationContext(), "Incorrect Ans", Toast.LENGTH_SHORT).show();
            this.optionA.setBackgroundResource(R.drawable.buttongradwrong);
            this.optionD.setBackgroundResource(R.drawable.buttongradcorrect);
        }
    }

    public void optionBclicked() {
        nextbtn.setText("Next");
        String clickedans = this.data[6];
        if (this.optionbtext.getText().toString().equals(clickedans)) {

            correctanswer++;
            this.optionA.setEnabled(false);
            this.optionB.setEnabled(false);
            this.optionC.setEnabled(false);
            this.optionD.setEnabled(false);
            Toast.makeText(getApplicationContext(), "Correct Ans", Toast.LENGTH_SHORT).show();
            this.optionB.setBackgroundResource(R.drawable.buttongradcorrect);
        } else if (clickedans.equals(this.optionatext.getText().toString())) {

            wronganswer++;
            this.optionA.setEnabled(false);
            this.optionB.setEnabled(false);
            this.optionC.setEnabled(false);
            this.optionD.setEnabled(false);
            Toast.makeText(getApplicationContext(), "Incorrect Ans", Toast.LENGTH_SHORT).show();
            this.optionB.setBackgroundResource(R.drawable.buttongradwrong);
            this.optionA.setBackgroundResource(R.drawable.buttongradcorrect);
        } else if (clickedans.equals(this.optionctext.getText().toString())) {

            wronganswer++;
            this.optionA.setEnabled(false);
            this.optionB.setEnabled(false);
            this.optionC.setEnabled(false);
            this.optionD.setEnabled(false);
            Toast.makeText(getApplicationContext(), "Incorrect Ans", Toast.LENGTH_SHORT).show();
            this.optionB.setBackgroundResource(R.drawable.buttongradwrong);
            this.optionC.setBackgroundResource(R.drawable.buttongradcorrect);
        } else if (clickedans.equals(this.optiondtext.getText().toString())) {

            wronganswer++;
            this.optionA.setEnabled(false);
            this.optionB.setEnabled(false);
            this.optionC.setEnabled(false);
            this.optionD.setEnabled(false);
            Toast.makeText(getApplicationContext(), "Incorrect Ans", Toast.LENGTH_SHORT).show();
            this.optionB.setBackgroundResource(R.drawable.buttongradwrong);
            this.optionD.setBackgroundResource(R.drawable.buttongradcorrect);
        }

    }

    public void optionCclicked() {
        nextbtn.setText("Next");
        String clickedans = this.data[6];
        if (this.optionctext.getText().toString().equals(clickedans)) {

            correctanswer++;
            this.optionA.setEnabled(false);
            this.optionB.setEnabled(false);
            this.optionC.setEnabled(false);
            this.optionD.setEnabled(false);
            Toast.makeText(getApplicationContext(), "Correct Ans", Toast.LENGTH_SHORT).show();
            this.optionC.setBackgroundResource(R.drawable.buttongradcorrect);
        } else if (clickedans.equals(this.optionbtext.getText().toString())) {

            wronganswer++;
            this.optionA.setEnabled(false);
            this.optionB.setEnabled(false);
            this.optionC.setEnabled(false);
            this.optionD.setEnabled(false);
            Toast.makeText(getApplicationContext(), "Incorrect Ans", Toast.LENGTH_SHORT).show();
            this.optionC.setBackgroundResource(R.drawable.buttongradwrong);
            this.optionB.setBackgroundResource(R.drawable.buttongradcorrect);
        } else if (clickedans.equals(this.optionatext.getText().toString())) {

            wronganswer++;
            this.optionA.setEnabled(false);
            this.optionB.setEnabled(false);
            this.optionC.setEnabled(false);
            this.optionD.setEnabled(false);
            Toast.makeText(getApplicationContext(), "Incorrect Ans", Toast.LENGTH_SHORT).show();
            this.optionC.setBackgroundResource(R.drawable.buttongradwrong);
            this.optionA.setBackgroundResource(R.drawable.buttongradcorrect);
        } else if (clickedans.equals(this.optiondtext.getText().toString())) {

            wronganswer++;
            this.optionA.setEnabled(false);
            this.optionB.setEnabled(false);
            this.optionC.setEnabled(false);
            this.optionD.setEnabled(false);

            Toast.makeText(getApplicationContext(), "Incorrect Ans", Toast.LENGTH_SHORT).show();
            this.optionC.setBackgroundResource(R.drawable.buttongradwrong);
            this.optionD.setBackgroundResource(R.drawable.buttongradcorrect);
        }
    }

    public void optionDclicked() {
        nextbtn.setText("Next");
        String clickedans = this.data[6];
        if (this.optiondtext.getText().toString().equals(clickedans)) {

            correctanswer++;
            this.optionA.setEnabled(false);
            this.optionB.setEnabled(false);
            this.optionC.setEnabled(false);
            this.optionD.setEnabled(false);

            Toast.makeText(getApplicationContext(), "Correct Ans", Toast.LENGTH_SHORT).show();
            this.optionD.setBackgroundResource(R.drawable.buttongradcorrect);
        } else if (clickedans.equals(this.optionbtext.getText().toString())) {

            wronganswer++;
            this.optionA.setEnabled(false);
            this.optionB.setEnabled(false);
            this.optionC.setEnabled(false);
            this.optionD.setEnabled(false);

            Toast.makeText(getApplicationContext(), "Incorrect Ans", Toast.LENGTH_SHORT).show();
            this.optionD.setBackgroundResource(R.drawable.buttongradwrong);
            this.optionB.setBackgroundResource(R.drawable.buttongradcorrect);
        } else if (clickedans.equals(this.optionctext.getText().toString())) {

            wronganswer++;
            this.optionA.setEnabled(false);
            this.optionB.setEnabled(false);
            this.optionC.setEnabled(false);
            this.optionD.setEnabled(false);

            Toast.makeText(getApplicationContext(), "Incorrect Ans", Toast.LENGTH_SHORT).show();
            this.optionD.setBackgroundResource(R.drawable.buttongradwrong);
            this.optionC.setBackgroundResource(R.drawable.buttongradcorrect);
        } else if (clickedans.equals(this.optionatext.getText().toString())) {
            wronganswer++;
            this.optionA.setEnabled(false);
            this.optionB.setEnabled(false);
            this.optionC.setEnabled(false);
            this.optionD.setEnabled(false);
            Toast.makeText(getApplicationContext(), "Incorrect Ans", Toast.LENGTH_SHORT).show();
            this.optionD.setBackgroundResource(R.drawable.buttongradwrong);
            this.optionA.setBackgroundResource(R.drawable.buttongradcorrect);
        }
    }
}
