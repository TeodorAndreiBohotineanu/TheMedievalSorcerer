package Tiles;

import gfx.Assets;

public class SpikeTile extends Tile {
    public SpikeTile (int id) {
        super(Assets.spike, id);
    }
    @Override
    public boolean Solid ( )
    {
        return true;
    }
}
