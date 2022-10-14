package com.linda.filmkeluarga;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.ListViewHolder> {

    //Constructor
    private List<Film> listFilm;
    private OnFilmClickListener listener;

    public interface OnFilmClickListener {
        public void onClick(View view, int position);
    }
    public void setListener(OnFilmClickListener listener){
        this.listener = listener;
    }

    public FilmAdapter(List<Film> listFilm){
        this.listFilm = listFilm;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_film, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Film film = listFilm.get(position);
        Picasso.get()
                .load(film.getGambar())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.imgFilm);
        holder.judul.setText(film.getJudul());
        holder.sutradara.setText(film.getSutradara());
    }

    @Override
    public int getItemCount(){
        return listFilm.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFilm;
        TextView judul, sutradara;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFilm = itemView.findViewById(R.id.logo);
            judul = itemView.findViewById(R.id.tvJudulFilm);
            sutradara = itemView.findViewById(R.id.tvSutradara);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(view, getAdapterPosition());
                }
            });
        }
    }
}
