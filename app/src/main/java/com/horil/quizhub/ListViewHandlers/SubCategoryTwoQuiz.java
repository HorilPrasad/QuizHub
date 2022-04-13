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
import com.horil.quizhub.QuizViewHandlers.QuizActWorld;
import com.horil.quizhub.R;

public class SubCategoryTwoQuiz extends AppCompatActivity {

    public static final String Click_Index ="com.quizguru.clickindex";
    int[] icon = {R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo};
    String[] itemname = {"World Quiz- 1", "World Quiz- 2", "World Quiz- 3", "World Quiz- 4", "World Quiz- 5", "World Quiz- 6", "World Quiz- 7", "World Quiz- 8", "World Quiz- 9", "World Quiz- 10", "World Quiz- 11", "World Quiz- 12", "World Quiz- 13", "World Quiz- 14", "World Quiz- 15", "World Quiz- 16", "World Quiz- 17", "World Quiz- 18", "World Quiz- 19", "World Quiz- 20", "World Quiz- 21", "World Quiz- 22", "World Quiz- 23", "World Quiz- 24", "World Quiz- 25", "World Quiz- 26", "World Quiz- 27", "World Quiz- 28", "World Quiz- 29", "World Quiz- 30", "World Quiz- 31", "World Quiz- 32", "World Quiz- 33", "World Quiz- 34", "World Quiz- 35", "World Quiz- 36", "World Quiz- 37", "World Quiz- 38", "World Quiz- 39", "World Quiz- 40", "World Quiz- 41", "World Quiz- 42", "World Quiz- 43", "World Quiz- 44", "World Quiz- 45", "World Quiz- 46", "World Quiz- 47", "World Quiz- 48", "World Quiz- 49", "World Quiz- 50", "World Quiz- 51", "World Quiz- 52", "World Quiz- 53", "World Quiz- 54", "World Quiz- 55", "World Quiz- 56", "World Quiz- 57", "World Quiz- 58", "World Quiz- 59", "World Quiz- 60", "World Quiz- 61", "World Quiz- 62", "World Quiz- 63", "World Quiz- 64", "World Quiz- 65", "World Quiz- 66", "World Quiz- 67", "World Quiz- 68", "World Quiz- 69", "World Quiz- 70", "World Quiz- 71", "World Quiz- 72", "World Quiz- 73", "World Quiz- 74", "World Quiz- 75", "World Quiz- 76", "World Quiz- 77", "World Quiz- 78", "World Quiz- 79", "World Quiz- 80", "World Quiz- 81", "World Quiz- 82", "World Quiz- 83", "World Quiz- 84", "World Quiz- 85", "World Quiz- 86", "World Quiz- 87", "World Quiz- 88", "World Quiz- 89", "World Quiz- 90", "World Quiz- 91", "World Quiz- 92", "World Quiz- 93", "World Quiz- 94", "World Quiz- 95", "World Quiz- 96", "World Quiz- 97", "World Quiz- 98", "World Quiz- 99", "World Quiz- 100"};
    ListView listView;
    // AdView adView;
    // InterstitialAd interstitialAd;
    AdView adView;
    InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviewactivity);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("World Quiz");
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

        // For auto play video ads, it's recommended to load the ad
        // at least 30 seconds before it is shown
        interstitialAd.loadAd();

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
                Intent in = new Intent(getApplicationContext(), QuizActWorld.class);
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
       /* if (interstitialAd !=null)
        {
            interstitialAd.destroy();
        }*/
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
