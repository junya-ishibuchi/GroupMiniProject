package Pieces;

import Potision.Position;

public class Bishop extends Piece{
    private static final int VALUE = 3;

    public Bishop(boolean isWhite, Position position) {
        super(VALUE, isWhite, position);
    }

    @Override
    public String getPiece() {
        if (getIsWhite()) {
            return "♗";
        }
        return "♝";
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
            System.out.println("Bishop moves only diagonally");
            return false;
        }
    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        //todo Gabo
        if(!super.isValidMove(position)){
            return false;
        }

        if(
                Math.abs(newPosition.getCol() - this.position.getCol()) ==
                        Math.abs(newPosition.getRow() - this.position.getRow()))
        {
            int crossPosition = Math.abs(newPosition.getCol() - this.position.getCol()) - 1;
            if(
                    newPosition.getRow() > this.position.getRow() &&
                            newPosition.getCol() > this.position.getCol()) {
                int r = this.position.getRow() + 1;
                int c = this.position.getCol() + 1;
                while(crossPosition > 0) {
                    if(board[r][c] != null) {
                        return false;
                    }
                    r += 1;
                    c += 1;
                    crossPosition -= 1;
                }
                return true;
            }
            else if(
                    newPosition.getRow() > this.position.getRow() &&
                            newPosition.getCol() <= this.position.getCol())
            {
                int r = this.position.getRow() + 1;
                int c = this.position.getCol() - 1;
                while(crossPosition > 0) {
                    if(board[r][c] != null) {
                        return false;
                    }
                    r += 1;
                    c -= 1;
                    crossPosition -= 1;
                }
                return true;
            }
            else if(
                    newPosition.getRow() <= this.position.getRow() &&
                            newPosition.getCol() > this.position.getCol())
            {
                int r = this.position.getRow() - 1;
                int c = this.position.getCol() + 1;
                while(crossPosition > 0) {
                    if(board[r][c] != null) {
                        return false;
                    }
                    r -= 1;
                    c += 1;
                    crossPosition -= 1;
                }
                return true;


            }else{
                int r = newPosition.getRow() + 1;
                int c = newPosition.getCol() + 1;
                while(crossPosition > 0) {
                    if(board[r][c] != null) {
                        return false;
                    }
                    r += 1;
                    c += 1;
                    crossPosition -= 1;
                }
                return true;
            }
        }else{
            return false;
        }

    }
}
