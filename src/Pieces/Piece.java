package Pieces;

import Potision.Position;

public abstract class Piece {

    private int value;
    private boolean isWhite;
    protected Position position;

    public Piece(int value, boolean isWhite, Position position) {
        this.value = value;
        this.isWhite = isWhite;
        this.position = position;
    }

    // have to create this empty constructor
    public Piece() {

    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean getIsWhite() {
        return isWhite;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public abstract String getPiece();

    public abstract boolean move(Position newPosition, Piece[][] board);

    public boolean isValidMove(Position newPosition, Piece[][] board){
        if (newPosition.getRow() >= 0 && newPosition.getCol() >= 0
                && newPosition.getRow() < 8 && newPosition.getCol() < 8
        ) {
            return true;
        } else {
            return false;
        }
    }
}
