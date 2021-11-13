package Pieces;

import Potision.Position;

import java.util.ArrayList;

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

    public void intoCastle(Position newPosition, Piece[][] board){
        if(newPosition.getRow() == 0 && newPosition.getCol() == 1) {
            board[this.position.getRow()][this.position.getCol()] = null;
            this.position = newPosition;
            board[newPosition.getRow()][newPosition.getCol()] = this;
            Piece rw1 = board[0][0];
            rw1.position = new Position(0, 2);
            board[0][0] = null;
            board[0][2] = rw1;
        } else if(newPosition.getRow() == 0 && newPosition.getCol() == 6) {
            board[this.position.getRow()][this.position.getCol()] = null;
            this.position = newPosition;
            board[newPosition.getRow()][newPosition.getCol()] = this;
            Piece rw2 = board[0][7];
            rw2.position = new Position(0, 5);
            board[0][7] = null;
            board[0][5] = rw2;
        } else if(newPosition.getRow() == 7 && newPosition.getCol() == 1) {
            board[this.position.getRow()][this.position.getCol()] = null;
            this.position = newPosition;
            board[newPosition.getRow()][newPosition.getCol()] = this;
            Piece rb1 = board[7][0];
            rb1.position = new Position(7, 2);
            board[7][0] = null;
            board[7][2] = rb1;
        } else if(newPosition.getRow() == 7 && newPosition.getCol() == 6) {
            board[this.position.getRow()][this.position.getCol()] = null;
            this.position = newPosition;
            board[newPosition.getRow()][newPosition.getCol()] = this;
            Piece rb2 = board[7][7];
            rb2.position = new Position(7, 5);
            board[7][7] = null;
            board[7][5] = rb2;
        }
    }


    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        //todo Gabo
        if(!super.isValidMove(position)){
            return false;
        }

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
