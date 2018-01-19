package Tiles;

public class LeftOutsideTile extends Tile
{
    public LeftOutsideTile(int id)
    {
        super(Assets.leftoutside,id);
    }
    
    public boolean isSolid()
    {
        return true;
    }
}