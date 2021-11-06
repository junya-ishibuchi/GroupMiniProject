package Pieces;

import Potision.Position;

public class Queen extends Piece{
    public Queen(boolean isWhite, Position position) {
        super(isWhite, position);
    }

    @Override
    public boolean isValidMove(Position newPosition) {
        //todo Gabo
        return true;
    }
}
