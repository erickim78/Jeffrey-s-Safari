



public class David implements Pokemon
{
    private int mudCount, baitCount, catchrate, fleerate, attackrate, health;
    public String name;
    
    public David()
    {
        mudCount=0;
        baitCount=0;
        catchrate=65;
        fleerate=3;
        name = "DAVEED";
        
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
        catchrate = catchrate - (2*baitCount ) + (mudCount);
        
        int ball = (int)(Math.random()*100+1);
        if(ball <= catchrate)
            return true;
        else
            return false;
            
    }
    
    public boolean flee()
    {
        fleerate = fleerate + (2*mudCount) - baitCount;
        
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