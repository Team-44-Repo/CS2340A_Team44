package com.example.cs2340a.dungenCrawler.model;

import android.content.res.Resources;
import android.os.Parcel;

import androidx.annotation.NonNull;

public class MediumConfig extends GameConfig {
    /*
    Contains all game info specific to a game played on the MEDIUM difficulty.
     */
    public MediumConfig(Player player, Room room) {
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
