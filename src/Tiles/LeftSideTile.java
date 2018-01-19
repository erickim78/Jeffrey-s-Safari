package Tiles;

public class LeftSideTile extends Tile
{
    public LeftSideTile(int id)
    {
        super(Assets.leftside, id);
    }
    
    public boolean isSolid()
    {
        return true;
    }
}
