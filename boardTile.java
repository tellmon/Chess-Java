import java.awt.Color;

public class boardTile {
    
    public int xPos = 0;
    public int yPos = 0;
    public String storedPiece = "";

    public Color squaresColor;

    public void setXPos(int x){
        xPos = x;
    }

    public void setYPos(int y){
        yPos = y;
    }

    public void setColour(Color color) {
        squaresColor = color;
    }

    public int getXPos(){
        return xPos;
    }

    public int getyPos(){
        return yPos;
    }

    public Color getColour(){
        return squaresColor;
    }



}
