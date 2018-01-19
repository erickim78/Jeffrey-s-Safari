

import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class BattlePlayer
{
    private ArrayList<Pokemon> caught;
    private JFrame movementFrame;
    private JLabel spenceLabel, davidLabel, jamesLabel;
    private AudioStream walkaudio;
    private boolean inBattle;
    private float lastx, lasty;
    private Handler handler;
    
    public BattlePlayer(Handler handler)
    {
        this.handler = handler;
        movementFrame = handler.getGame().getGameState().getHandler().getDisplay().getFrame();
        caught = new ArrayList<Pokemon>();
    }
    
    public void tick()
    {
        act();
    }
    
    public void render(Graphics g)
    {
    }
    
    public void setinBattle(Boolean b)
    {
        inBattle = b;
    }
    
    public Pokemon getPokemon()
    {
        return null;
    }
    
    public boolean getinBattle()
    {
        return inBattle;
    }
    
    public void act()
    {   
        if(!inBattle)
        {
            AudioPlayer.player.stop(walkaudio);
            
            inBattle = true;
            
            
            Pokemon f1 = handler.getGame().getGameState().getPokemon();
            

            JeffreysSafari one = new JeffreysSafari(f1, movementFrame, this, spenceLabel, davidLabel, jamesLabel);
            
            
        }
    }
    
     public int numberOf(String name)
    {
        int answer = 0;
        for(Pokemon input: caught)
        {
            if(input.getName().equals(name))
                answer++;
        }
        return answer;
    }
    
    public void catchPokemon(Pokemon caughtpokemon)
    {
        caught.add(caughtpokemon);
    }
    
    public AudioStream getWalkAudio()
    {
        return walkaudio;
    }

    
    public void walkMusic()
    {
        InputStream in;
        try
        {
            in = new FileInputStream(new File("D:\\Final Jeffrey's Safari\\src\\WalkMusic.wav"));
            walkaudio = new AudioStream(in);
            AudioPlayer.player.start(walkaudio);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public Handler getHandler()
    {
        return handler;
    }
    
}
    
