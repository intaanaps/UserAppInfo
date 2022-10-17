package com.unsri.userappgithub;

import android.os.Parcel;
import android.os.Parcelable;

public class Kage implements Parcelable {
    private String namaKage;
    private String japanKage;
    private String tingkatanKage;
    private Integer fotoKage;


    protected Kage(Parcel in) {
        namaKage = in.readString();
        japanKage = in.readString();
        tingkatanKage = in.readString();
        if (in.readByte() == 0) {
            fotoKage = null;
        } else {
            fotoKage = in.readInt();
        }
    }

    public static final Creator<Kage> CREATOR = new Creator<Kage>() {
        @Override
        public Kage createFromParcel(Parcel in) {
            return new Kage(in);
        }

        @Override
        public Kage[] newArray(int size) {
            return new Kage[size];
        }
    };

    public Kage() {

    }


    public String getNamaKage() {
        return namaKage;
    }

    public void setNamaKage(String namaKage) {
        this.namaKage = namaKage;
    }

    public String getJapanKage() {
        return japanKage;
    }

    public void setJapanKage(String japanKage) {
        this.japanKage = japanKage;
    }

    public String getTingkatanKage() {
        return tingkatanKage;
    }

    public void setTingkatanKage(String tingkatanKage) {
        this.tingkatanKage = tingkatanKage;
    }


    public Integer getFotoKage() {
        return fotoKage;
    }

    public void setFotoKage(Integer fotoKage) {
        this.fotoKage = fotoKage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(namaKage);
        dest.writeString(japanKage);
        dest.writeString(tingkatanKage);
        if (fotoKage == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(fotoKage);
        }
    }
}
