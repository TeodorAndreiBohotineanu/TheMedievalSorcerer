package Entities.Creatures;

import Main.Game;
import Main.Handler;
import gfx.Assets;

import java.awt.*;

public class Player extends  Creature {
    public Player(Handler handler, float x, float y)
    {
        super(handler, x, y,Creature.DEFAULT_Player_WIDTH,Creature.DEFAULT_Player_HEIGHT);
    }
    /// trebuie puse pentru ca nu mai e abstract
    @Override
    public void update( )
    {
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
        graph.drawImage(Assets.player,(int) (x - handler.getGameCamera().getxOffset()),(int) (y-handler.getGameCamera().getyOffset()),width, height,null);
    }
}
