package com.example.cs2340a.dungenCrawler.model;

import static com.example.cs2340a.dungenCrawler.model.MapLayout.NUM_COL_TILES;
import static com.example.cs2340a.dungenCrawler.model.MapLayout.NUM_ROW_TILES;
import static com.example.cs2340a.dungenCrawler.model.MapLayout.TILE_HEIGHT_PIXELS;
import static com.example.cs2340a.dungenCrawler.model.MapLayout.TILE_WIDTH_PIXELS;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cs2340a.dungenCrawler.model.MapLayout;
import com.example.cs2340a.dungenCrawler.model.SpriteSheet;
import com.example.cs2340a.dungenCrawler.model.Tile;

public class Tilemap extends AppCompatActivity {

    private final MapLayout mapLayout;
    private Tile[][] tilemap;
    private SpriteSheet spriteSheet;
    private Bitmap mapBitmap;

    public Tilemap(SpriteSheet spriteSheet) {
        mapLayout = new MapLayout();
        this.spriteSheet = spriteSheet;
        initializeTilemap();
    }

    private void initializeTilemap() {
        int[][] layout = mapLayout.getLayout();
        tilemap = new Tile[NUM_ROW_TILES][NUM_COL_TILES];
        for (int iRow = 0; iRow < NUM_ROW_TILES; iRow++) {
            for (int iCol = 0; iCol < NUM_COL_TILES; iCol++) {
                tilemap[iRow][iCol] = Tile.getTile(layout[iRow][iCol], spriteSheet, getRectByIdx(iRow, iCol));
            }
        }
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        mapBitmap = Bitmap.createBitmap(NUM_COL_TILES*TILE_WIDTH_PIXELS, NUM_ROW_TILES*TILE_HEIGHT_PIXELS, config);
        Canvas mapCanvas = new Canvas(mapBitmap);
        for (int iRow = 0; iRow < NUM_ROW_TILES; iRow++) {
            for (int iCol = 0; iCol < NUM_COL_TILES; iCol++) {
                tilemap[iRow][iCol].draw(mapCanvas);
            }
        }
    }

    
    private Rect getRectByIdx(int idxRow, int idxCol) {
        return new Rect(idxCol * TILE_WIDTH_PIXELS, idxRow*TILE_HEIGHT_PIXELS, (idxCol + 1) * TILE_WIDTH_PIXELS, (idxRow + 1) * TILE_HEIGHT_PIXELS);
    }

//    public void draw(Canvas canvas, GameDisplay gameDisplay) {
//        canvas.drawBitmap(
//                mapBitmap,
//                gameDisplay.getGameRect(),
//                gameDisplay.DISPLAY_RECT,
//                null
//        );
//    }
}
