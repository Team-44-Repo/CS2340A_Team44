package com.example.cs2340a.dungenCrawler.model;

import android.content.res.Resources;
import android.os.Parcel;

import androidx.annotation.NonNull;

public class EasyConfig extends GameConfig {
    /*
    Contains all game info specific to a game played on the EASY difficulty.
     */
    public EasyConfig(Player player, Room room) {
        super(player, room);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeParcelable(super.getPlayer(), flags);
        dest.writeParcelable(super.getCurrRoom(), flags);
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
