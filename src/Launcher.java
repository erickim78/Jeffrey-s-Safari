

public class Launcher
{
    public static void main(String [] args)
    {
        Game game = new Game("Jeffrey's Safari",720,420);
        game.start();
        OpeningScreen open = new OpeningScreen();
    }
}