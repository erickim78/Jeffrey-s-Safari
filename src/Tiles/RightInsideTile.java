package Tiles;

public class RightInsideTile extends Tile
{
    public RightInsideTile(int id)
    {
        super(Assets.rightinside,id);
    }
    
    public boolean isSolid()
    {
        return true;
    }
}