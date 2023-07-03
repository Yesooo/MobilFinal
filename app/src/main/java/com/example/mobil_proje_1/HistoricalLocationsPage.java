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

public class HistoricalLocationsPage extends AppCompatActivity {
    private ListView mListView;

    private ArrayAdapter<String> adapter;
    private String[] locationList = {
            "Hannibal Anıtı",
            "İzmit Saat Kulesi",
            "Selim Sırrı Paşa Konağı",
            "Kocaeli Arkeoloji ve Etnoğrafya Müzesi",
            "Kasr-ı Hümayun Saray Müzesi",
            "SEKA Kağıt Fabrikası"
    };

    private String[] locationDetailList = {
            "Hannibal Anıtı, dünyaca ünlü Kartacalı komutan Hannibal anısına Gebze’de TÜBİTAK arazisi içindeki Hannibal Tepe'ye 1981'de yapılmış anıttır. 900 metrekarelik alan kaplayan beş ayrı bölüm halindedir.[1] Beş ayrı dildeki beş ayrı mermer kitabede Hannibal’in yaşam öyküsü anlatılır. Hereke’den getirilen puding taşından yapılan anıt, 25 ton ağırlığındadır. Anıtın ortasına İstanbul Arkeoloji Müzeleri heykeltıraşı Nejat Özatay’ın yaptığı Hannibal portresi yerleştirilmiştir.",
            "İzmit Saat Kulesi ya da diğer adıyla Kocaeli Saat Kulesi, Kocaeli'nin merkezi İzmit'te yer alan bir saat kulesidir. Hem ilin hem de şehrin sembolleri arasındadır. 34. Osmanlı Padişahı II. Abdülhamid'in tahta çıkışının 25. yıl dönümünü anma amacıyla, İzmit Mutasarrıflığının girişimi sonrasında İzmit Belediyesi tarafından yapımına başlandı. Mimar Vedat (Tek) tarafından oluşturulan projenin uygulaması, Mihran Azaryan tarafından yapıldı. 1 Eylül 1900'de temeli atılan kulenin ertesi yıl aynı gün tamamlanması hedeflense de süreç gecikti ve Eylül 1902'de, tamamıyla tamamlanamayan kulenin açılışı gerçekleştirildi.",
            "Selim Sırrı Paşa Konağı, Türkiye'nin Kocaeli ilinin merkezi İzmit'te yer alan konaktır. İzmit Mutasarrıfı Selim Sırrı Paşa tarafından yaptırılan konağın inşası 1892'de tamamlandı.[1] Ahşap ve kâgir bir yapı olup iki kat ile çatı katından meydana gelir. Bahçe duvarlarında Antik Roma döneminden kalma arkeolojik eserler kullanılmıştır konağın iç kısmında kalemişi bezemeler yer alır.",
            "Kocaeli Arkeoloji Müzesi, Kocaeli'nin İzmit ilçesinde bulunan, arkeolojik eserlerin sergilendiği ulusal bir müzedir. İzmit'in tarihi tren garı binasının yanında yer almaktadır. Müze alanı 1873-1910 yılları arasında inşa edilen tarihi Gar Binası kompleksinden, tamir atölyesi, su deposu, lojman konutu ve iki tane tekel deposu birleştirilerek oluşturulan salondan ibarettir. Mimarı Alman asıllı Otto Ritter’dir. Yeni 2004 yılında başlayan restorasyon çalışmalarından sonra eski tren istasyonu 2007 başlarında açıldı. Sergi alanı 2 sikke vitrini, 18 arkeolojik eser vitrininden oluşmaktadır.",
            "Abdülaziz Av Köşkü ya da başka bir adıyla Kasr-ı Hümayun Saray Müzesi, İzmit şehrinde müze olarak kullanılan barok ve ampir üslupta bir yapıdır. İzmit Saat Kulesi'nin yanındadır. Son şeklini Abdülaziz devrinde alan yapı, Osmanlı Devleti'nde İstanbul dışında yapılan tek küçük saray olarak bilinir. Mimarı Garabet Amira Balyan'dır. Bina, Milli Mücadele yıllarında Atatürk'ün gerçekleştirdiği iki önemli toplantıya ev sahipliği yapmıştır. 1967'den beri müze olarak hizmet veren av köşkü, 17 Ağustos 1999 depreminde hasar gördü. 16 Ocak 2007 tarihinde \"Saray-Müze\" olarak yeniden ziyarete açıldı.",
            "SEKA (tam adı: Türkiye Selüloz ve Kağıt Fabrikaları A.Ş), Türkiye'de kâğıt sanayiinde yatırım ve planlamalar yapan kamu kuruluşudur. 1998 yılında özelleştirme kapsamına alınıp anonim şirkete dönüştürüldü. Kuruluş, 2005 yılında Sümer Holding ile birleştirilerek kapatıldı. SEKA, Cumhuriyet tarihinin ilk sanayi kuruluşudur. 1972 yılında Selüloz ve Kağıt Sanayicileri Birliği'nin kurulmasında, 1976 yılında Selüloz ve Kağıt Sanayicileri Derneği'nin rol almış, derneğin 1989 yılında vakfa dönüştürülmesinde ise ana neden olmuştur."
    };

    private int[] locationImageList = {
            R.drawable.hannibal_aniti,
            R.drawable.izmit_saat_kulesi,
            R.drawable.selim_sirri_pasa_konagi,
            R.drawable.kocaeli_arkeoloji_ve_etnografya_muzesi,
            R.drawable.kasri_humayun_saray_muzesi,
            R.drawable.seka_kagit_fabrikasi,
    };

    public static Bitmap selectedLocationImage;

    private Intent historicalPlacePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historical_locations_page);

        mListView = (ListView)findViewById(R.id.historicalLocations_activity_listview);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, locationList);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                historicalPlacePage = new Intent(HistoricalLocationsPage.this, HistoricalPlacePage.class);
                historicalPlacePage.putExtra("locationName", locationList[position]);
                historicalPlacePage.putExtra("locationDetail", locationDetailList[position]);

                selectedLocationImage = BitmapFactory.decodeResource(getApplicationContext().getResources(), locationImageList[position]);

                startActivity(historicalPlacePage);
            }
        });
    }
}