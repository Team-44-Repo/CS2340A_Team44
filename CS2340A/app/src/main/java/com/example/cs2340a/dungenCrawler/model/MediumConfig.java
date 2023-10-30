package com.example.cs2340a.dungenCrawler.model;

import android.content.res.Resources;
import android.os.Parcel;

import androidx.annotation.NonNull;

public class MediumConfig extends GameConfig {
    /*
    Contains all game info specific to a game played on the MEDIUM difficulty.
     */

    public MediumConfig(Player player, Background bg) {
        super(player, bg); }
    /*
    public MediumConfig(Player player, Background bg, int room) { super(player, bg, room); }
     */
    public MediumConfig(Player player, Background bg, int room, Resources res) {
        super(player, bg, room, res);
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
