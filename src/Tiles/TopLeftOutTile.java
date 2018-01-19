package Tiles;

public class TopLeftOutTile extends Tile
{
    public TopLeftOutTile(int id)
    {
        super(Assets.topleftout,id);
    }
    
    public boolean isSolid()
    {
        return true;
    }
}