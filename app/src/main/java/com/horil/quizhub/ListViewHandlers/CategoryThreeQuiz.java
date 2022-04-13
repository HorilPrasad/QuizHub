package com.horil.quizhub.ListViewHandlers;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.horil.quizhub.QuizViewHandlers.QuizActEnglish;
import com.horil.quizhub.R;

public class CategoryThreeQuiz extends AppCompatActivity {
    public static final String Click_Index ="com.quizguru.clickindex";
    public static int[] icon = new int[]{R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo};
    public static String[] itemname = new String[]{"English Quiz - 1", "English Quiz - 2", "English Quiz - 3", "English Quiz - 4", "English Quiz - 5", "English Quiz - 6", "English Quiz - 7", "English Quiz - 8", "English Quiz - 9", "English Quiz - 10", "English Quiz - 11", "English Quiz - 12", "English Quiz - 13", "English Quiz - 14", "English Quiz - 15", "English Quiz - 16", "English Quiz - 17", "English Quiz - 18", "English Quiz - 19", "English Quiz - 20", "English Quiz - 21", "English Quiz - 22", "English Quiz - 23", "English Quiz - 24", "English Quiz - 25", "English Quiz - 26", "English Quiz - 27", "English Quiz - 28", "English Quiz - 29", "English Quiz - 30", "English Quiz - 31", "English Quiz - 32", "English Quiz - 33", "English Quiz - 34", "English Quiz - 35", "English Quiz - 36", "English Quiz - 37", "English Quiz - 38", "English Quiz - 39", "English Quiz - 40", "English Quiz - 41", "English Quiz - 42", "English Quiz - 43", "English Quiz - 44", "English Quiz - 45", "English Quiz - 46", "English Quiz - 47", "English Quiz - 48", "English Quiz - 49", "English Quiz - 50", "English Quiz - 51", "English Quiz - 52", "English Quiz - 53", "English Quiz - 54", "English Quiz - 55", "English Quiz - 56", "English Quiz - 57", "English Quiz - 58", "English Quiz - 59", "English Quiz - 60", "English Quiz - 61", "English Quiz - 62", "English Quiz - 63", "English Quiz - 64", "English Quiz - 65", "English Quiz - 66", "English Quiz - 67", "English Quiz - 68", "English Quiz - 69", "English Quiz - 70", "English Quiz - 71", "English Quiz - 72", "English Quiz - 73", "English Quiz - 74", "English Quiz - 75", "English Quiz - 76", "English Quiz - 77", "English Quiz - 78", "English Quiz - 79", "English Quiz - 80", "English Quiz - 81", "English Quiz - 82", "English Quiz - 83", "English Quiz - 84", "English Quiz - 85", "English Quiz - 86", "English Quiz - 87", "English Quiz - 88", "English Quiz - 89", "English Quiz - 90", "English Quiz - 91", "English Quiz - 92", "English Quiz - 93", "English Quiz - 94", "English Quiz - 95", "English Quiz - 96", "English Quiz - 97", "English Quiz - 98", "English Quiz - 99", "English Quiz - 100", "English Quiz - 101", "English Quiz - 102", "English Quiz - 103", "English Quiz - 104", "English Quiz - 105", "English Quiz - 106", "English Quiz - 107", "English Quiz - 108", "English Quiz - 109", "English Quiz - 110", "English Quiz - 111", "English Quiz - 112", "English Quiz - 113", "English Quiz - 114", "English Quiz - 115", "English Quiz - 116", "English Quiz - 117", "English Quiz - 118", "English Quiz - 119", "English Quiz - 120"};

    ListView listView;
    //  AdView adView;
    //  InterstitialAd interstitialAd;
    AdView adView;
    InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviewactivity);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("English Quiz");
        actionBar.setDisplayHomeAsUpEnabled(true);

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
/*

        // FB Ads
        AudienceNetworkAds.initialize(this);
        adView = new AdView(this, "593393224452198_593398164451704", AdSize.BANNER_HEIGHT_50);
        interstitialAd = new InterstitialAd(this, "593393224452198_593397827785071");

        // For auto play video ads, it's recommended to load the ad
        // at least 30 seconds before it is shown
        interstitialAd.loadAd();
        // Set listeners for the Interstitial Ad
        interstitialAd.setAdListener(new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
                // Interstitial ad displayed callback

            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                // Interstitial dismissed callback
                //SubCategoryOneQuiz.this.startActivity(new Intent(SubCategoryOneQuiz.this.getApplicationContext(), QuizAct.class));
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback

            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Interstitial ad is loaded and ready to be displayed
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Ad clicked callback

            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Ad impression logged callback

            }
        });

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

        listView = (ListView) findViewById(R.id.listview);

        CustomAdaptor  customAdaptor= new CustomAdaptor();
        listView.setAdapter(customAdaptor);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent in = new Intent(getApplicationContext(), QuizActEnglish.class);
                in.putExtra(Click_Index, position);
                if(interstitialAd ==null || !interstitialAd.isLoaded())
                {
                    startActivity(in);
                }
                else
                {
                    startActivity(in);
                    interstitialAd.show();
                }

            }
        });
    }

    class CustomAdaptor extends BaseAdapter {

        @Override
        public int getCount() {
            return icon.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view= getLayoutInflater().inflate(R.layout.list_model, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.lv_image);
            TextView textView = (TextView) view.findViewById(R.id.lv_text);
            imageView.setImageResource(icon[i]);
            textView.setText(itemname[i]);
            return view;
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
