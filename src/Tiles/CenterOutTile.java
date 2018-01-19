package Tiles;

public class CenterOutTile extends Tile
{
    public CenterOutTile(int id)
    {
        super(Assets.centerout,id);
    }
    
    public boolean isSolid()
    {
        return true;
    }
}