package Pieces;

import Potision.Position;

public class Pawn extends Piece{
    public Pawn(boolean isWhite, Position position) {
        super(isWhite, position);
    }

    @Override
    public boolean isValidMove(Position newPosition) {
        //todo Gabo
        return true;
    }
}
