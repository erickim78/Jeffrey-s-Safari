import java.awt.Graphics;

public class CaveGameState extends State
{
    private CaveGamePlayer player;
    private World world;
    private KeyManager manager;
   
	
    public CaveGameState(Handler handler, KeyManager manager)
    {
        super(handler);
        world = new World(handler, "C:\\Users\\Eric Kim\\Documents\\NetBeansProjects\\JeffreysSafari\\src\\CaveWorld.txt");
        handler.setWorld(world);
        player = new CaveGamePlayer(handler, 448, 960, 64, 64, manager);
    }
       
    public Pokemon getPokemon()
    {
        return player.getPokemon();
    }
    
    public World getWorld()
    {
        return world;
    }
    
    public CaveGamePlayer getPlayer()
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