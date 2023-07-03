package com.example.mobil_proje_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RegionalDessertPage extends AppCompatActivity {

    private TextView dessertName, dessertDetail;
    private ImageView dessertImage;
    private Intent get_intent;
    private String sDetail, sName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regional_dessert_page);

        dessertName = (TextView)findViewById(R.id.regionalDessert_activity_textViewDessertName);
        dessertDetail = (TextView)findViewById(R.id.regionalDessert_activity_textViewDessertDescription);
        dessertImage = (ImageView)findViewById(R.id.regionalDessert_activity_imageViewDessertImage);

        get_intent = getIntent();
        sName = get_intent.getStringExtra("dessertName");
        sDetail = get_intent.getStringExtra("dessertDetail");

        dessertName.setText(sName);
        dessertDetail.setText(sDetail);
        dessertImage.setImageBitmap(RegionalSweetsPage.selectedDessertImage);
    }
}