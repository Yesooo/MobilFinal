package com.example.mobil_proje_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class HistoricalPlacePage extends AppCompatActivity {
    private TextView placeName, placeDetail;
    private ImageView placeImage;
    private Intent get_intent;
    private String sDetail, sName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historical_place_page);

        placeName = (TextView)findViewById(R.id.historicalPlace_activity_textViewPlaceName);
        placeDetail = (TextView)findViewById(R.id.historicalPlace_activity_textViewPlaceDescription);
        placeImage = (ImageView)findViewById(R.id.historicalPlace_activity_imageViewPlaceImage);

        get_intent = getIntent();
        sName = get_intent.getStringExtra("locationName");
        sDetail = get_intent.getStringExtra("locationDetail");

        placeName.setText(sName);
        placeDetail.setText(sDetail);
        placeImage.setImageBitmap(HistoricalLocationsPage.selectedLocationImage);
    }
}