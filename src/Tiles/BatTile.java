package Tiles;

import gfx.Assets;

public class BatTile extends  Tile {
    public BatTile(int id) {
        super(Assets.bat, id);
    }
    @Override
    public boolean Solid ( )
    {
        return true;
    }
}
