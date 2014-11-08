package com.pixels.blockies.app.draws;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by keinmark on 08.03.14.
 */
public class BlockDrawable implements Drawable {
    Paint paint = new Paint();
    private int width = 0;
    private int height = 0;
    private int x = -1;
    private int y = -1;

    public BlockDrawable(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void draw(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(3);
        canvas.drawRect(x, y, x + width, y + height, paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        canvas.drawRect(x, y, x + width, y + height, paint);
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
