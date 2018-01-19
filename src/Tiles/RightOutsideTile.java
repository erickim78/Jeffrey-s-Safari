package Tiles;

public class RightOutsideTile extends Tile
{
    public RightOutsideTile(int id)
    {
        super(Assets.rightoutside,id);
    }
    
    public boolean isSolid()
    {
        return true;
    }
}