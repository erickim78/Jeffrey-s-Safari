package Tiles;

public class CaveRoofTile extends Tile
{
    public CaveRoofTile(int id)
    {
        super(Assets.cave,id);
    }
    
    public boolean isSolid()
    {
        return true;
    }
}