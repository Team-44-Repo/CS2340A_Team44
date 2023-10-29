package com.example.cs2340a.dungenCrawler.model;

import android.os.Parcel;

import androidx.annotation.NonNull;

public class MediumConfig extends GameConfig {

    public MediumConfig(Player player, Background bg) {
        super(player, bg);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeParcelable(getPlayer(), flags);
        dest.writeParcelable(super.getBG(), flags);
    }

    protected MediumConfig(Parcel in) {
        super(in);
    }

    public static final Creator<MediumConfig> CREATOR = new Creator<MediumConfig>() {
        @Override
        public MediumConfig createFromParcel(Parcel in) {
            return new MediumConfig(in);
        }

        @Override
        public MediumConfig[] newArray(int size) {
            return new MediumConfig[size];
        }
    };
}
