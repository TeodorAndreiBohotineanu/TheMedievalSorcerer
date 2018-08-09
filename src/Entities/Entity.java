package Entities;

import Main.Game;
import Main.Handler;

import java.awt.*;

public abstract class Entity
{
    protected float x,y; /// protected -> e ca si privat doar ca acele clase care extind Entities au acces la ea
    protected int width, height;
    protected Handler handler;
    public Entity(Handler handler, float x, float y, int width, int height)
    {
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width=width;
        this.height=height;
    }
    public abstract void update ( );
    public abstract void render (Graphics graph);
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
