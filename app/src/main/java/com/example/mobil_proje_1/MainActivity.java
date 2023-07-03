package com.example.mobil_proje_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private ArrayAdapter<String> adapter;
    private String[] mainMenuList = {
            "Koaceli Tarihçesi",
            "Kocaelinde Bulunan Tarihi Yerler",
            "Kocaeli Yöresel Yemekleri",
            "Kocaeli Yöresel Tatlıları"
    };

    private Intent historyPageIntent;
    private Intent historicalLocationsPageIntent;
    private Intent regionalDishesPageIntent;
    private Intent regionalSweetsPageIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView)findViewById(R.id.main_activity_listview);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mainMenuList);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    historyPageIntent = new Intent(MainActivity.this, PlaceHistoryPage.class);
                    startActivity(historyPageIntent);
                }
                else if (position == 1) {
                    historicalLocationsPageIntent = new Intent(MainActivity.this, HistoricalLocationsPage.class);
                    startActivity(historicalLocationsPageIntent);
                }
                else if (position == 2) {
                    regionalDishesPageIntent = new Intent(MainActivity.this, RegionalDishesPage.class);
                    startActivity(regionalDishesPageIntent);
                }
                else if (position == 3) {
                    regionalSweetsPageIntent = new Intent(MainActivity.this, RegionalSweetsPage.class);
                    startActivity(regionalSweetsPageIntent);
                }
            }
        });
    }
}