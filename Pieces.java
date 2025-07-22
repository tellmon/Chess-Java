import java.awt.Color;

public abstract class Pieces {
    
    public int xPos = 0, yPos = 0;
    public Color colour = Color.BLUE; // easy to id errors on colour selector. 
    
    public void setColour(Color side){
        colour = side;
    }

    public void setXPos(int x){
        xPos = x;
    }
    
    public void setYPos(int y){
        yPos = y;
    }
}
