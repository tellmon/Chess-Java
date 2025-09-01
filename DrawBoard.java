import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class DrawBoard extends JPanel{

	public int gridWidth = 100;
	public DrawBoard(int gridSize){
		this.setFocusable(true);
		gridWidth = gridSize;
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
					
				
				if ((row + col) % 2 == 0) // adds the number of rows and collours if even it sets it as red else its odd
					g2.setColor(Color.gray);
				else
					g2.setColor(new Color(17, 176, 9));
				
				g2.fillRect((col * gridWidth) + 5, (row * gridWidth) + 5, gridWidth - 5, gridWidth - 5);


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
