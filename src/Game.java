
import Tiles.Assets;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game implements Runnable
{
    private Display display;
    private int width, height;
    public String title;
    private Thread thread;
    private boolean running = false;
    
    private BufferStrategy bs; // a way for a computer to draw things onto the screen
    private Graphics g;
    
    //States
    private State gameState;
    private State battleState;
    private State cavegameState;
    
    //Input
    private KeyManager keyManager;
    
    //Camera
    private GameCamera gameCamera;
    
    //Handler
    private Handler handler;
    
    public Game(String title, int width, int height)
    {
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
    }
    
    private void init()
    {
        display = new Display(title,width,height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();
        
        handler = new Handler(this);
        gameCamera = new GameCamera(handler,0,0);
        
        cavegameState = new CaveGameState(handler, keyManager);
        gameState = new GameState(handler, keyManager);
        //cavegameState = new CaveGameState(handler, keyManager);
        battleState = new BattleState(handler);
        
        State.setState(gameState);
    }
    
    private void tick() //update
    {
        keyManager.tick();
        
        if(State.getState()!= null)
        {
            State.getState().tick();
        }
    }
    
    private void render() //draw things onto the screen
    {
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null)
        {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics(); //graphics allows you to draw things onto the canvas
        //Clear Screen
        g.clearRect(0, 0, width, height);
        //Draw Here
        if(State.getState()!= null)
        {
            State.getState().render(g);
        }

        //End Drawing
        bs.show();
        g.dispose();
    }
    
    public Display getDisplay()
    {
        return display;
    }
    
    public void setDisplay(Display d)
    {
        display = d;
    }
    
    public void run()
    {
        init();
        
        int fps = 60;
        double timePerTick = 1000000000/fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime(); //returns the amount of time in nanoseconds that the computer is running at
        
        while(running)
        {
            now = System.nanoTime();
            delta += (now - lastTime)/timePerTick;
            lastTime = now;
            
            if(delta >= 1)
            {
                tick();
                render();
                delta--;
            }

        }
        stop();
        
    }
    
    public State getGameState()
    {
        return gameState;
    }
    
    public KeyManager getKeyManager()
    {
        return keyManager;
    }
    
    public GameCamera getGameCamera()
    {
        return gameCamera;
    }
    
    public int getWidth()
    {
        return width;
    }
    
    public int getHeight()
    {
        return height;
    }
    
    public synchronized void start()
    {
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    public synchronized void stop()
    {
        if(!running)
            return;
        running = false;
        try 
        {
            thread.join();
        }
        catch (InterruptedException ex) 
        {
            ex.printStackTrace();
        }
    }
    
    public State getBattleState()
    {
        return battleState;
    }
    
    public State getCaveGameState()
    {
        return cavegameState;
    }
    
    public void resetBattleState()
    {
        battleState = new BattleState(handler);
    }
}