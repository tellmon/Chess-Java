import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

public abstract class Pieces {
    
    public int xPos = 0, yPos = 0;
    public Color colour = Color.BLUE; 
    public boolean taken = false;

    protected Area base;
        
    public void setColour(Color side){
        colour = side;
    }

    public void setXPos(int x){
        xPos = x;
    }
    
    public void setYPos(int y){
        yPos = y;
    }

    public boolean getTaken(){
        return taken;
    }

      public Area getShape() {
        return base;
    }

    public int getXPos(){
        return xPos;
    }
    
    public int getYPos(){
        return yPos;
    }

    public void drawSelf(Graphics2D g2, int gridSize){

        // it will draw a rectangle and pieces will cut out of it what they need

        double size = gridSize * 0.75;
        double offset = (gridSize - size) / 2;

        base = new Area(new Rectangle2D.Double(xPos * gridSize + offset, yPos * gridSize + offset, size, size));

        customizeShape();

        g2.setColor(colour);
        g2.fill(base);
    }

     protected void customizeShape() {
    }

}
