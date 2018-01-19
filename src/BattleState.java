


import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class BattleState extends State
{
    private BattlePlayer player;
    
    public BattleState(Handler handler)
    {
        super(handler);
        player = new BattlePlayer(handler);
    }
    
    public World getWorld()
    {
        return null;
    }
    
    public Pokemon getPokemon()
    {
        return player.getPokemon();
    }
    
    public BattlePlayer returnBattlePlayer()
    {
        return player;
    }
    
    public void tick()
    {
        if(!player.getinBattle())
            player.tick();
    }
    
    public void render(Graphics g)
    {
        player.render(g);
    }
    
    
}