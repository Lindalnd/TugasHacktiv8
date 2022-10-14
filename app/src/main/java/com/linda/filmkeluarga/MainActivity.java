package com.linda.filmkeluarga;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    RecyclerView rvFilm;
    private ArrayList<Film> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Film> listFilm = new ArrayList<>();
        listFilm.add(new Film("KELUARGA CEMARA", "Yandy Laurens", "https://tse2.mm.bing.net/th?id=OIP.cjSrBhujFBNiXizeSKUVlQHaLH&pid=Api&P=0", "Satu-persatu musibah perlahan menimpa Abah, Emak, Euis, dan Ara. Kesulitan demi kesulitan dilalui oleh keluarga ini. Masalah mereka juga diwarnai dengan masa puber Euis.\n" +
                "        \nDalam film ini kamu akan menemukan upaya seorang ayah agar bisa memberikan segalanya bagi keluarga. Selain itu, kamu juga akan menyaksikan kehangatan di setiap potongan scene-nya"));

        listFilm.add(new Film("DUA GARIS BIRU", "Ghina S. Noer", "https://ecs7.tokopedia.net/blog-tokopedia-com/uploads/2021/06/Dua-Garis-Biru.jpg", "Terjebak dalam kehamilan yang tidak direncanakan membuat keluarga Dara dan Bima terguncang. Permasalahan ini juga diwarnai dengan perbedaan kelas dan cara pandang dari kedua keluarga.\n" +
                "        \nKamu akan menemukan banyak potongan scene yang mengaduk perasaan. Lalu, bagaimana jalan keluar dari permasalahan dua remaja ini?"));

        listFilm.add(new Film("NANTI KITA CERITA TENTANG HARI INI", "Angga Dwimas Sasongko", "https://tse3.mm.bing.net/th?id=OIP.RVsJEwM_vO95wfywSNDvhAHaEK&pid=Api&P=0", "Sebuah rahasia besar dalam keluarga Angkasa perlahan membuat semua anggota terluka. Dalam film ini, kamu akan disuguhkan konflik keluarga yang sangat relatable.\n" +
                "        \nSudut pandang sebagai anak pertama yang penuh beban tanggung jawab, anak tengah yang merasa diabaikan, dan anak bungsu yang penuh penjagaan dikupas di film ini."));

        listFilm.add(new Film("SUSAH SINYAL", "Ernest Prakasa", "https://tse2.mm.bing.net/th?id=OIP.Yqq2Th6ndxLlxYn0ccfXagHaLH&pid=Api&P=0", "Kehilangan seseorang yang dicintai dan menghadapi duka bukanlah hal mudah bagi setiap orang. Hal ini semakin berat bagi Ellen karena memiliki hubungan yang renggang dengan putrinya.\n" +
                "        \nAkhirnya mereka datang ke pulau Sumba dan menikmati waktu untuk berlibur tanpa jaringan internet. Akankah hubungan Ellen dan putrinya membaik?"));

        listFilm.add(new Film("CEK TOKO SEBELAH", "Ernest Prakasa", "https://i.pinimg.com/736x/8e/88/26/8e8826cb94c3e4b11fcaf55f7d7b525c.jpg", "Drama komedi buatan Ernest Prakasa ini memperlihatkan konflik keluarga yang kompleks. Kesedihan ditinggalkan istri tercinta sulit hilang dari Koh Afuk. Terlebih, toko yang dibangun bersama istrinya dari nol terancam tidak memiliki penerus.\n" +
                "        \nKisah Koh Afuk memilih antara anak pertama yang kurang dipercayai dan anak kedua yang memiliki karir cemerlang bergulir di antara lelucon-lelucon yang mengocok perut."));

        showRecylerList();
        list.addAll(listFilm);
    }

    private void showRecylerList(){
        rvFilm = findViewById(R.id.rvlistFilm);
        rvFilm.setHasFixedSize(true);
        rvFilm.setLayoutManager(new LinearLayoutManager(this));
        FilmAdapter filmAdapter = new FilmAdapter(list);
        rvFilm.setAdapter(filmAdapter);

        filmAdapter.setListener(new FilmAdapter.OnFilmClickListener() {
            @Override
            public void onClick(View view, int position) {
                Film filmSelected = list.get(position);
                Intent detail = new Intent(MainActivity.this,DetailActivity.class);
                detail.putExtra("Film" , filmSelected);
                startActivity(detail);
            }
        });
    }


}