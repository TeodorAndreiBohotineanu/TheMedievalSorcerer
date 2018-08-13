package Tiles;

import gfx.Assets;

public class TablebTile extends Tile {
    public TablebTile( int id) {
        super(Assets.tableb, id);
    }
    @Override
    public boolean Solid ( )
    {
        return true;
    }
}
