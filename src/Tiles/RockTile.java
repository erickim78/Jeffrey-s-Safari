package Tiles;

public class RockTile extends Tile
{
    public RockTile(int id)
    {
        super(Assets.rock,id);
    }
    
    public boolean isSolid()
    {
        return true;
    }
}