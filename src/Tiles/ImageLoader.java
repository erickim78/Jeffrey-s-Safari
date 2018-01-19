package Tiles;


import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageLoader
{
    public static BufferedImage LoadImage(String path)
    {
        try 
        {
            return ImageIO.read(ImageLoader.class.getResource(path));
        } 
        catch (IOException ex) 
        {
            ex.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}