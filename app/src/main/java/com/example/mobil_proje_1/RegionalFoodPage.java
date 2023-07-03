package com.example.mobil_proje_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RegionalFoodPage extends AppCompatActivity {

    private TextView foodName, foodDetail;
    private ImageView foodImage;
    private Intent get_intent;
    private String sDetail, sName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regional_food_page);

        foodName = (TextView)findViewById(R.id.regionalFood_activity_textViewFoodName);
        foodDetail = (TextView)findViewById(R.id.regionalFood_activity_textViewFoodDescription);
        foodImage = (ImageView)findViewById(R.id.regionalFood_activity_imageViewFoodImage);

        get_intent = getIntent();
        sName = get_intent.getStringExtra("foodName");
        sDetail = get_intent.getStringExtra("foodDetail");

        foodName.setText(sName);
        foodDetail.setText(sDetail);
        foodImage.setImageBitmap(RegionalDishesPage.selectedFoodImage);
    }
}