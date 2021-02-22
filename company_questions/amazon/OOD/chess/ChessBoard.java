package company_questions.amazon.OOD.chess;



//use case:
//ChessBoard
//    attributes: Pieces[][] board

//Pieces (abstract class)
//King,Queen,Rooks,Knights,Pawns

public class ChessBoard {

}

abstract class Pieces{
    private boolean isWhite;
    private boolean isAlive;

    public abstract boolean canMove(ChessBoard board, int i, int j);
    public abstract void move(ChessBoard board, int i, int j);
}
