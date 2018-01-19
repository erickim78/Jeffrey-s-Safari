


import java.awt.Graphics;

public class GameState extends State
{
    private Player player;
    private World world;
    private KeyManager manager;
   
	
    public GameState(Handler handler, KeyManager manager)
    {
        super(handler);
        world = new World(handler, "C:\\Users\\Eric Kim\\Documents\\NetBeansProjects\\JeffreysSafari\\src\\World1.txt");
        handler.setWorld(world);
        player = new Player(handler, 896, 5120, 64, 64, manager);
    }
       
    
    public World getWorld()
    {
        return world;
    }
    
    public Pokemon getPokemon()
    {
        return player.getPokemon();
    }
    
    public Player getPlayer()
    {
        return player;
    }
    
    public void tick()
    {
        world.tick();
        player.tick();
    }
    
    public void render(Graphics g)
    {
        world.render(g);
        player.render(g);
    }
}