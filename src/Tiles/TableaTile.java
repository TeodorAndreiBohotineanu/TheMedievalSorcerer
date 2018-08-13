package Tiles;

import gfx.Assets;


public class TableaTile extends Tile {
    public TableaTile(int id) {
        super(Assets.tablea, id);
    }
    @Override
    public boolean Solid ( )
    {
        return true;
    }
}
