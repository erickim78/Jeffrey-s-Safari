package Tiles;

public class TopTile extends Tile
{
    public TopTile(int id)
    {
        super(Assets.top,id);
    }
    
    public boolean isSolid()
    {
        return true;
    }
}