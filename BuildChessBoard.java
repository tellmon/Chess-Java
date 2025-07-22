import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BuildChessBoard {
    
    char[][] board;

	private static final String PIECE_CHARS = "rbnqkp"; // rook, bishop, knight, queen, king, pawn 
    private Pieces[][] pieces = new Pieces[6][];  // six groups of null so you can have as many of each as you want

	public BuildChessBoard(){

		pieces[PieceConstants.ROOK] = new Pieces[4];
		pieces[PieceConstants.BISHOP] = new Pieces[4];
		pieces[PieceConstants.KNIGHT] = new Pieces[4];
		pieces[PieceConstants.QUEEN] = new Pieces[2];
		pieces[PieceConstants.KING] = new Pieces[2];
		pieces[PieceConstants.PAWN] = new Pieces[16];

		for (int i = 0; i < 4; i++) {
			pieces[PieceConstants.ROOK][i] = new Rook();
			pieces[PieceConstants.BISHOP][i] = new Bishop();
			pieces[PieceConstants.KNIGHT][i] = new Knight();
		}
		for (int i = 0; i < 2; i++) {
			pieces[PieceConstants.QUEEN][i] = new Queen();
			pieces[PieceConstants.KING][i] = new King();
		}
		for (int i = 0; i < 16; i++) {
			pieces[PieceConstants.PAWN][i] = new Pawn();
		}


	}

    public Pieces[][] importChessBoard(String file){
        try {
			//count rows and coloums
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			int rows = 0;
			int columns = line.length();
			while (line != null) {
				line = reader.readLine();
				rows++;
			}
			
			board = new char [columns][rows];

            reader = new BufferedReader(new FileReader(file));
		
			
			for (int y = 0; y < rows; y++) {
				String row = reader.readLine();
				for (int x = 0; x < row.length(); x++) {
					board[x][y] = row.charAt(x);
				}
			}
			reader.close();

			for (int type = 0; type < PIECE_CHARS.length(); type++) {
				char pieceChar = PIECE_CHARS.charAt(type);
				int count = 0;

				for (int boardy = 0; boardy < board[0].length; boardy++) {
					for (int boardx = 0; boardx < board.length; boardx++) {
						char c = board[boardx][boardy];

						if (c == pieceChar || c == Character.toUpperCase(pieceChar)) {
							Pieces p = pieces[type][count++];
							p.setXPos(boardx);
							p.setYPos(boardy);
							p.setColour(Character.isUpperCase(c) ? Color.white : Color.black);
						}
					}
				}
			}
        }
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}

        return pieces;
    }
}

