package com.pixels.blockies.app.draws;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.pixels.blockies.app.environment.StaticGameEnvironment;
import com.pixels.blockies.app.game.Grid;

/**
 * Created by keinhoerster on 3/17/14.
 */
public class GridDrawable implements Drawable {
    /**
     * Singleton instance
     */
    private static GridDrawable grid = null;

    /**
     * Define Layout-Values
     */
    public static final int STROKE = 3;
    int cellHeight = -1;
    int cellWidth = -1;

    /**
     * Drawing related
     */
    Paint paint = new Paint();
    BlockDrawable[][] blockDrawables = new BlockDrawable[StaticGameEnvironment.VERTICAL_BLOCK_COUNT][StaticGameEnvironment.HORIZONTAL_BLOCK_COUNT];
    Grid logicalGrid = Grid.getInstance();

    private GridDrawable(){

    }

    public static GridDrawable getInstance(){
        if(grid == null){
            grid = new GridDrawable();
        }
        return grid;
    }

    @Override
    public void draw(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(STROKE);
        updateFromLogicalGrid();
        for (int i = 0; i < blockDrawables.length; i++) {
            for (int j = 0; j < blockDrawables[i].length; j++) {
                if(blockDrawables[i][j] != null) {
                    blockDrawables[i][j].draw(canvas);
                }
            }
        }
    }

    private void updateFromLogicalGrid() {
        for (int i = 0; i < blockDrawables.length; i++) {
            BlockDrawable[] line = blockDrawables[i];
            for (int j = 0; j < line.length; j++) {
                if(logicalGrid.getPositionValue(i,j) == 1) {
                    BlockDrawable b = new BlockDrawable(cellWidth, cellHeight);
                    b.setX((i * cellWidth) + StaticGameEnvironment.BORDER);
                    b.setY((j * cellHeight) + StaticGameEnvironment.BORDER);
                    line[j] = b;
                }else{
                    line[j] = null;
                }
            }
        }
    }

    public void setCellHeight(int cellHeight) {
        this.cellHeight = cellHeight;
    }

    public void setCellWidth(int cellWidth) {
        this.cellWidth = cellWidth;
    }
}
