package Pieces;

import Potision.Position;

public class King extends Piece{
    public King(boolean isWhite, Position position) {
        super(isWhite, position);
    }

    @Override
    public boolean isValidMove(Position newPosition) {
        //todo Gabo
        return true;
    }
}
