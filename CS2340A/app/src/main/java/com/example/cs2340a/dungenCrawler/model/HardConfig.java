package com.example.cs2340a.dungenCrawler.model;

import android.content.res.Resources;
import android.os.Parcel;

import androidx.annotation.NonNull;

public class HardConfig extends GameConfig {

    public HardConfig(Player player, Background bg) {
        super(player, bg);
    }
    /*
    public HardConfig(Player player, Background bg, int room) {
        super(player, bg, room);
    }
     */
    public HardConfig(Player player, Background bg, int room, Resources res) {
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
