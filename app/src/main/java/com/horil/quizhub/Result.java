package com.horil.quizhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.horil.quizhub.QuizViewHandlers.QuizActIndia;

public class Result extends AppCompatActivity {
    private final String TAG = Result.class.getSimpleName();

    TextView cAnswers, wAnswers, sQuestions;
    // AdView adView;
    AdView adView;
    InterstitialAd interstitialAd;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_result);

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
       /* // FB Ads
        AudienceNetworkAds.initialize(this);
        adView = new AdView(this, "593393224452198_597132234078297", AdSize.BANNER_HEIGHT_50);

        // Find the Ad Container
        final LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);

        // Add the ad view to your activity layout
        adContainer.addView(adView);
        // Request an ad
        adView.loadAd();
        adView.setAdListener(new AdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {

            }

            @Override
            public void onAdLoaded(Ad ad) {
                adContainer.setVisibility(View.VISIBLE);

            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        });

*/
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

    public void onBackPressed(){
        Intent in = new Intent(getApplicationContext(), MainActivity.class);
        in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(in);

    }
}