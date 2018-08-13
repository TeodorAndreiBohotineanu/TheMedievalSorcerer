package Main.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener
{
    public boolean Up, Down, Left, Right,Up_2,Down_2,Left_2,Right_2;
    private boolean[] Keys;
    public KeyManager( )
    {
        Keys = new boolean[256];
    }
    public  void update ( )
    {
        Up = Keys[KeyEvent.VK_W]; /// cand se apasa W se inregistreaza
        Down = Keys[KeyEvent.VK_S];
        Left = Keys[KeyEvent.VK_A];
        Right = Keys[KeyEvent.VK_D];
        Up_2 = Keys[KeyEvent.VK_KP_UP]; /// cand se apasa W se inregistreaza
        Down_2 = Keys[KeyEvent.VK_KP_DOWN];
        Left_2 = Keys[KeyEvent.VK_KP_LEFT];
        Right_2 = Keys[KeyEvent.VK_KP_RIGHT];
    }
    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        Keys[e.getKeyCode( )] = true;
        System.out.println("Pressed ");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Keys[e.getKeyCode( )] = false;
    }
}