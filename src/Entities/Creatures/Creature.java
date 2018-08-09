package Entities.Creatures;

import Entities.Entity;
import Main.Game;
import Main.Handler;

public abstract class Creature extends Entity
{
    public static final int DEFAULT_HP=10;
    public static final float DEFAULT_SPEED=4.0f;
    public static final int DEFAULT_CREATURE_Enemy_WIDTH=36,
            DEFAULT_CREATURE_Enemy_HEIGHT=51;
    public static final int DEFAULT_Player_WIDTH=80,
            DEFAULT_Player_HEIGHT=82;
    protected int HP;
    protected float Speed;
    protected float xMove, yMove;
    public Creature(Handler handler, float x, float y, int width, int height)
    {
        super(handler,x, y,width,height); /// super duce la ce am dat extend, aici Entity
        HP= DEFAULT_HP;
        Speed=DEFAULT_SPEED;
        xMove=0;
        yMove=0;
    }
    public void Move ( )
    {
        x+=xMove;
        y+=yMove;
    }
    /// Getters and Setters
    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public float getSpeed() {
        return Speed;
    }

    public void setSpeed(float speed) {
        Speed = speed;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }
}
