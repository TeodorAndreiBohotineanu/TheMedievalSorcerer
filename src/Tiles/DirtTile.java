package Tiles;

import gfx.Assets;

public class DirtTile extends Tile {
    public DirtTile(int id) {
        super(Assets.dirt, id);
    }
    @Override
    public boolean Solid ( )
    {
        return true;
    }
}
