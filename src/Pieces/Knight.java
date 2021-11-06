package Pieces;

import Potision.Position;

public class Knight extends Piece{
    public Knight(boolean isWhite, Position position) {
        super(isWhite, position);
    }

    @Override
    public boolean isValidMove(Position newPosition) {
        //todo Gabo
        return true;
    }
}
