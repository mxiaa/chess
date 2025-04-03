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
public class Servant extends Piece{
public Servant(boolean isWhite, String img_file) {
super(isWhite, img_file);
}
public String toString(){
    return "A " + super.toString() + " servant" ;
}
// TO BE IMPLEMENTED!
//return a list of every square that is "controlled" by this piece. A square is
//controlled
//if the piece capture into it legally.
public ArrayList<Square> getControlledSquares(Square[][] board, Square start) {
ArrayList<Square> control = new ArrayList<Square>();
if((start.getRow() + start.getCol()) % 2 == 0)
{
//white
if(start.getCol()+1<8){
control.add(board[start.getRow()][start.getCol()+1]);
}
if(start.getCol()>0){
control.add(board[start.getRow()][start.getCol()-1]);
}
}
else{
if(start.getRow()+1<8){
control.add(board[start.getRow()+1][start.getCol()]);
}
if(start.getCol()>0){
control.add(board[start.getRow()-1][start.getCol()]);
}
}
if(control.size()>0){
return control;
}
else{
return null;
}
}
//TO BE IMPLEMENTED!
//implement the move function here
//it's up to you how the piece moves, but at the very least the rules should be
//logical and it should never move off the board!
//returns an arraylist of squares which are legal to move to
//please note that your piece must have some sort of logic. Just being able to
//move to every square on the board is not
//going to score any points.
//This piece will move differently if it is on a black square or a white
//square.
//if its on a black square it will be able to move forward or backwards one
//square and capture in those squares
//if its on a white square it will be able to move left or right one sqaure and
//can capture in those squares.
public ArrayList<Square> getLegalMoves(Board b, Square start){
ArrayList<Square> moves = new ArrayList<Square>();
if((start.getRow() + start.getCol()) % 2 == 0)
{
//white
if(start.getCol()+1<8){
if(b.getSquareArray()[start.getRow()][start.getCol()+1].isOccupied()){
if(b.getSquareArray()[start.getRow()][start.getCol()
+1].getOccupyingPiece().getColor() != b.getSquareArray()[start.getRow()][start.getCol()].getOccupyingPiece().getColor()){
moves.add(b.getSquareArray()[start.getRow()][start.getCol()+1]);
}
}
else{
moves.add(b.getSquareArray()[start.getRow()][start.getCol()+1]);
}
}
if(start.getCol()>0){
if(b.getSquareArray()[start.getRow()][start.getCol()-1].isOccupied()){
if(b.getSquareArray()[start.getRow()][start.getCol()-
1].getOccupyingPiece().getColor() != b.getSquareArray()[start.getRow()][start.getCol()].getOccupyingPiece().getColor()){
moves.add(b.getSquareArray()[start.getRow()][start.getCol()-1]);
}
}
else{
moves.add(b.getSquareArray()[start.getRow()][start.getCol()-1]);
}
}
}
else{
if(start.getRow()+1<8){
if(b.getSquareArray()[start.getRow()+1][start.getCol()].isOccupied()){
if(b.getSquareArray()[start.getRow()+1]
[start.getCol()].getOccupyingPiece().getColor() != b.getSquareArray()[start.getRow()][start.getCol()].getOccupyingPiece().getColor()){
moves.add(b.getSquareArray()[start.getRow()+1][start.getCol()]);
}
}
else{
moves.add(b.getSquareArray()[start.getRow()+1][start.getCol()]);
}
}
if(start.getRow()>0){
if(b.getSquareArray()[start.getRow()-1][start.getCol()].isOccupied()){
if(b.getSquareArray()[start.getRow()-1]
[start.getCol()].getOccupyingPiece().getColor() != b.getSquareArray()[start.getRow()][start.getCol()].getOccupyingPiece().getColor()){
moves.add(b.getSquareArray()[start.getRow()-1][start.getCol()]);
}
}
else{
moves.add(b.getSquareArray()[start.getRow()-1][start.getCol()]);
}
}
}
if(moves.size()>0){
return moves;
}
else{
return null;
}
}
}