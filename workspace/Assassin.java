import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Assassin extends Piece{

    public Assassin(boolean isWhite, String img_file) {
        super(isWhite, img_file);
    }

    public String toString(){
        return "A " + super.toString() + " assassin" 
    }

     //This peice will never land on the King. It is a mystery where it will land next, so it controls no peices
    public ArrayList<Square> getControlledSquares(Square[][] board, Square start) { 
     return new ArrayList();
    }

    //Pre condition: must be opponant pieces that are not the king remaining on the board
    //Post condition: returns an array with the randomly generated opponant that the Assassin can target this turn
    public ArrayList<Square> getLegalMoves(Board b, Square start){
      ArrayList<Square> moves = new ArrayList<Square>();
      int sRow = start.getRow();
      int sCol = start.getCol();
      int col = (int)(Math.random()*8);
      int row = (int)(Math.random()*8);
        while(!b.getSquareArray()[row][col].isOccupied() || b.getSquareArray()[row][col].getOccupyingPiece().getColor() == b.getSquareArray()[sRow][sCol].getOccupyingPiece().getColor() || b.getSquareArray()[row][col].getOccupyingPiece() instanceof King){
          col = (int)(Math.random()*8);
          row = (int)(Math.random()*8);
        }
        moves.add(b.getSquareArray()[row][col]);
    	return moves;
    }
}
