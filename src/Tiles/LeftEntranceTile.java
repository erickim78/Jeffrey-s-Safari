package Tiles;

public class LeftEntranceTile extends Tile
{
    public LeftEntranceTile(int id)
    {
        super(Assets.leftentrance,id);
    }
    
    public boolean isSolid()
    {
        return true;
    }
}