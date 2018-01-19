package Tiles;

public class BotLeftOutTile extends Tile
{
    public BotLeftOutTile(int id)
    {
        super(Assets.botleftout,id);
    }
    
    public boolean isSolid()
    {
        return true;
    }
}
