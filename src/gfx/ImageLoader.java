package gfx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoader
{
    public static BufferedImage LoadImage (String Path )
    {
        try {
           return ImageIO.read(ImageLoader.class.getResource(Path)); /// how to load o imagine
         ///  ImageIO.read(getClass().getResource("/path/to/resource"));
        } catch (IOException e)
        {
            e.printStackTrace();
            System.exit(1); /// daca nu importam imaginea in joc, atunci it's useless
        }
        return null;
    }
}
