package com.nautaulusshellstudios.nathaniel.trenchtrials;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by Nathaniel on 5/22/2018.
 */

public class Obstacle implements GameObject {

    private Rect rectangle;
    private Rect rectangle2;
    private int color;

    public Rect getRectangle(){
        return rectangle;
    }

    public void incrementY(float y){
        rectangle.top += y;
        rectangle.bottom += y;
        rectangle2.top += y;
        rectangle2.bottom += y;
    }

    public Obstacle(int rectHeight, int color, int startX, int startY, int playerGap) {
        this.color = color;
        rectangle = new Rect(0, startY, startX, startY + rectHeight);
        rectangle2 = new Rect(startX + playerGap, startY, Constants.SCREEN_WIDTH, startY + rectHeight);
    }

    public boolean playerCollide(Player player){
        return Rect.intersects(rectangle, player.getPlayer()) || Rect.intersects(rectangle2, player.getPlayer());

    }

    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawRect(rectangle, paint);
        canvas.drawRect(rectangle2, paint);
    }

    @Override
    public void update() {

    }
}
