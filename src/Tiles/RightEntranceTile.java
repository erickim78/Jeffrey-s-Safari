package Tiles;

public class RightEntranceTile extends Tile
{
    public RightEntranceTile(int id)
    {
        super(Assets.rightentrance,id);
    }
    
    public boolean isSolid()
    {
        return true;
    }
}