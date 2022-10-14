package com.linda.filmkeluarga;

import android.os.Parcel;
import android.os.Parcelable;

public class Film implements Parcelable {
    private String judul;
    private String sutradara;
    private String gambar;
    private String detail;

    public Film(String judul, String sutradara, String gambar, String detail) {
        this.judul = judul;
        this.sutradara = sutradara;
        this.gambar = gambar;
        this.detail = detail;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getSutradara() {
        return sutradara;
    }

    public void setSutradara(String sutradara) {
        this.sutradara = sutradara;
    }

    public String getGambar() {
        return gambar;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judul);
        dest.writeString(this.sutradara);
        dest.writeString(this.gambar);
        dest.writeString(this.detail);
    }

    public void readFromParcel(Parcel source) {
        this.judul = source.readString();
        this.sutradara = source.readString();
        this.gambar = source.readString();
        this.detail = source.readString();
    }

    protected Film(Parcel in) {
        this.judul = in.readString();
        this.sutradara = in.readString();
        this.gambar = in.readString();
        this.detail = in.readString();
    }

    public static final Parcelable.Creator<Film> CREATOR = new Parcelable.Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel source) {
            return new Film(source);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };
}
