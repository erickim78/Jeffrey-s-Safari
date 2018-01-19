



public class Spence implements Pokemon
{
    private int mudCount, baitCount, catchrate, fleerate, attackrate, health;
    public String name;
    
    public Spence()
    {
        mudCount=0;
        baitCount=0;
        catchrate=90;
        fleerate=1;
        name = "SPENCE";
    }
    
    public void receiveMud()
    {
        mudCount++;
    }
    
    public void receiveBait()
    {
        baitCount++;
    }
    
    public boolean Pokeball()
    {
        catchrate = catchrate - (baitCount) + (mudCount);
        
        int ball = (int)(Math.random()*100+1);
        if(ball <= catchrate)
            return true;
        else
            return false;
            
    }
    
    public boolean flee()
    {
        fleerate = fleerate + (mudCount) - baitCount;
        
        int flee = (int)(Math.random()*100+1);
        if(flee <= fleerate)
            return true;
        return false;
    }
    
    public String getName()
    {
        return name;
    }
}