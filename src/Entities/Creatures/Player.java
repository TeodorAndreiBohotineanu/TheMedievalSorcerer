package Entities.Creatures;

import Main.Handler;
import gfx.Animation;
import gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

import static gfx.Assets.*;

public class Player extends  Creature {
    private Animation animRight;
    private Animation animIdle;
    private Animation animLeft;
    private Animation animLadder;
    public Player(Handler handler, float x, float y)
    {
        super(handler, x, y,Creature.DEFAULT_Player_WIDTH,Creature.DEFAULT_Player_HEIGHT);
        bounds.x = 14;
        bounds.y = 29;
        bounds.width = 29;
        bounds.height = 43; /// colision box a.k.a hit-boxul playerului
        animIdle = new Animation(135,player_idle);
        animRight = new Animation(135,player_right);
        animLeft = new Animation(135,player_left);
        animLadder = new Animation(135,player_ladder);
    }
    /// trebuie puse pentru ca nu mai e abstract
    @Override
    public void update( )
    {
        animIdle.update();
        animLadder.update();
        animRight.update();
        animLeft.update();
        getInput();
        Move ( );
        handler.getGameCamera().CenterOnEntity(this);
    }
    private void getInput( )
    {
        xMove = 0;
        yMove = 0;
        if (handler.getKeyManager().Up)
            yMove = -Speed;
        if (handler.getKeyManager().Down)
            yMove = Speed;
        if (handler.getKeyManager().Left)
            xMove = -Speed;
        if (handler.getKeyManager().Right)
            xMove = Speed;
    }
    @Override
    public void render(Graphics graph)
    {
        graph.drawImage(getCurrentAnimationFrame(),(int) (x - handler.getGameCamera().getxOffset()),(int) (y-handler.getGameCamera().getyOffset()),width, height,null);
     // graph.setColor(Color.red);
      //graph.fillRect((int) (x+bounds.x - handler.getGameCamera().getxOffset()),(int) (y + bounds.y - handler.getGameCamera().getyOffset()),bounds.width,bounds.height);
    }
    private BufferedImage getCurrentAnimationFrame ( )
    {
        if (xMove < 0)
            return animLeft.getCurrentFrame();
        else if (xMove > 0)
            return animRight.getCurrentFrame();
        else if (yMove < 0 || yMove > 0)
            return animLadder.getCurrentFrame();
        else
            return animIdle.getCurrentFrame();
    }
}
