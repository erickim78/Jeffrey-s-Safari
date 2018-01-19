package Tiles;


import java.awt.image.BufferedImage;

public class Assets
{
    private static final int width = 64, height = 64;
    
    public static BufferedImage up,down, right, left, ice, grass, tallgrass, tree, dirt, rock, caveentrance, cave, centerout, botrightout, botleftout, leftoutside, rightoutside, top, topleftout, toprightout, flower, fence, leftinside, rightinside, stairs, rightentrance,insideentrance, leftentrance, toprightin, topleftin, leftside, rightside, inside;
    public static BufferedImage[] player_down, player_up, player_left, player_right;
    public static void init()
    {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("sprite sheet.png"));
        
        player_down = new BufferedImage[4];
        player_up = new BufferedImage[4];
        player_right = new BufferedImage[4];
        player_left = new BufferedImage[4];
        
        player_down[0] = sheet.crop(0,0,width,height);
        player_down[1] = sheet.crop(width,0,width,height);
        player_down[2] = sheet.crop(width*2,0,width,height);
        player_down[3] = sheet.crop(width*3,0,width,height);
        
        player_up[0] = sheet.crop(0,height*3,width,height);
        player_up[1] = sheet.crop(width,height*3,width,height);
        player_up[2] = sheet.crop(width*2,height*3,width,height);
        player_up[3] = sheet.crop(width*3,height*3,width,height);
        
        
        player_right[0] = sheet.crop(0, height*2, width, height);
        player_right[1] = sheet.crop(width,height*2,width,height);
        player_right[2] = sheet.crop(width*2,height*2,width,height);
        player_right[3] = sheet.crop(width*3,height*2,width,height);
        
        player_left[0] = sheet.crop(0,height,width,height);
        player_left[1] = sheet.crop(width,height,width,height);
        player_left[2] = sheet.crop(width*2,height,width,height);
        player_left[3] = sheet.crop(width*3,height,width,height);
        
        up = sheet.crop(0,height*3,width,height);
        down = sheet.crop(0,0,width,height);
        right = sheet.crop(0,height*2,width,height);
        left = sheet.crop(0,height,width,height);

        
        SpriteSheet sheet2 = new SpriteSheet(ImageLoader.LoadImage("spritesheet.png"));
        grass = sheet2.crop(0, 0, 16, 16);
        tallgrass = sheet2.crop(16, 0, 16, 16);
        ice = sheet2.crop(32, 0, 16, 16);
        dirt = sheet2.crop(48,0,16,16);
        caveentrance = sheet2.crop(0, 16, 16, 16);
        cave = sheet2.crop(16, 16, 16, 16);
        centerout = sheet2.crop(32, 16, 16, 16);
        botrightout = sheet2.crop(48,16,16,16);
        botleftout = sheet2.crop(0, 32, 16, 16);
        leftoutside = sheet2.crop(16, 32, 16, 16);
        rightoutside = sheet2.crop(32, 32, 16, 16);
        top = sheet2.crop(48, 32, 16, 16);
        topleftout = sheet2.crop(0,48,16,16);
        toprightout = sheet2.crop(16, 48, 16, 16);
        flower = sheet2.crop(32, 48, 16, 16);
        fence = sheet2.crop(48, 48, 16, 16);
        leftinside = sheet2.crop(0,64,16,16);
        rightinside = sheet2.crop(16, 64, 16, 16);
        rock = sheet2.crop(32, 64, 16, 16);
        stairs = sheet2.crop(48, 64, 16, 16);
        tree = sheet2.crop(0, 80, 16, 16);
        leftentrance = sheet2.crop(16,80,16,16);
        insideentrance = sheet2.crop(32,80,16,16);
        rightentrance = sheet2.crop(48,80, 16, 16);
        topleftin = sheet2.crop(0,96, 16, 16);
        toprightin = sheet2.crop(16,96, 16, 16);
        leftside = sheet2.crop(32,96, 16, 16);
        rightside = sheet2.crop(48,96, 16, 16);
        inside  = sheet2.crop(64,96, 16, 16);
        
    }
}