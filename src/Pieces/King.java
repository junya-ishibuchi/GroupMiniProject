package Pieces;

import Potision.Position;


public class King extends Piece{
    private static final int VALUE = 1000;

    public King(boolean isWhite, Position position) {
        super(VALUE, isWhite, position);
    }


    @Override
    public String getPiece() {
        if (getIsWhite()) {
            return "♔";
        }
        return "♚";
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
            System.out.println("King moves only one square in any direction");
            return false;
        }
    }


    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        //todo Gabo
        if(!super.isValidMove(position)){
            return false;
        }

        // check if the destination has already one friendly piece
        boolean friendlyPiece = getIsWhite();
        if (friendlyPiece == getIsWhite()) {
            return false;
        }

        if(
                (Math.abs(newPosition.getCol() - this.position.getCol()) <= 1) &&
                        (Math.abs(newPosition.getRow() - this.position.getRow()) <= 1)){
            return true;
        }

        return false;

    }

}