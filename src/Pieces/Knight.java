package Pieces;

import Potision.Position;

public class Knight extends Piece{
    private static final int VALUE = 3;

    public Knight(boolean isWhite, Position position) {
        super(VALUE, isWhite, position);
    }

    @Override
    public String getPiece() {
        if (getIsWhite()) {
            return "♘";
        }
        return "♞";
    }

    @Override
    boolean move(Position newPosition, Piece[][] board) {
        int newCol = newPosition.getCol();
        int newRow = newPosition.getRow();
        int col = this.position.getCol();
        int row = this.position.getRow();

        if (this.isValidMove(newPosition, board)) {
            board[row][col] = null;
            this.position = newPosition;
            board[newRow][newCol] = this;
            return true;
        } else {
            System.out.println("Invalid move!");
            System.out.println("Knight only moves Like an L");
            return false;
        }
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        //todo Gabo
        if(!super.isValidMove(position, board)){
            return false;
        }
        if(
                ((Math.abs(newPosition.getCol() - this.position.getCol()) == 1) &&
                        (Math.abs(newPosition.getRow() - this.position.getRow()) == 2)) ||
                        ((Math.abs(newPosition.getRow() - this.position.getRow()) == 1) &&
                                (Math.abs(newPosition.getCol() - this.position.getCol()) == 2)))
        {
            return true;
        }
        else{
            return false;
        }
    }
}