package Pieces;

import Game.GameLogic;
import Potision.Position;

import java.awt.*;
import java.util.Objects;
import java.util.Scanner;

public class Pawn extends Piece{
    private boolean promotion;
    private Piece newPiece;
    private static final int VALUE = 1;

    public Pawn(boolean isWhite, Position position, boolean promotion) {
        super(VALUE, isWhite, position);
        this.promotion = promotion;
        this.newPiece = null;
    }

    // have to create this empty constructor
    public Pawn(boolean isWhite, Position position) {
        super(VALUE, isWhite, position);
    }

    public static String getUserInput(String prompt) {
        System.out.println(prompt);
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public void promoted() {
        while (true) {
            try{
                String userOptionInput = getUserInput(
                        "Select the desired Piece to promote your Pawn?\n"
                                + "'Q' -> Queen\n"
                                + "'R' -> Rook\n"
                                + "'B' -> Bishop\n"
                                + "'K' -> Knight"
                );

                if (userOptionInput == "Q" || userOptionInput == "q"){
                    this.newPiece =  new Queen(this.getIsWhite(), this.position);
                    break;
                }

                else if (userOptionInput == "R" || userOptionInput == "r"){
                    this.newPiece =  new Rook(this.getIsWhite(), this.position);
                    break;
                }

                else if (userOptionInput == "B" || userOptionInput == "b"){
                    this.newPiece =  new Bishop(this.getIsWhite(), this.position);
                    break;
                }

                else if (userOptionInput == "K" || userOptionInput == "k"){
                    this.newPiece =  new Knight(this.getIsWhite(), this.position);
                    break;
                }
            }
            catch (Exception e){
                System.out.println("Invalid Input! Choose a correct Piece.");
            }
        }
    }

    public Piece newPiece() {
        return newPiece;
    }

    @Override
    public String getPiece() {
        if (getIsWhite()) {
            return "♟";
        }
        return "♙";
    }

    // take a look at this method
    @Override
    public boolean move(Position newPosition, Piece[][] board) {
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

        int col = this.position.getCol();
        int row = this.position.getRow();
        int newCol = newPosition.getCol();
        int newRow = newPosition.getRow();
        Piece pawn = board[newRow][newCol];

        if (pawn != null) {
            if (pawn.getIsWhite() == this.getIsWhite()) {
                return false;
            }
        }
        if (pawn == null) {
            if (this.getIsWhite()) {
                // trying to implement en passant
                if(!getIsWhite()){
                    return
                            col == (newCol)  &&
                            ((row == newRow - 1) || (row == newRow + 1))
                            ;
                }else{
                    return
                            col == newCol &&
                            ((newRow == row - 1) ||
                            (row == 6 && newRow == row - 2))
                            ;
                }
            }
            else {
                return
                    col == newCol &&
                    ((newRow == row + 1) ||
                    (row == 1 && newRow == row + 2))
                ;
            }
        }
        else {
            if (this.getIsWhite()) {
                return newRow == row + 1;
            }
            else {
                return newRow == row - 1;
            }
        }
    }
}