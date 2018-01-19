package Tiles;

public class RightSideTile extends Tile
{
    public RightSideTile(int id)
    {
        super(Assets.rightside, id);
    }
    
    public boolean isSolid()
    {
        return true;
    }
}