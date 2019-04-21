package com.example.recyclerviewfood;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mDesc = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mImageDet = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate:started.");
        initImageBitmaps();
    }

    private void initImageBitmaps() {
        mImageUrls.add("https://photos.smugmug.com/Indonesia-2016/i-Q4M8Pkt/0/X3/ayam-taliwang-jakarta-1-X3.jpg");
        mNames.add("Ayam Taliwang");
        mDesc.add("Nusa Tenggara Barat");
        mImageDet.add("Ayam Taliwang dibakar dengan bumbu cabai merah kering, bawang merah, bawang putih, tomat, terasi goreng, kencur, gula merah, dan garam. ");

        mImageUrls.add("https://photos.smugmug.com/Indonesia-2016/i-KzgFNCQ/0/X3/babi-guling-1-X3.jpg");
        mNames.add("Babi Guling");
        mDesc.add("Bali");
        mImageDet.add("Babi guling (di Bali disebut be guling) adalah sejenis makanan yang terbuat dari anak babi betina atau jantan yang perutnya diisikan dengan bumbu dan sayuran seperti daun ketela pohon dan lalu dipanggang sambil diputar-putar (diguling-gulingkan) sampai matang dengan ditandai dengan perubahan warna kulit menjadi kecoklatan dan renyah.");

        mImageUrls.add("https://photos.smugmug.com/Indonesia-2016/i-R43t2ZW/0/X3/indonesian-food-21-X3.jpg");
        mNames.add("Coto Makassar");
        mDesc.add("Sulawesi Selatan");
        mImageDet.add("Coto makassar terbuat dari jeroan (isi perut) sapi yang direbus dalam waktu yang lama. Rebusan jeroan bercampur daging sapi ini kemudian diiris-iris lalu dibumbui dengan bumbu yang diracik secara khusus. ");

        mImageUrls.add("https://photos.smugmug.com/Indonesia-2016/i-bFTZGJX/0/X3/gado-gado-1-X3.jpg");
        mNames.add("Gado-gado");
        mDesc.add("DKI Jakarta");
        mImageDet.add("Gado-gado adalah salah satu makanan yang berasal dari Indonesia yang berupa sayur-sayuran yang direbus dan dicampur jadi satu, dengan bumbu kacang atau saus dari kacang tanah dan yang dihaluskan disertai irisan telur dan pada umumnya banyak yang menambahkan kentang rebus yang sudah dihaluskan untuk saus gado gado kentang rebus dimasak bersamaan dengan bumbu kacang kemudian di atasnya ditaburi bawang goreng.");

        mImageUrls.add("https://photos.smugmug.com/Indonesia-2016/i-P6JDvG3/0/X3/indonesian-food-64-X3.jpg");
        mNames.add("Gudeg");
        mDesc.add("DI Yogyakarta");
        mImageDet.add("Gudeg adalah makanan khas Yogyakarta dan Jawa Tengah yang terbuat dari nangka muda yang dimasak dengan santan. Gudeg dimakan dengan nasi dan disajikan dengan kuah santan kental (areh), ayam kampung, telur, tahu dan sambal goreng krecek.");

        mImageUrls.add("https://photos.smugmug.com/Indonesia-2016/i-PLsn4BT/0/X3/indonesian-food-108-X3.jpg");
        mNames.add("Kerak Telor");
        mDesc.add("DKI Jakarta");
        mImageDet.add("Kerak telor adalah makanan asli daerah Jakarta (Betawi), dengan bahan-bahan beras ketan putih, telur ayam, ebi (udang kering yang diasinkan) yang disangrai kering ditambah bawang merah goreng, lalu diberi bumbu yang dihaluskan berupa kelapa sangrai, cabai merah, kencur, jahe, merica butiran, garam dan gula pasir.");

        mImageUrls.add("https://photos.smugmug.com/Indonesia-2016/i-XFXggdC/0/X3/nasi-padang-jakarta-5-X3.jpg");
        mNames.add("Nasi Padang");
        mDesc.add("Sumatera Barat");
        mImageDet.add("Nasi Padang adalah nasi putih yang disajikan dengan berbagai macam lauk pauk khas Indonesia");

        mImageUrls.add("https://photos.smugmug.com/Indonesia-2016/i-xHpLHVr/0/X3/indonesian-food-72-X3.jpg");
        mNames.add("Pempek");
        mDesc.add("Sumatera Selatan");
        mImageDet.add("Pempek atau empek-empek adalah makanan khas Palembang yang terbuat dari daging ikan yang digiling lembut dan tepung kanji, serta beberapa komposisi lain seperti telur, bawang putih yang dihaluskan, penyedap rasa dan garam.");

        mImageUrls.add("https://photos.smugmug.com/Indonesia-2016/i-GgkW7vF/0/X3/indonesian-food-28-X3.jpg");
        mNames.add("Rendang");
        mDesc.add("Sumatera Barat");
        mImageDet.add("Rendang adalah masakan daging bercita rasa pedas yang menggunakan campuran dari berbagai bumbu dan rempah-rempah. ");

        mImageUrls.add("https://photos.smugmug.com/Indonesia-2016/i-MmprL3V/0/X3/sate-padang-1-X3.jpg");
        mNames.add("Sate Padang");
        mDesc.add("Sumatera Barat");
        mImageDet.add("Sate Padang memakai bahan daging sapi, lidah, atau jerohan dengan bumbu kuah kacang kental (mirip bubur) ditambah cabai yang banyak sehingga rasanya pedas.");

        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FoodRecyclerViewAdapter adapter = new FoodRecyclerViewAdapter(this, mNames, mImageUrls, mDesc, mImageDet);
        recyclerView.setAdapter(adapter);
    }

    private void showRecyleList() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FoodListActivity adapter = new FoodListActivity(this, mNames, mImageUrls, mDesc, mImageDet);
        recyclerView.setAdapter(adapter);

    }

    private void showRecyclerGrid() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        FoodGridActivity adapter = new FoodGridActivity(this, mImageUrls,mNames, mImageDet);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_list:
                setActionBarTitle("Makanan Indonesia (Mode List)");
                showRecyleList();
                break;
            case R.id.action_grid:
                setActionBarTitle("Makanan Indonesia (Mode Grid)");
                showRecyclerGrid();
                break;
            case R.id.action_cardview:
                setActionBarTitle("Makanan Indonesia (Mode Card View)");
                initRecyclerView();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void setActionBarTitle(String title) {
        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
    }
}