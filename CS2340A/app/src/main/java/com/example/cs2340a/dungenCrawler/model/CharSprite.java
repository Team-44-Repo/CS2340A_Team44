package com.example.cs2340a.dungenCrawler.model;

public class CharSprite {
    private int spriteResId; //sprite img's resource id
    private String spriteName; //identifier for the sprite

    //basic constructor
    public CharSprite(int spriteResId, String spriteName) {
        this.spriteResId = spriteResId;
        this.spriteName = spriteName;
    }

    //getters
    public int getSpriteResId() {
        return spriteResId;
    }
    public String getSpriteName() {
        return spriteName;
    }
    //setters
    public void setSpriteResId(int id) {
        this.spriteResId = id;
    }
    public void setSpriteName(String name) {
        this.spriteName = name;
    }
}
