package com.example.cs2340a.dungenCrawler.model;

import android.content.res.Resources;
import android.os.Parcel;

import androidx.annotation.NonNull;

public class HardConfig extends GameConfig {

    /*
    Contains all game info specific to a game played on the HARD difficulty.
     */

    public HardConfig(Player player, Room room) {
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

    protected HardConfig(Parcel in) {
        super(in);
    }

    public static final Creator<HardConfig> CREATOR = new Creator<HardConfig>() {
        @Override
        public HardConfig createFromParcel(Parcel in) {
            return new HardConfig(in);
        }

        @Override
        public HardConfig[] newArray(int size) {
            return new HardConfig[size];
        }
    };
}
