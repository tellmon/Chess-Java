import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class DrawBoard extends JPanel{

	public boardTile[][] squares = new boardTile[8][8];

	public int gridWidth = 100;

	public boolean changeGridColour = true;

	public DrawBoard(int gridSize){
		this.setFocusable(true);
		gridWidth = gridSize;

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				squares[row][col] = new boardTile();			}
		}
	}

	public Dimension getPreferredSize() {
    	return new Dimension(gridWidth * 8, gridWidth * 8);
	}

	public void paintComponent (Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;

			drawBoards(g2, Control.pieces);
		}

    public void drawBoards(Graphics2D g2, Pieces[][] pieces){


		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {

				g2.setColor(Color.black);
				g2.fillRect(col * gridWidth, row * gridWidth, gridWidth, gridWidth);

				squares[row][col].setXPos(row);
				squares[row][col].setYPos(col);

				if (changeGridColour){ // adds the number of rows and collours if even it sets it as grey else its odd
					squares[row][col].setColour(Color.gray);
					changeGridColour = false;
				}

				else{
					squares[row][col].setColour(new Color(100, 100, 250));
					changeGridColour = true;
				}
				
			}

			changeGridColour = !changeGridColour;
		}

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				g2.setColor(squares[row][col].getColour());
				g2.fillRect(squares[row][col].getXPos() * gridWidth + 5, squares[row][col].getyPos() * gridWidth + 5, gridWidth -5, gridWidth -5);
			}
		}


		// draws each piece
		for (int i = 0; i < 4; i++) {

            if(!pieces[PieceConstants.ROOK][i].getTaken()){
                pieces[PieceConstants.ROOK][i].drawSelf(g2, gridWidth);
            }
			
            if(!pieces[PieceConstants.BISHOP][i].getTaken()){
                pieces[PieceConstants.BISHOP][i].drawSelf(g2, gridWidth);
            }

            if(!pieces[PieceConstants.KNIGHT][i].getTaken()){
                pieces[PieceConstants.KNIGHT][i].drawSelf(g2, gridWidth);
            }
		}

		for (int i = 0; i < 2; i++) {

            if(!pieces[PieceConstants.QUEEN][i].getTaken()){
                pieces[PieceConstants.QUEEN][i].drawSelf(g2, gridWidth);
            }

            if(!pieces[PieceConstants.KING][i].getTaken()){
                pieces[PieceConstants.KING][i].drawSelf(g2, gridWidth);
            }


		}
		for (int i = 0; i < 16; i++) {
            
            if(!pieces[PieceConstants.PAWN][i].getTaken()){
                pieces[PieceConstants.PAWN][i].drawSelf(g2, gridWidth);
            }
		}
	}
}
