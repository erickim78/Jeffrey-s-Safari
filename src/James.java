




public class James implements Pokemon
{
    private int mudCount, baitCount, catchrate, fleerate, attackrate, health;
    public String name;
    
    public James()
    {
        mudCount=0;
        baitCount=0;
        catchrate=45;
        fleerate=5;
        name = "JARAMBE";
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
        catchrate = catchrate - (3*baitCount ) + (mudCount);
        
        int ball = (int)(Math.random()*100+1);
        if(ball <= catchrate)
            return true;
        else
            return false;
            
    }
    
    public boolean flee()
    {
        fleerate = fleerate + (3*mudCount) - baitCount;
        
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
