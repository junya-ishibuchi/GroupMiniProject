package Pieces;

import Potision.Position;

public class Bishop extends Piece{
    public Bishop(boolean isWhite, Position position) {
        super(isWhite, position);
    }

    @Override
    public boolean isValidMove(Position newPosition) {
        //todo Gabo
        return true;
    }
}
