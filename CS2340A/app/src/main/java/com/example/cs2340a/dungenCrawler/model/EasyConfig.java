package com.example.cs2340a.dungenCrawler.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class EasyConfig extends GameConfig {
    public EasyConfig(Player player, Background bg) {
        super(player, bg);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeParcelable(super.getPlayer(), flags);
        dest.writeParcelable(super.getBG(), flags);
    }

    protected EasyConfig(Parcel in) {
        super(in);
    }

    public static final Creator<EasyConfig> CREATOR = new Creator<EasyConfig>() {
        @Override
        public EasyConfig createFromParcel(Parcel in) {
            return new EasyConfig(in);
        }

        @Override
        public EasyConfig[] newArray(int size) {
            return new EasyConfig[size];
        }
    };
}
