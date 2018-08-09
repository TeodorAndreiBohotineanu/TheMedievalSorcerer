package States;

import Main.Game;
import Main.Handler;

import java.awt.*;

public abstract class State {

    private static State CurrentState = null;
    public static void SetState (State state) /// Game State Manager
    {
        CurrentState= state; /// se da starea curenta
    }
    public static State getState ( )
    {
        return CurrentState; /// se ia starea curenta
    }
    protected Handler handler;
    public State (Handler handler)
    {
        this.handler=handler;
    }
    public abstract void update ( );
    public abstract void render (Graphics graph);
}
