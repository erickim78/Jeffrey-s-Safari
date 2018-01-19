package Tiles;

public class LeftInsideTile extends Tile
{
    public LeftInsideTile(int id)
    {
        super(Assets.leftinside,id);
    }
    
    public boolean isSolid()
    {
        return true;
    }
}