package Entities.Creatures;

import Entities.Entity;
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
    private Animation animAttackRight;
    private Animation animAttackLeft;
    protected boolean falling = true;
    private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;
    public Player(Handler handler, float x, float y)
    {
        super(handler, x, y,Creature.DEFAULT_Player_WIDTH,Creature.DEFAULT_Player_HEIGHT);
        bounds.x = 5;
        bounds.y = 10;
        bounds.width = 20;
        bounds.height = 40; /// colision box a.k.a hit-boxul playerului
        animIdle = new Animation(160,player_idle);
        animRight = new Animation(160,player_right);
        animLeft = new Animation(160,player_left);
        animLadder = new Animation(160,player_ladder);
        animAttackRight = new Animation(150,player_attack_right);
        animAttackLeft = new Animation( 150,player_attack_left);
    }
    /// trebuie puse pentru ca nu mai e abstract
    @Override
    public void update( )
    {
        animIdle.update();
        animLadder.update();
        animRight.update();
        animLeft.update();
        animAttackRight.update();
        animAttackLeft.update();
        getInput();
        Move ( );
        fall ( );
        handler.getGameCamera().CenterOnEntity(this);
        checkAttack ( );
    }
    Rectangle ar = new Rectangle();/// attack rectangle
    Rectangle cb = getCollisionBounds(0,0);/// rectangle bounds
    public void checkAttack ( )
    {
        attackTimer = attackTimer + System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if (attackTimer < attackCooldown)
            return;
        int arSize = 20;
        ar.width = arSize;
        ar.height = arSize;
        if (handler.getKeyManager().aUp)
        {
            ar.x = cb.x + cb.width / 2 + arSize / 2;
            ar.y = cb.y - arSize;
        }
       else if (handler.getKeyManager().aDown)
        {
            ar.x = cb.x + cb.width / 2 + arSize / 2;
            ar.y = cb.y + cb.height;
        }
       else if (handler.getKeyManager().aLeft)
        {
            ar.x = cb.x - arSize;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        }
       else if (handler.getKeyManager().aRight)
        {
            ar.x = cb.x + cb.width;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        }
        else
        {
            return ;
        }
        attackTimer = 0;
        for ( Entity e : handler.getWorld().getEntityManager().getEntities()) /// pentru fiecare entitate din ArrayList
        {
            if (e.equals(this))
                continue; /// sa nu isi ia player-ul self damage
            if (e.getCollisionBounds(0, 0).intersects(ar))
            {
                e.hurt(2);
                return ;
            }
        }
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
        if (handler.getKeyManager().Jump)
            yMove= -(Speed *3);
    }
    private void fall ( )
    {
        ///if (falling)
        while (checkEntityCollisions(0,0))
            yMove = Speed*3;
    }
    @Override
    public void render(Graphics graph)
    {
        graph.drawImage(getCurrentAnimationFrame(),(int) (x - handler.getGameCamera().getxOffset()),(int) (y-handler.getGameCamera().getyOffset()),width, height,null);
     // graph.setColor(Color.red);
     // graph.fillRect((int) (x+bounds.x - handler.getGameCamera().getxOffset()),(int) (y + bounds.y - handler.getGameCamera().getyOffset()),bounds.width,bounds.height);
        if (handler.getKeyManager().aRight)
            graph.drawImage(animAttackRight.getCurrentFrame() , (int) (ar.x-handler.getGameCamera().getxOffset()), (int) (ar.y-handler.getGameCamera().getyOffset()),width, height, null);
        else if (handler.getKeyManager().aLeft)
            graph.drawImage(animAttackLeft.getCurrentFrame(),(int) (ar.x-handler.getGameCamera().getxOffset()), (int) (ar.y-handler.getGameCamera().getyOffset()),width, height, null );
    }

    @Override
    public void dead( ) {

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
