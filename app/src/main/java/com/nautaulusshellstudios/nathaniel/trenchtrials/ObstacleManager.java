package com.nautaulusshellstudios.nathaniel.trenchtrials;

import android.graphics.Canvas;

import java.util.ArrayList;

import static com.nautaulusshellstudios.nathaniel.trenchtrials.MainThread.canvas;

/**
 * Created by Nathaniel on 5/22/2018.
 */

public class ObstacleManager {
    //higher index equals lower on screen = higher y value
    public ArrayList<Obstacle> obstacles;
    private int playerGap;
    private int obstacleGap;
    private int obstacleHeight;
    private int color;

    private long startTime;
    private long initTime;

    public ObstacleManager(int playerGap, int obstacleGap, int obstacleHeight, int color){
        this.playerGap = playerGap;
        this.obstacleGap = obstacleGap;
        this.obstacleHeight = obstacleHeight;
        this.color = color;

        startTime = initTime = System.currentTimeMillis();

        obstacles = new ArrayList<>();

        populateObstacles();
    }

    public boolean playerCollide(Player player){
        for(Obstacle ob : obstacles){
            if(ob.playerCollide(player))
                return true;
        }
        return false;
    }

    private void  populateObstacles(){
        int currY = -5*Constants.SCRREEN_HEIGHT/4;
        while(currY <0){
            int xStart = (int)(Math.random()*(Constants.SCREEN_WIDTH - playerGap));
            obstacles.add(new Obstacle(obstacleHeight, color, xStart, currY, playerGap ));
            currY += obstacleHeight + obstacleGap;
        }
    }

    public void update(){
        int elapsedTime = (int)(System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();
        float speed = (float)(Math.sqrt(1 + (startTime - initTime)/1000.0)*Constants.SCRREEN_HEIGHT/(10000.0f));
        for(Obstacle ob : obstacles){
            ob.incrementY(speed*elapsedTime);
        }
        if(obstacles.get(obstacles.size()-1).getRectangle().top >= Constants.SCRREEN_HEIGHT){
            int xStart = (int)(Math.random()*(Constants.SCREEN_WIDTH - playerGap));
            obstacles.add(0, new Obstacle(obstacleHeight, color, xStart, obstacles.get(0).getRectangle().top - obstacleHeight - obstacleGap, playerGap));
            obstacles.remove(obstacles.size() - 1);
        }
    }

    public void draw(Canvas canvas){
        for(Obstacle ob : obstacles)
            ob.draw(canvas);
    }
}
