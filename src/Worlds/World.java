package Worlds;

import Main.Game;
import Main.Handler;
import Tiles.Tile;
import Utils.Utils;

import javax.rmi.CORBA.Util;
import java.awt.*;

public class World
{
    private Handler handler;
    private int width, height;
    private int SpawnX, SpawnY;
    private int[][] tiles;
    public World(Handler handler, String path)
    {
        this.handler = handler;
        LoadLevel(path);
    }
    public void update ( )
    {

    }
    public void render (Graphics g)
    {
        int xStart = (int) Math.max(0,handler.getGameCamera().getxOffset() / Tile.TWIDTH ); /// astea 4 randeaza doar celulele din camera, e mai eficient
        int xEnd = (int) Math.min(width,(handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TWIDTH +1);
        int yStart = (int) Math.max(0,handler.getGameCamera().getyOffset() / Tile.THEIGHT);
        int yEnd = (int) Math.min(height,(handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.THEIGHT +1);
        for (int y =yStart;y<yEnd;y++)
            for (int x=xStart;x<xEnd;x++)
            getTile(x,y).render(g,(int) (x*Tile.TWIDTH - handler.getGameCamera().getxOffset()),(int) (y*Tile.THEIGHT - handler.getGameCamera().getyOffset()));
    }
    public Tile getTile ( int x, int y )
    {
        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null )
            return Tile.grassTile;
        return t;
    }
    private void LoadLevel (String path)
    {
        String file = Utils.LoadFileAsString(path);
        String[] tokens = file.split("\\s+"); /// toate numere din .txt vor fi un numar individual si il pune intr-un string
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        SpawnX = Utils.parseInt(tokens[2]);
        SpawnY = Utils.parseInt(tokens[3]); /// astea citesc primele 4 numere din fisier
        tiles = new int [width][height];
        for (int y=0;y<height;y++)
            for (int x=0;x<width;x++)
                tiles[x][y]=Utils.parseInt(tokens[(x+y*width)+4]);
    }
}
