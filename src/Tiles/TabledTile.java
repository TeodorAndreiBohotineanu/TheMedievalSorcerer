package Tiles;

import gfx.Assets;

public class TabledTile extends Tile {
    public TabledTile(int id) {
        super(Assets.tabled, id);
    }
    @Override
    public boolean Solid ( )
    {
        return true;
    }
}
