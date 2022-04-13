package com.horil.quizhub;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.navigation.NavigationView;
import com.horil.quizhub.ListViewHandlers.CategoryThreeQuiz;
import com.horil.quizhub.ListViewHandlers.CategoryTwoQuiz;
import com.horil.quizhub.ListViewHandlers.SubCategoryOneQuiz;
import com.horil.quizhub.ListViewHandlers.SubCategoryTwoQuiz;

import hotchemi.android.rate.AppRate;

public class MainActivity extends AppCompatActivity
implements NavigationView.OnNavigationItemSelectedListener {

    AdView adView;
    InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        adView = (AdView) findViewById(R.id.banner_ad);
        MobileAds.initialize(this, "" + getResources().getString(R.string.admob_app_id));
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Hotchemi Rating
        AppRate.with(this)
                .setInstallDays(2) // default 10, 0 means install day.
                .setLaunchTimes(5) // default 10
                .setRemindInterval(2) // default 1
                .monitor();
        AppRate.showRateDialogIfMeetsConditions(this);
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_exit) {
            System.exit(0);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

       /* if (id == R.id.nav_about_us) {
            startActivity(new Intent(this, AboutUs.class));

        } else*/ if (id == R.id.nav_rate) {

            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+getPackageName())));

        } else if (id == R.id.nav_share) {

            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("text/plain");
            share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

            // Add data to the intent, the receiving app will decide
            // what to do with it.
            share.putExtra(Intent.EXTRA_SUBJECT, "Quiz Hub- App for CurrentAffairs and GK Quiz");
            share.putExtra(Intent.EXTRA_TEXT, ""+ getString(R.string.link) + "\n"+ Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName()));
            startActivity(Intent.createChooser(share, "Share app using"));
        }
            /*else if (id == R.id.nav_bug) {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto", "quizhubgk@gmail.com", null));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Bug in Quiz Hub App");
            startActivity(Intent.createChooser(emailIntent, null));

        } else if (id == R.id.nav_feedback) {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto", "quizhubgk@gmail.com", null));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback regarding Quiz Hub App");
            startActivity(Intent.createChooser(emailIntent, null));
        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    public void gkTest(View view) {
        startActivity(new Intent(getApplicationContext(), CategoryTwoQuiz.class));
    }

    public void english(View view) {
        startActivity(new Intent(getApplicationContext(), CategoryThreeQuiz.class));
    }

    public void world(View view){
        startActivity(new Intent(getApplicationContext(), SubCategoryTwoQuiz.class));
    }

    public void india(View view){
        startActivity(new Intent(getApplicationContext(), SubCategoryOneQuiz.class));
    }
}