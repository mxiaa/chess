
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

//you will need to implement two functions in this file.
public class Piece {
    private final boolean color;
    private BufferedImage img;
    
    public Piece(boolean isWhite, String img_file) {
        this.color = isWhite;
        
        try {
            if (this.img == null) {
              this.img = ImageIO.read(getClass().getResource(img_file));
            }
          } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
          }
    }
    
    

    
    public boolean getColor() {
        return color;
    }
    
    public Image getImage() {
        return img;
    }
    
    public void draw(Graphics g, Square currentSquare) {
        int x = currentSquare.getX();
        int y = currentSquare.getY();
        
        g.drawImage(this.img, x, y, null);
    }
    
    
    // TO BE IMPLEMENTED!
    //return a list of every square that is "controlled" by this piece. A square is controlled
    //if the piece capture into it legally.
    public ArrayList<Square> getControlledSquares(Square[][] board, Square start) {
      //This peice will never land on the King. It is a mistery where it will land next, so it controls no peices
     return new ArrayList();
    }
    

    //TO BE IMPLEMENTED!
    //implement the move function here
    //it's up to you how the piece moves, but at the very least the rules should be logical and it should never move off the board!
    //returns an arraylist of squares which are legal to move to
    //please note that your piece must have some sort of logic. Just being able to move to every square on the board is not
    //going to score any points.
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