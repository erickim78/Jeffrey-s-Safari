package Tiles;

public class TopLeftInTile extends Tile
{
    public TopLeftInTile(int id)
    {
        super(Assets.topleftin, id);
    }
    
    public boolean isSolid()
    {
        return true;
    }
}