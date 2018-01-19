package Tiles;


import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile
{
   
    public static Tile[] tiles = new Tile[256];
    public static Tile grassTile = new GrassTile(0);
    public static Tile iceTile = new IceTile(1);
    public static Tile tallgrassTile = new TallGrassTile(2);
    public static Tile treeTile = new TreeTile(3);
    public static Tile dirtTile = new DirtTile(4);
    public static Tile rockTile = new RockTile(5);
    public static Tile caveentranceTile = new CaveEntranceTile(6);
    public static Tile caveTile = new CaveRoofTile(7);
    public static Tile centeroutTile = new CenterOutTile(8);
    public static Tile botrightoutTile = new BotRightOutTile(9);
    public static Tile botleftoutTile = new BotLeftOutTile(10);
    public static Tile leftoutsideTile = new LeftOutsideTile(11);
    public static Tile rightoutsideTIle = new RightOutsideTile(12);
    public static Tile topTile = new TopTile(13);
    public static Tile topleftoutTile = new TopLeftOutTile(14); 
    public static Tile toprightoutTile = new TopRightOutTile(15);
    public static Tile flowerTile = new FlowerTile(16);
    public static Tile fenceTile = new FenceTile(17);
    public static Tile leftinsideTile = new LeftInsideTile(18);
    public static Tile rightinsideTile = new RightInsideTile(19);
    public static Tile stairsTile = new StairsTile(20);
    public static Tile leftentranceTile = new LeftEntranceTile(21);
    public static Tile insideentranceTile = new InsideEntranceTile(22);
    public static Tile righttentranceTile = new RightEntranceTile(23);
    public static Tile topleftinTile = new TopLeftInTile(24);
    public static Tile toprightinTile= new TopRightInTile(25);
    public static Tile leftsideTile = new LeftSideTile(26);
    public static Tile rightsideTile = new RightSideTile(27);
    public static Tile insideTile = new InsideTile(28);
    
    protected BufferedImage texture;
    protected final int id;
    
    public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
    
    public Tile(BufferedImage texture, int id)
    {
        this.texture = texture;
        this.id = id;
        
        tiles[id] = this;

    }
    
    public int getId()
    {
        return id;
    }
    
    public boolean isSolid()
    {
        return false;
    }
    
    public void tick()
    {
        
    }
    
    public void render(Graphics g, int x, int y)
    {
        g.drawImage(texture,x,y,TILEWIDTH, TILEHEIGHT, null);
    }
}