package Tiles;


import gfx.Assets;

public class TreeTile  extends  Tile{

    public TreeTile( int id) {
        super(Assets.tree, id);
    }

    @Override
    public boolean Solid() {
        return true;
    }
}
