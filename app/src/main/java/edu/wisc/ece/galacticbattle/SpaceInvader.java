package edu.wisc.ece.galacticbattle;

import android.widget.ImageView;

/**
 * Created by Grego on 11/10/2016.
 */

public class SpaceInvader {
    private float x;
    private float y;
    private float widthRadius;
    private float heightRadius;
    private int lives = 1;

    public ImageView spaceInvader;

    public SpaceInvader(float x, float y, ImageView v) {
        this.x = x;
        this.y = y;
        //v.setX(x);
        //v.setY(y);
        this.widthRadius = (float)0.05;
        this.heightRadius = (float)0.05;
        this.spaceInvader = v;
    }

    public void setX(float x) {
        this.x = x - 15;
        spaceInvader.setX(x);
    }

    public void setY(float y) {
        this.y = y;
    }

    public boolean isHit(Bullet b)
    {
        if(b.getX() > x - widthRadius - b.getWidthRadius()
                && b.getX() < x + widthRadius + b.getWidthRadius()
                && b.getY() > y - heightRadius - b.getHeightRadius()
                && b.getY() < y + heightRadius - b.getHeightRadius()){//don't know why we need to subtract here
                return true;
        }
//        if(b.getX() > ship.getX() - b.getWidthRadius()
//                && b.getX() < ship.getX() + widthRadius*2 + b.getWidthRadius()
//                && b.getY() > ship.getY() - heightRadius - b.getHeightRadius()
//                && b.getY() < ship.getY() + heightRadius + b.getHeightRadius()){
//            return true;
//        }

        return false;
    }

    public float getX(){
        return this.x;
    }

    public void hit()
    {
        lives = lives - 1;
    }

    public float getY() {
        return this.y;
    }

    public float getWidthRadius() { return widthRadius; }

    public float getHeightRadius() { return heightRadius; }

    public boolean isAlive() {
        return lives > 0;
    }

    public void setSource(int id)
    {
        spaceInvader.setImageResource(id);
    }

    public ImageView image(){return this.spaceInvader;}
}
