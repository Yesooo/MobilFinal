package com.example.mobil_proje_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaceHistoryPage extends AppCompatActivity {

    private TextView placeDescription;
    private ImageView placeImage;
    private Bitmap picture;
    private String description = "Kocaeli, Türkiye'nin bir ili ve en kalabalık onuncu şehridir. Şehir, ülkenin en büyük sanayi ve ticaret kentlerinden biridir. Kocaeli; SEGE-2011 sıralamasına göre İstanbul, Ankara ve İzmir'den sonra en gelişmiş şehirdir. 2022 itibarıyla 2.033.441 kişilik nüfusa sahiptir.[3] Adını 1320 yılında İzmit yöresini fetheden Akça Koca'dan almaktadır. İstanbul, Bursa, Sakarya, Yalova illeriyle komşudur.";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_history_page);

        placeDescription = (TextView)findViewById(R.id.placeHistory_activity_textViewPlaceDescription);
        placeDescription.setText(description);

        placeImage = (ImageView)findViewById(R.id.placeHistory_activity_imageViewPlaceImage);
        picture = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.kocaeli);
        placeImage.setImageBitmap(picture);
    }
}