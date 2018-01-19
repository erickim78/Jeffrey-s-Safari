


import Tiles.Tile;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity
{
    protected Handler handler;
    protected float x, y, xMove, yMove;
    protected int width, height;
    protected Rectangle bounds;
    
    public Entity(Handler handler, float x, float y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.handler = handler;
        
        bounds = new Rectangle(0,0,width,height);
    }
    
    public float getX()
    {
        return x;
    }
    
    public void setX(float num)
    {
        x = num;
    }
    
    public float getY()
    {
        return y;
    }
    
    public void setY(float num)
    {
        y = num;
    }
    
    public int getWidth()
    {
        return width;
    }
    
    public void setWidth(int num)
    {
        width = num;
    }
    
    public int getHeight()
    {
        return height;
    }
    
    public void setHeight(int num)
    {
        height = num;
    }
    
    public float getxMove()
    {
        return xMove;
    }
    
    public void setxMove(float num)
    {
        xMove = num;
    }
    
    public float getyMove()
    {
        return yMove;
    }
    
    public void setyMove(float num)
    {
        yMove = num;
    }
    
    public void move()
    {
        moveX();
        moveY();
        
    }
    
    //check to see if there are any obstacles
    
    public void moveX()
    {
        if(xMove > 0)
        {
            int tx = (int)(x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
            if(!collisionWithTile(tx,(int)(y+bounds.y)/ Tile.TILEHEIGHT)&&!collisionWithTile(tx,(int)(y+bounds.y+bounds.height)/Tile.TILEHEIGHT))
            {
                x += xMove;
                yMove = 0;
            }
        }
        else if(xMove < 0)
        {
            int tx = (int)(x + xMove + bounds.x) / Tile.TILEWIDTH;
            if(!collisionWithTile(tx,(int)(y+bounds.y)/ Tile.TILEHEIGHT)&&!collisionWithTile(tx,(int)(y+bounds.y+bounds.height)/Tile.TILEHEIGHT))
            {
                x += xMove;
                yMove = 0;
            }
        }
    }
    
    public void moveY()
    {
        if(yMove < 0)
        {
            int ty = (int)(y+yMove+bounds.y)/Tile.TILEHEIGHT;
            
            if(!collisionWithTile((int)(x+bounds.x)/Tile.TILEWIDTH,ty)&&!collisionWithTile((int)(x+bounds.x+bounds.width)/Tile.TILEWIDTH,ty))
            { 
                y += yMove;
                xMove = 0;
            }
        }
        else if(yMove > 0)
        {
            int ty = (int)(y+yMove+bounds.y + bounds.height)/Tile.TILEHEIGHT;
            if(!collisionWithTile((int)(x+bounds.x)/Tile.TILEWIDTH,ty)&&!collisionWithTile((int)(x+bounds.x+bounds.width)/Tile.TILEWIDTH,ty))
            {
                y += yMove;
                xMove = 0;
            }
        }
    }
    
    protected boolean collisionWithTile(int x, int y)
    {
        return handler.getWorld().getTile(x,y).isSolid();
    }
    
    public abstract void tick();
    
    public abstract void render(Graphics g);
}