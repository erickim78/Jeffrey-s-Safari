package Tiles;

public class TopRightOutTile extends Tile
{
    public TopRightOutTile(int id)
    {
        super(Assets.toprightout,id);
    }
    
    public boolean isSolid()
    {
        return true;
    }
}