package Tiles;

import gfx.Assets;

public class Spike2Tile extends Tile {
    public Spike2Tile( int id) {
        super(Assets.spike2, id);
    }
    @Override
    public boolean Solid ( )
    {
        return true;
    }
}
