package States;

import Entities.Creatures.Player;
import Main.Handler;
import Worlds.World;

import java.awt.*;
public class GameState extends State
{
    private Player player;
    private World world;
    public GameState (Handler handler) /// constructor
    {
        super(handler);
        world = new World(handler,"resources/worlds/level1.txt");
        handler.setWorld(world);
        player = new Player(handler,100,100);
    }
    @Override
    public void update( )
    {
        world.update( );
        player.update( );
    }

    @Override
    public void render(Graphics graph)
    {
        world.render(graph);
        player.render(graph);
    }
}
