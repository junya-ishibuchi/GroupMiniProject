package Pieces;

import Potision.Position;

public class Rook extends Piece{
    public Rook(boolean isWhite, Position position) {
        super(isWhite, position);
    }

    @Override
    public boolean isValidMove(Position newPosition) {
        //todo Gabo
        return true;
    }
}
