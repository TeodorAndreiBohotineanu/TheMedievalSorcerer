package Tiles;

import gfx.Assets;


public class FloorTile extends Tile{

    public FloorTile(int id) {
        super(Assets.floor, id);
    }
    @Override
    public boolean Solid ( )
    {
        return true;
    }
}
