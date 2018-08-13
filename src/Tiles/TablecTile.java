package Tiles;

import gfx.Assets;

public class TablecTile extends Tile {
    public TablecTile(int id) {
        super(Assets.tablec, id);
    }
    @Override
    public boolean Solid ( )
    {
        return true;
    }
}
