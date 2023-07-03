package com.example.mobil_proje_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RegionalSweetsPage extends AppCompatActivity {

    private ListView mListView;
    private ArrayAdapter<String> adapter;
    private String[] dessertList = {
            "Pişmaniye",
            "Höşmerim"
    };
    private String[] dessertDetailList = {
            "Kocaeli denilince ilk akla gelen şüphesiz ki meşhur lezzeti ile Pişmaniyedir. Türkiye’nin her yerine yayılmış olan bu harika lezzet ile şehirlerarası yolculuklarda, dinlenme tesislerinde veya İzmit’e geldiğinizde mutlaka karşılaşırsınız. 1600’lü yıllarda İzmit ve çevresine yerleşen Ermeni ustaların elinden çıkan bu lezzetin kesinlikle tadına bakılması gerekir. Yollarda karşınıza çıkan tezgâhlardan kendinize ve sevdiklerinize birer paket alabilir ve pişmaniyenin tadını çıkarabilirsiniz.",
            "Kocaeli’nin Kandıra ilçesinde Höşmeni olarak da bilinen Höşmerim tatlısı, özellikle Hıdrellez’de yapılmaktadır. Eski zamanlardan günümüze kadar gelmiş olan bu enfes lezzet, Kocaeli Mutfağı’nın en meşhur tatlıları arasındadır. Muhallebi kıvamında ve sapsarı bir renge sahip olan Höşmerim, taze peynir ve tereyağı ile yapılmaktadır. Yörenin özel günlerinde bu enfes lezzete ulaşabilmeniz mümkündür. Ayrıca yöresel tatlılar sunan tatlıcı dükkânlarından da kendinize ve sevdiklerinize birer paket satın alabilirsiniz."
    };
    private int[] dessertImageList = {
            R.drawable.pismaniye,
            R.drawable.hosmerim
    };

    public static Bitmap selectedDessertImage;

    private Intent regionalDessertPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regional_sweets_page);

        mListView = (ListView)findViewById(R.id.regionalSwwets_activity_listview);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dessertList);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                regionalDessertPage = new Intent(RegionalSweetsPage.this, RegionalDessertPage.class);
                regionalDessertPage.putExtra("dessertName", dessertList[position]);
                regionalDessertPage.putExtra("dessertDetail", dessertDetailList[position]);

                selectedDessertImage = BitmapFactory.decodeResource(getApplicationContext().getResources(), dessertImageList[position]);

                startActivity(regionalDessertPage);
            }
        });
    }
}