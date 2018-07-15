package com.nautaulusshellstudios.nathaniel.trenchtrials;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

/**
 * Created by Nathaniel on 5/22/2018.
 */

public class Player implements GameObject {

    private Rect player;
    private int color;

    public Rect getPlayer(){
        return player;
    }

    public Player(Rect player, int color) {
        this.player = player;
        this.color = color;
    }

    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawRect(player, paint);
    }

    @Override
    public void update() {

    }

    public void update(Point point){
        //l,t,r,b
        player.set(point.x - player.width()/2, point.y - player.height()/2, point.x + player.width()/2, point.y + player.height()/2);
    }
}
