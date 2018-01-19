
package Tiles;

public class TopRightInTile extends Tile
{
    public TopRightInTile(int id)
    {
        super(Assets.toprightin, id);
    }
    
    public boolean isSolid()
    {
        return true;
    }
}
