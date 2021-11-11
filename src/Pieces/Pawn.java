package Pieces;

import Potision.Position;

import java.util.Objects;
import java.util.Scanner;

public class Pawn extends Piece{
    private boolean promotion;
    private Piece newPiece;
    private static final int VALUE = 1;
    private Object InputCollector;

    public Pawn(boolean isWhite, Position position) {
        super(VALUE, isWhite, position);
    }

    protected static String getUserInput(String prompt) {
        System.out.println(prompt);
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    @Override
    public String getPiece() {
        if (getIsWhite()) {
            return "♙";
        }
        return "♟";
    }

    // take a look at this method
    @Override
    boolean move(Position newPosition, Piece[][] board) {
        int newCol = newPosition.getCol();
        int newRow = newPosition.getRow();
        int col = this.position.getCol();
        int row = this.position.getRow();

        if (isValidMove(newPosition, board)) {
            board[row][col] = null;
            this.position = newPosition;
            board[newRow][newCol] = this;
            return true;
        } else {
            System.out.println("Invalid move!");
            System.out.println("Pawn moves only forward by 1");
            return false;
        }
    }


    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {

        final int moveOne = 1;
        final int moveTwo = 2;

        int newCol = newPosition.getCol();
        int newRow = newPosition.getRow();
        int col = this.position.getCol();
        int row = this.position.getRow();
        Piece p = board[newRow][newCol];

        if (p != null) {
            if (p.getIsWhite() == this.getIsWhite()) {
                return false;
            }
        }

        if (p == null) {
            if (this.getIsWhite()) {
                if (col == newCol && ((newRow == row + moveOne) || (row == 1 && newRow == row + moveTwo)))
                {
                    return true;
                }
            }
            else {
                if (col == newCol && ((newRow == row - moveOne) || (row == 6 && newRow == row - moveTwo)))
                {
                    return true;
                }
            }
        }
        else {

            boolean b = (newCol == col + moveOne) || (newCol == col - moveOne);
            if (this.getIsWhite()) {
                if (newRow == row + moveOne && b) {
                    return true;
                }
            }
            else {
                if (newRow == row - moveOne && b) {
                    return true;
                }
            }

        }
        return false;
    }
}
