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

public class RegionalDishesPage extends AppCompatActivity {
    private ListView mListView;
    private ArrayAdapter<String> adapter;
    private String[] foodList = {
            "Hindi Dolması",
            "Cızlama",
            "Mancarlı Kandıra Pidesi",
            "Umaç Çorbası",
            "Ciğceli Kavurma",
    };
    private String[] foodDetailList = {
            "Hindi dolması, özellikle yılbaşı akşamlarının vazgeçilmez yemekleri arasındadır. Kocaeli’de hindi dolması daha çok özel günlerde yapılmaktadır. İç pilav ile hazırlanan bu yemeğin içerisinde ayıklanmış ve kavrulmuş kestane, kuş üzümü, hindi ciğeri gibi malzemeler bulunmaktadır. Bu harika lezzeti İzmit’te tadabilmeniz mümkündür.",
            "Cızlama, günün her saati yiyebileceğiniz lezzetlerin başında gelmektedir. Krep veya akıtmadan farklı olarak içerisine maya koyulmaktadır. Kocaeli’ne bağlı pek çok köyde sacda pişirilerek yapılmaktadır.",
            "Kocaeli’de yetişen bitkilerden biri mancardır. Sadece yemeklerde değil hamur işlerinde de kullanılan mancar bitkisi Kandıra ilçesinde pidesi ile öne çıkmaktadır. Eski zamanlardan beri yapılan pidenin tadı ıspanağa benzetilmektedir. Kırlarda yetişen mancarlar toplanarak, pide içi olarak hazırlanır. Önceden mayalanmış hamur açılarak içerisine iç malzemeler koyulur. Yanında ayran ile servis edilir.",
            "Kocaeli’nin oldukça meşhur yemeklerinden biri olan Umaç Çorbası, yağ, toz biber ve tuzdan oluşmaktadır. Özellikle soğuk kış günlerinde sıklıkla yapılmaktadır. Az malzeme ile yapıldığı için usta ellerden yenmesi gerekmektedir. Şehrin en önemli lezzetleri arasında öne çıkan Umaç Çorbası’nı yöresel tatların sunulduğu yemek yerleri ve restoranlarda tadabilmeniz mümkündür. Kış aylarında sevilerek tüketilen çorbayı mutlaka denemelisiniz.",
            "Ciğceli Kavurma, bulgur veya pirinç pilavı üstüne konulan kuşbaşı etle ve süt kaymağı ile yapılan bir yemek çeşididir. Ciğce denmesinin sebebi süt kaymağı ile alakalıdır. Yörede süt kaymağına Ciğce denmektedir. Kocaeli’nin yöresel yemekleri arasında ilk sıralarda olan Ciğceli Kavurma, yanında bol köpüklü ayran ile servis edilir. Yöresel lezzetlerin sunulduğu yemek yerlerinden biri olan ve şehrin merkezinde hizmet veren Meşhur Kavurmacı’da bu lezzeti tadabilmeniz mümkündür.",
    };
    private int[] foodImageList = {
            R.drawable.hindi_dolmasi,
            R.drawable.cizlama,
            R.drawable.mancarli_kandira_pidesi,
            R.drawable.umac_corbasi,
            R.drawable.cigceli_kavurma,
    };

    public static Bitmap selectedFoodImage;

    private Intent regionalFoodPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regional_dishes_page);

        mListView = (ListView)findViewById(R.id.regionalDishes_activity_listview);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, foodList);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                regionalFoodPage = new Intent(RegionalDishesPage.this, RegionalFoodPage.class);
                regionalFoodPage.putExtra("foodName", foodList[position]);
                regionalFoodPage.putExtra("foodDetail", foodDetailList[position]);

                selectedFoodImage = BitmapFactory.decodeResource(getApplicationContext().getResources(), foodImageList[position]);

                startActivity(regionalFoodPage);
            }
        });
    }
}