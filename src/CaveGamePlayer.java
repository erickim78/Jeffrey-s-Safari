

import Tiles.Animation;
import Tiles.Assets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class CaveGamePlayer extends Entity
{
    
    //Animations
    private Animation movedown, moveup, moveleft, moveright;
    private JFrame movementFrame;
    private float lastx, lasty;
    private float tilex, tiley;
    private AudioStream walkaudio, caveaudio;
    private boolean audio, encounter;
    
    private Pokemon p;
    private World world;
    
    private KeyManager keymanager;
    private BufferedImage u, d, l, r;
    public static final int DEFAULT_PLAYER_WIDTH = 64;
    public static final int DEFAULT_PLAYER_HEIGHT = 64;
    
    private int lastmove;
    
    public CaveGamePlayer(Handler handler, float x, float y, int width, int height, KeyManager manager)
    {
        super(handler,x,y,width, height);
        bounds.x = 16;
        bounds.y = 32;
        bounds.width = 32;
        bounds.height = 32;
        lastmove = 0;
        movementFrame = handler.getDisplay().getFrame();    
        lastx = 0;
        lasty = 0;
        tilex = 0;
        tiley = 0;
        x = 448;
        y = 896;
        
        keymanager = manager;
        
        audio = false;
        encounter = false;
        
        u = Assets.up;
        d = Assets.down; 
        l = Assets.left;
        r = Assets.right; 
        
        movedown = new Animation(100,Assets.player_down);
        moveup = new Animation(100,Assets.player_up);
        moveleft = new Animation(100,Assets.player_left);
        moveright = new Animation(100, Assets.player_right);
    }
    
    public JFrame getFrame()
    {
        return movementFrame;
    }
    
    public void tick()
    {
        movedown.tick();
        moveup.tick();
        moveright.tick();
        moveleft.tick();
        
        
        if(!audio)
        {
            AudioPlayer.player.stop(walkaudio);
            caveMusic();
            audio = true;
        }
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
        tilex = x/64;
        tiley = y/64;
        
        if(((x > 400 && x < 512) && (y > 980 && y < 1028)))
        {            
            keymanager.stopWalking();
           
            xMove = 0;
            yMove = 0;
            AudioPlayer.player.stop(caveaudio);
            x = 448;
            y = 980;
            audio = false;
            lastmove = 0;
            p = null; 
            
            handler.setWorld(handler.getGame().getGameState().getWorld());
          
            handler.getGame().getCaveGameState().setState(handler.getGame().getGameState());
            
        }
        
        
        if((lastx!=tilex || lasty!=tiley) &&(tiley >= 1 && tiley < 5) && (tilex>=5 && tilex< 10))
        {
            lastx = tilex;
            lasty = tiley;
            
            if((int)(Math.random()*200+1) <= 2)
            {
                keymanager.stopWalking();
                movementFrame.setVisible(false);
                xMove = 0;
                yMove = 0;
                AudioPlayer.player.stop(caveaudio);
                audio = false;
                encounter = true;
                p = new James();
                handler.getGame().getCaveGameState().setState(handler.getGame().getBattleState()); 
            }
            if(handler.getGame().getCaveGameState().equals(handler.getGame().getCaveGameState().getState())&& encounter)
            {
                encounter = false;
                handler.getGame().resetBattleState();
            }
        }

    }
        
    public void caveMusic()
    {
        InputStream in;
        try
        {
            in = new FileInputStream(new File("C:\\Users\\Eric Kim\\Documents\\NetBeansProjects\\JeffreysSafari\\src\\CaveMusic.wav"));
            caveaudio = new AudioStream(in);
            AudioPlayer.player.start(caveaudio);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void walkMusic()
    {
        InputStream in;
        try
        {
            in = new FileInputStream(new File("C:\\Users\\Eric Kim\\Documents\\NetBeansProjects\\JeffreysSafari\\src\\WalkMusic.wav"));
            walkaudio = new AudioStream(in);
            AudioPlayer.player.start(walkaudio);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public Pokemon getPokemon()
    {
        return p;
    }
    
    private void getInput()
    {
        if(( x > 256 && x < 640 && y > 0 && y < 256)||(x > 320 && x < 640 && y > 832 && y < 1088))
        {
            setyMove(0);
            setxMove(0);
        }
        if(handler.getKeyManager().up)
        {
            yMove = -3;
            lastmove = 0;
        }
        if(handler.getKeyManager().down)
        {
            yMove = 3;
            lastmove = 1;
        }
        if(handler.getKeyManager().left)
        {
            xMove = -3;
            lastmove = 2;
        }
        if(handler.getKeyManager().right)
        {
            xMove = 3;
            lastmove = 3;
        }
    }
    
    
    public void move()
    {
        super.move();
        lastx = x;
        lasty = y;
    }
    
    public void render(Graphics g)
    {
        g.drawImage(getCurrentAnimationFrame(),(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),null);
        
    }
    
    private BufferedImage getCurrentAnimationFrame()
    {
        if(xMove ==0 && yMove == 0)
        {
            if(lastmove == 1)
                return d;
            else if(lastmove == 2)
                return l;
            else if(lastmove == 3)
                return r;
            return u;
        }
        else if(xMove < 0)
        {
            return moveleft.getCurrentFrame();
        }
        else if(xMove > 0)
        {
            return moveright.getCurrentFrame();
        }
        else if(yMove < 0)
        {
            return moveup.getCurrentFrame();
        }
        else
        {
            return movedown.getCurrentFrame();
        }
            
    }
    
}