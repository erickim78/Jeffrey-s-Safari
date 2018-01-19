package Tiles;

public class BotRightOutTile extends Tile
{
    public BotRightOutTile(int id)
    {
        super(Assets.botrightout,id);
    }
    
    public boolean isSolid()
    {
        return true;
    }
}