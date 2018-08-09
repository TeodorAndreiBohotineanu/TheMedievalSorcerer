package gfx;

import java.awt.image.BufferedImage;

public class Assets {
    private static final int Pwidth=80, Pheight=82, Ewidth=36 , Eheight=51, Bwidth =32, Bheight=22;
    public static BufferedImage player, enemy, bat, eyebot, tree, grass,floor,air,clouds;
    public static void init ( ) /// incarca tot ce trebe pentru joc
    {
        SpriteSheet Player = new SpriteSheet(ImageLoader.LoadImage("/textures/gnu-120x100.png"));
        SpriteSheet Enemy = new SpriteSheet(ImageLoader.LoadImage("/textures/disciple-45x51.png"));
        SpriteSheet Bat = new SpriteSheet(ImageLoader.LoadImage("/textures/32x32-bat-sprite.png"));
        SpriteSheet EyeBot = new SpriteSheet(ImageLoader.LoadImage("/textures/eyebot.png"));
        SpriteSheet Tree = new SpriteSheet(ImageLoader.LoadImage("/textures/Tree.png"));
        SpriteSheet Grass = new SpriteSheet(ImageLoader.LoadImage("/textures/16x16 Tiles.png"));
        SpriteSheet Floor = new SpriteSheet(ImageLoader.LoadImage("/textures/omegateam.png"));
        SpriteSheet Air = new SpriteSheet(ImageLoader.LoadImage("/textures/omegateam.png"));
        SpriteSheet Clouds = new SpriteSheet(ImageLoader.LoadImage("/textures/omegateam.png"));
        player = Player.crop(15,13,Pwidth,Pheight);
        enemy = Enemy.crop(1,2,Ewidth,Eheight);
        bat = Bat.crop(65,3,Bwidth,Bheight);
        eyebot = EyeBot.crop (0,0,32,32);
        tree = Tree.crop(0,0,64,64);
        grass = Grass.crop(1,34,16,16);
        floor = Floor.crop(0,112,64,32);
        air = Air.crop(0,410,71,30);
        clouds=Clouds.crop(606,400,54,36);
    }
}
