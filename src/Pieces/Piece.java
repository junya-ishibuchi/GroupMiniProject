package Pieces;

import Potision.Position;

public abstract class Piece {
    private boolean isWhite;
    protected Position position;

    public Piece(boolean isWhite, Position position) {
        this.isWhite = isWhite;
        this.position = position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean isValidMove(Position newPosition){
        if (newPosition.getRow() > 0 && newPosition.getCol() > 0
                && newPosition.getRow() < 8 && newPosition.getCol() < 8
        ) {
            return true;
        } else {
            return false;
        }
    }
}
