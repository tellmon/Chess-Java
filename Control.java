import javax.swing.JFrame;

public class Control {
    
    public static Pieces[][] pieces = new Pieces[6][];

    public Control(String file,int gridSize){
        BuildChessBoard buildChessBoard = new BuildChessBoard();
        pieces = buildChessBoard.importChessBoardAndSetPieces(file);

        DrawBoard drawBoard = new DrawBoard(gridSize);

        JFrame frame = new JFrame();
		frame.setContentPane(drawBoard);
		frame.setTitle("Chess");
		frame.setSize(gridSize*8, gridSize*8);
		frame.setVisible(true);
        frame.setResizable(false);
    }
}
