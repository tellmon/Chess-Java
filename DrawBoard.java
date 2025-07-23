import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class DrawBoard extends JPanel{

	public int gridWidth = 50;

	public DrawBoard(int gridSize){
		this.setFocusable(true);
		gridWidth = gridSize;
	}

	public void paintComponent (Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;

			drawBoards(g2, Control.pieces);
		}

    public void drawBoards(Graphics2D g2, Pieces[][] pieces){

		int row = 0;
		int colloum = 0;
		Color color = Color.pink;

		for (int x = 0; x <= 8; x++){
			for (int y = 0; y<= 8; y++){ // draw baord here


				color = (color.equals(Color.RED)) ? Color.BLUE : Color.RED;

				g2.setColor(color);
				g2.drawRect(row, colloum, gridWidth, gridWidth);


				colloum += gridWidth;
			}

			row += gridWidth;
            
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
