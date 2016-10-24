package edu.wisc.ece.galacticbattle;

import java.util.ArrayList;

/**
 * Created by Blake on 10/17/2016.
 */
public class Spaceship {
    private int x;
    private int y;
    private int widthRadius;
    private int heightRadius;
    private int lives = 3;

    public Spaceship(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public boolean isHit(Bullet bullet)
    {
        int bulletX = bullet.getX();
        int bulletY = bullet.getY();
        int range = 5;

        if ((Math.abs(x - bulletX) <= range) && (Math.abs(y - bulletY) <= range))
        {
            return true;
        }

        return false;
    }

    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidthRadius() { return widthRadius; }

    public int getHeightRadius() { return heightRadius; }

    public boolean isAlive() {
        return lives > 0;
    }

    public boolean collisionDetection(ArrayList<Bullet> bullets) {
        for (int i = 0; i < bullets.size(); i++) {
            Bullet b = bullets.get(i);
            if(b.getX() > x - widthRadius - b.getWidthRadius()
                    && b.getX() < x + widthRadius + b.getWidthRadius()
                    && b.getY() > y - heightRadius - b.getHeightRadius()
                    && b.getY() < y + heightRadius + b.getHeightRadius()){
                bullets.remove(i);
                return true;
            }
        }
        return false;
    }
}
