package Pieces;

import Potision.Position;

public class Queen extends Piece{

    private static final int VALUE = 9;

    public Queen(boolean isWhite, Position position) {
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
            System.out.println("Invalid movement!");
            System.out.println("Queen only moves like bishop or rook");
            return false;
        }

    }

    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {

        if(!super.isValidMove(position, board)){
            return false;
        }

        if(
            Math.abs(newPosition.getCol() - this.position.getCol()) ==
            Math.abs(newPosition.getRow() - this.position.getRow())
        ) {
            int crossPosition = Math.abs(newPosition.getCol() - this.position.getCol()) - 1;
            if (
                newPosition.getRow() > this.position.getRow() &&
                newPosition.getCol() > this.position.getCol())
            {
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

        }else if(newPosition.getCol() == this.position.getCol()) {
            int minRow = 0;
            int maxRow = 0;
            if(newPosition.getRow() >= this.position.getRow()) {
                minRow = this.position.getRow();
                maxRow = newPosition.getRow();
            }else{
                minRow = newPosition.getRow();
                maxRow = this.position.getRow();
            }
            for(int r = minRow + 1; r < maxRow; r++) {
                if(board[r][this.position.getCol()] != null) {
                    return false;
                }
            }
            return true;

        }else if(newPosition.getRow() == this.position.getRow()){
            int minCol = 0;
            int maxCol = 0;
            if(newPosition.getCol() >= this.position.getCol()) {
                minCol = this.position.getCol();
                maxCol = newPosition.getCol();
            }else{
                minCol = newPosition.getCol();
                maxCol = this.position.getCol();
            }
            for(int c = minCol + 1; c < maxCol; c++) {
                if(board[this.position.getRow()][c] != null) {
                    return false;
                }
            }
            return true;

        }else{
            return false;
        }
    }
}
