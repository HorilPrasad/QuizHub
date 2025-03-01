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

import com.horil.quizhub.QuizViewHandlers.QuizActIndia;
import com.horil.quizhub.R;

public class SubCategoryOneQuiz extends AppCompatActivity {

    public static final String Click_Index ="com.quizguru.clickindex";
    int[] icon = {R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo, R.drawable.yourlogo};
    String[] itemname = {"Quiz- 1", "Quiz- 2", "Quiz- 3", "Quiz- 4", "Quiz- 5", "Quiz- 6", "Quiz- 7", "Quiz- 8", "Quiz- 9", "Quiz- 10", "Quiz- 11", "Quiz- 12", "Quiz- 13", "Quiz- 14", "Quiz- 15", "Quiz- 16", "Quiz- 17", "Quiz- 18", "Quiz- 19", "Quiz- 20", "Quiz- 21", "Quiz- 22", "Quiz- 23", "Quiz- 24", "Quiz- 25", "Quiz- 26", "Quiz- 27", "Quiz- 28", "Quiz- 29", "Quiz- 30", "Quiz- 31", "Quiz- 32", "Quiz- 33", "Quiz- 34", "Quiz- 35", "Quiz- 36", "Quiz- 37", "Quiz- 38", "Quiz- 39", "Quiz- 40", "Quiz- 41", "Quiz- 42", "Quiz- 43", "Quiz- 44", "Quiz- 45", "Quiz- 46", "Quiz- 47", "Quiz- 48", "Quiz- 49", "Quiz- 50", "Quiz- 51", "Quiz- 52", "Quiz- 53", "Quiz- 54", "Quiz- 55", "Quiz- 56", "Quiz- 57", "Quiz- 58", "Quiz- 59", "Quiz- 60", "Quiz- 61", "Quiz- 62", "Quiz- 63", "Quiz- 64", "Quiz- 65", "Quiz- 66", "Quiz- 67", "Quiz- 68", "Quiz- 69", "Quiz- 70", "Quiz- 71", "Quiz- 72", "Quiz- 73", "Quiz- 74", "Quiz- 75", "Quiz- 76", "Quiz- 77", "Quiz- 78", "Quiz- 79", "Quiz- 80", "Quiz- 81", "Quiz- 82", "Quiz- 83", "Quiz- 84", "Quiz- 85", "Quiz- 86", "Quiz- 87", "Quiz- 88", "Quiz- 89", "Quiz- 90", "Quiz- 91", "Quiz- 92", "Quiz- 93", "Quiz- 94", "Quiz- 95", "Quiz- 96", "Quiz- 97", "Quiz- 98", "Quiz- 99", "Quiz- 100", "Quiz- 101", "Quiz- 102", "Quiz- 103", "Quiz- 104", "Quiz- 105"};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviewactivity);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("India Quiz");
        actionBar.setDisplayHomeAsUpEnabled(true);


        listView = (ListView) findViewById(R.id.listview);

        CustomAdaptor  customAdaptor= new CustomAdaptor();
        listView.setAdapter(customAdaptor);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent in = new Intent(getApplicationContext(), QuizActIndia.class);
                in.putExtra(Click_Index, position);
                startActivity(in);

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
