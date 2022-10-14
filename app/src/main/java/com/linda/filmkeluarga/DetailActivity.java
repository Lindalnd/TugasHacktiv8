package com.linda.filmkeluarga;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView dtlLogo = (ImageView) findViewById(R.id.logoDetail);
        TextView dtlJudul = (TextView) findViewById(R.id.judulDetail);
        TextView dtlSutradara = (TextView) findViewById(R.id.sutradaraDtl);
        TextView dtlFilm = (TextView) findViewById(R.id.detailFilm);

////        Bundle bundle = getIntent().getExtras();
        Intent intent = getIntent();

        Film film = intent.getParcelableExtra("Film");
        String Judul = film.getJudul();
        dtlJudul.setText(Judul);

        String Sutradara = film.getSutradara();
        dtlSutradara.setText(Sutradara);

        String detail = film.getDetail();
        dtlFilm.setText(detail);

//        String gambar = film.getGambar();
//        dtlLogo.setImageResource(Integer.parseInt(gambar));
////
//
        Picasso.Builder builder = new Picasso.Builder(this);
        builder.build().load(film.getGambar())
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .into(dtlLogo);
    }
}