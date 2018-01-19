package Tiles;

public class InsideTile extends Tile
{
    public InsideTile(int id)
    {
        super(Assets.inside, id);
    }
    
    public boolean isSolid()
    {
        return true;
    }
}