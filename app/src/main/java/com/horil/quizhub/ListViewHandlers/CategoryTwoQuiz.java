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
import com.horil.quizhub.QuizViewHandlers.QuizActGK;
import com.horil.quizhub.R;

public class CategoryTwoQuiz extends AppCompatActivity {
    public static final String Click_Index ="com.quizguru.clickindex";
    public static int[] icon = new int[]{R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo};
    public static String[] itemname = new String[]{"GK Quiz - 1", "GK Quiz - 2", "GK Quiz - 3", "GK Quiz - 4", "GK Quiz - 5", "GK Quiz - 6", "GK Quiz - 7", "GK Quiz - 8", "GK Quiz - 9", "GK Quiz - 10", "GK Quiz - 11", "GK Quiz - 12", "GK Quiz - 13", "GK Quiz - 14", "GK Quiz - 15", "GK Quiz - 16", "GK Quiz - 17", "GK Quiz - 18", "GK Quiz - 19", "GK Quiz - 20", "GK Quiz - 21", "GK Quiz - 22", "GK Quiz - 23", "GK Quiz - 24", "GK Quiz - 25", "GK Quiz - 26", "GK Quiz - 27", "GK Quiz - 28", "GK Quiz - 29", "GK Quiz - 30", "GK Quiz - 31", "GK Quiz - 32", "GK Quiz - 33", "GK Quiz - 34", "GK Quiz - 35", "GK Quiz - 36", "GK Quiz - 37", "GK Quiz - 38", "GK Quiz - 39", "GK Quiz - 40", "GK Quiz - 41", "GK Quiz - 42", "GK Quiz - 43", "GK Quiz - 44", "GK Quiz - 45", "GK Quiz - 46", "GK Quiz - 47", "GK Quiz - 48", "GK Quiz - 49", "GK Quiz - 50", "GK Quiz - 51", "GK Quiz - 52", "GK Quiz - 53", "GK Quiz - 54", "GK Quiz - 55", "GK Quiz - 56", "GK Quiz - 57", "GK Quiz - 58", "GK Quiz - 59", "GK Quiz - 60", "GK Quiz - 61", "GK Quiz - 62", "GK Quiz - 63", "GK Quiz - 64", "GK Quiz - 65", "GK Quiz - 66", "GK Quiz - 67", "GK Quiz - 68", "GK Quiz - 69", "GK Quiz - 70", "GK Quiz - 71", "GK Quiz - 72", "GK Quiz - 73", "GK Quiz - 74", "GK Quiz - 75", "GK Quiz - 76", "GK Quiz - 77", "GK Quiz - 78", "GK Quiz - 79", "GK Quiz - 80", "GK Quiz - 81", "GK Quiz - 82", "GK Quiz - 83", "GK Quiz - 84", "GK Quiz - 85", "GK Quiz - 86", "GK Quiz - 87", "GK Quiz - 88", "GK Quiz - 89", "GK Quiz - 90", "GK Quiz - 91", "GK Quiz - 92", "GK Quiz - 93", "GK Quiz - 94", "GK Quiz - 95", "GK Quiz - 96", "GK Quiz - 97", "GK Quiz - 98", "GK Quiz - 99", "GK Quiz - 100", "GK Quiz - 101", "GK Quiz - 102", "GK Quiz - 103", "GK Quiz - 104", "GK Quiz - 105", "GK Quiz - 106", "GK Quiz - 107", "GK Quiz - 108", "GK Quiz - 109", "GK Quiz - 110", "GK Quiz - 111", "GK Quiz - 112", "GK Quiz - 113", "GK Quiz - 114", "GK Quiz - 115", "GK Quiz - 116", "GK Quiz - 117", "GK Quiz - 118", "GK Quiz - 119", "GK Quiz - 120", "GK Quiz - 121", "GK Quiz - 122", "GK Quiz - 123", "GK Quiz - 124", "GK Quiz - 125", "GK Quiz - 126", "GK Quiz - 127", "GK Quiz - 128", "GK Quiz - 129", "GK Quiz - 130", "GK Quiz - 131", "GK Quiz - 132", "GK Quiz - 133", "GK Quiz - 134", "GK Quiz - 135", "GK Quiz - 136", "GK Quiz - 137", "GK Quiz - 138", "GK Quiz - 139", "GK Quiz - 140", "GK Quiz - 141", "GK Quiz - 142", "GK Quiz - 143", "GK Quiz - 144", "GK Quiz - 145", "GK Quiz - 146", "GK Quiz - 147", "GK Quiz - 148", "GK Quiz - 149", "GK Quiz - 150", "GK Quiz - 151", "GK Quiz - 152", "GK Quiz - 153", "GK Quiz - 154", "GK Quiz - 155", "GK Quiz - 156", "GK Quiz - 157", "GK Quiz - 158", "GK Quiz - 159", "GK Quiz - 160", "GK Quiz - 161", "GK Quiz - 162", "GK Quiz - 163", "GK Quiz - 164", "GK Quiz - 165", "GK Quiz - 166", "GK Quiz - 167", "GK Quiz - 168", "GK Quiz - 169", "GK Quiz - 170", "GK Quiz - 171", "GK Quiz - 172", "GK Quiz - 173", "GK Quiz - 174", "GK Quiz - 175", "GK Quiz - 176", "GK Quiz - 177", "GK Quiz - 178", "GK Quiz - 179", "GK Quiz - 180", "GK Quiz - 181", "GK Quiz - 182", "GK Quiz - 183", "GK Quiz - 184", "GK Quiz - 185", "GK Quiz - 186", "GK Quiz - 187", "GK Quiz - 188", "GK Quiz - 189", "GK Quiz - 190", "GK Quiz - 191", "GK Quiz - 192", "GK Quiz - 193", "GK Quiz - 194", "GK Quiz - 195", "GK Quiz - 196", "GK Quiz - 197", "GK Quiz - 198", "GK Quiz - 199", "GK Quiz - 200", "GK Quiz - 201", "GK Quiz - 202", "GK Quiz - 203", "GK Quiz - 204", "GK Quiz - 205", "GK Quiz - 206", "GK Quiz - 207", "GK Quiz - 208", "GK Quiz - 209", "GK Quiz - 210", "GK Quiz - 211", "GK Quiz - 212", "GK Quiz - 213", "GK Quiz - 214", "GK Quiz - 215", "GK Quiz - 216", "GK Quiz - 217", "GK Quiz - 218", "GK Quiz - 219", "GK Quiz - 220", "GK Quiz - 221", "GK Quiz - 222", "GK Quiz - 223", "GK Quiz - 224", "GK Quiz - 225", "GK Quiz - 226", "GK Quiz - 227", "GK Quiz - 228", "GK Quiz - 229", "GK Quiz - 230", "GK Quiz - 231", "GK Quiz - 232", "GK Quiz - 233", "GK Quiz - 234", "GK Quiz - 235", "GK Quiz - 236", "GK Quiz - 237", "GK Quiz - 238", "GK Quiz - 239", "GK Quiz - 240", "GK Quiz - 241", "GK Quiz - 242", "GK Quiz - 243", "GK Quiz - 244", "GK Quiz - 245", "GK Quiz - 246", "GK Quiz - 247", "GK Quiz - 248", "GK Quiz - 249", "GK Quiz - 250", "GK Quiz - 251", "GK Quiz - 252", "GK Quiz - 253", "GK Quiz - 254", "GK Quiz - 255", "GK Quiz - 256", "GK Quiz - 257", "GK Quiz - 258", "GK Quiz - 259", "GK Quiz - 260", "GK Quiz - 261", "GK Quiz - 262", "GK Quiz - 263", "GK Quiz - 264", "GK Quiz - 265", "GK Quiz - 266", "GK Quiz - 267", "GK Quiz - 268", "GK Quiz - 269", "GK Quiz - 270", "GK Quiz - 271", "GK Quiz - 272", "GK Quiz - 273", "GK Quiz - 274", "GK Quiz - 275", "GK Quiz - 276", "GK Quiz - 277", "GK Quiz - 278", "GK Quiz - 279", "GK Quiz - 280", "GK Quiz - 281", "GK Quiz - 282", "GK Quiz - 283", "GK Quiz - 284", "GK Quiz - 285", "GK Quiz - 286", "GK Quiz - 287", "GK Quiz - 288", "GK Quiz - 289", "GK Quiz - 290", "GK Quiz - 291", "GK Quiz - 292", "GK Quiz - 293", "GK Quiz - 294", "GK Quiz - 295", "GK Quiz - 296", "GK Quiz - 297", "GK Quiz - 298", "GK Quiz - 299", "GK Quiz - 300", "GK Quiz - 301", "GK Quiz - 302", "GK Quiz - 303", "GK Quiz - 304", "GK Quiz - 305", "GK Quiz - 306", "GK Quiz - 307", "GK Quiz - 308", "GK Quiz - 309", "GK Quiz - 310", "GK Quiz - 311", "GK Quiz - 312", "GK Quiz - 313", "GK Quiz - 314", "GK Quiz - 315", "GK Quiz - 316", "GK Quiz - 317", "GK Quiz - 318", "GK Quiz - 319", "GK Quiz - 320", "GK Quiz - 321", "GK Quiz - 322", "GK Quiz - 323", "GK Quiz - 324", "GK Quiz - 325", "GK Quiz - 326", "GK Quiz - 327", "GK Quiz - 328", "GK Quiz - 329", "GK Quiz - 330", "GK Quiz - 331", "GK Quiz - 332", "GK Quiz - 333", "GK Quiz - 334", "GK Quiz - 335", "GK Quiz - 336", "GK Quiz - 337", "GK Quiz - 338", "GK Quiz - 339", "GK Quiz - 340", "GK Quiz - 341", "GK Quiz - 342", "GK Quiz - 343", "GK Quiz - 344", "GK Quiz - 345", "GK Quiz - 346", "GK Quiz - 347", "GK Quiz - 348", "GK Quiz - 349", "GK Quiz - 350", "GK Quiz - 351", "GK Quiz - 352", "GK Quiz - 353", "GK Quiz - 354", "GK Quiz - 355", "GK Quiz - 356", "GK Quiz - 357", "GK Quiz - 358", "GK Quiz - 359", "GK Quiz - 360", "GK Quiz - 361", "GK Quiz - 362", "GK Quiz - 363", "GK Quiz - 364", "GK Quiz - 365", "GK Quiz - 366", "GK Quiz - 367", "GK Quiz - 368", "GK Quiz - 369", "GK Quiz - 370", "GK Quiz - 371", "GK Quiz - 372", "GK Quiz - 373", "GK Quiz - 374", "GK Quiz - 375", "GK Quiz - 376", "GK Quiz - 377", "GK Quiz - 378", "GK Quiz - 379", "GK Quiz - 380", "GK Quiz - 381", "GK Quiz - 382", "GK Quiz - 383", "GK Quiz - 384", "GK Quiz - 385", "GK Quiz - 386", "GK Quiz - 387", "GK Quiz - 388", "GK Quiz - 389", "GK Quiz - 390", "GK Quiz - 391", "GK Quiz - 392", "GK Quiz - 393", "GK Quiz - 394", "GK Quiz - 395", "GK Quiz - 396", "GK Quiz - 397", "GK Quiz - 398", "GK Quiz - 399", "GK Quiz - 400"};

    ListView listView;
    // AdView adView;
    //  InterstitialAd interstitialAd;
    AdView adView;
    InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviewactivity);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("General Knowledge Quiz");
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
                Intent in = new Intent(getApplicationContext(), QuizActGK.class);
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
      /*  if (interstitialAd !=null)
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
