package Pieces;

import Potision.Position;

public class King extends Piece{

    private final static boolean kingWhiteMoved = false;
    private final static boolean kingBlackMoved = false;
    private final static boolean rowWhiteOne = false;
    private final static boolean rowWhiteTwo = false;
    private final static boolean rowBlackOne = false;
    private final static boolean rowBlackTwo = false;
    private static final int VALUE = 1000;

    public King(boolean isWhite, Position position) {
        super(VALUE, isWhite, position);
    }

    @Override
    public String getPiece() {
        if (getIsWhite()) {
            return "♔";
        }
        return "♚";
    }

    @Override
    boolean move(Position newPosition, Piece[][] board) {
        int newCol = newPosition.getCol();
        int newRow = newPosition.getRow();
        int col = this.position.getCol();
        int row = this.position.getRow();

        if (this.isValidMove(newPosition, board)) {
            board[row][col] = null;
            this.position = newPosition;
            board[newRow][newCol] = this;
            return true;
        } else {
            System.out.println("Invalid move!");
            System.out.println("King moves only one square in any direction");
            return false;
        }
    }

    public static Piece kingInCheck(boolean isWhite, Piece[][] board) {

        Piece King = null;

        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != null) {
                    if (board[i][j].getValue() == 1000 && board[i][j].getIsWhite() == isWhite) {
                        King = board[i][j];
                    }
                }
            }
        }

        return King;

    }

    public boolean castling(Position newPosition, Piece[][] board) {
        if (this.getIsWhite()) {

            if(
                !(newPosition.getRow() == 0 && newPosition.getCol() == 1) &&
                !(newPosition.getRow() == 0 && newPosition.getCol() == 6)
            ) {
                return false;
            }

            // need the list of all moves to implement kingInCheck method

            if(newPosition.getRow() == 0 && newPosition.getCol() == 1){
                if(
                        board[0][4].getValue() == 1000 && board[0][4].getIsWhite()
                        && board[0][0].getValue() == 5 && board[0][0].getIsWhite()
                )
                {
                    if(
                        board[0][1] != null || board[0][2] != null ||
                        board[0][3] != null
                    ) {
                        return false;
                    }
                    if(
                        this.getIsWhite() == board[0][1].getIsWhite() ||
                        this.getIsWhite() == board[0][2].getIsWhite() ||
                        this.getIsWhite() == board[0][3].getIsWhite()
                    ){
                        return false;
                    }
                    if(kingWhiteMoved || rowWhiteOne) {
                        return false;
                    }
                }else{
                    return false;
                }
            }

            if(newPosition.getRow() == 0 && newPosition.getCol() == 6){
                if(
                        board[0][4].getValue() == 1000 && board[0][4].getIsWhite()
                        && board[0][7].getValue() == 5 && board[0][7].getIsWhite()
                )
                {
                    if(
                        board[0][5] != null ||
                        board[0][6] != null
                    ) {
                        return false;
                    }
                    if(
                        this.getIsWhite() == board[0][5].getIsWhite() ||
                        this.getIsWhite() == board[0][6].getIsWhite()
                    ){
                        return false;
                    }
                    if(kingWhiteMoved || rowWhiteTwo) {
                        return false;
                    }
                }else{
                    return false;
                }
            }
            return true;
        }
        else{
            if(
                !(newPosition.getRow() == 7 && newPosition.getCol() == 1) &&
                !(newPosition.getRow() == 7 && newPosition.getCol() == 6)
            ) {
                return false;
            }

            // need the list of all moves to implement kingInCheck method

            if(
                newPosition.getRow() == 7 &&
                newPosition.getCol() == 1
            ){
                if(
                    board[7][4].getValue() == 1000 && !board[7][4].getIsWhite()
                    && board[7][0].getValue() == 5 && !board[7][0].getIsWhite()
                ){

                    if(board[7][1] != null || board[7][2] != null || board[7][3] != null) {
                        return false;
                    }
                    if(
                        this.getIsWhite() == board[7][1].getIsWhite() ||
                        this.getIsWhite() == board[7][2].getIsWhite() ||
                        this.getIsWhite() == board[7][3].getIsWhite()
                    ){
                        return false;
                    }
                    if(kingBlackMoved || rowBlackOne) {
                        return false;
                    }
                }else{
                    return false;
                }
            }

            if(newPosition.getRow() == 7 && newPosition.getCol() == 6){
                if(
                    board[7][4].getValue() == 1000 && !board[7][4].getIsWhite()
                    && board[7][7].getValue() == 5 && !board[7][7].getIsWhite()
                ){
                    if(
                        board[7][5] != null ||
                        board[7][6] != null
                    ) {
                        return false;
                    }
                    if(
                        this.getIsWhite() == board[7][5].getIsWhite() ||
                        this.getIsWhite() == board[7][6].getIsWhite()
                    ){
                        return false;
                    }
                    if(kingBlackMoved || rowBlackTwo) {
                        return false;
                    }
                }else{
                    return false;
                }
            }
            return true;
        }
    }

    public void intoCastle(Position newPosition, Piece[][] board){
        if(newPosition.getRow() == 0 && newPosition.getCol() == 1) {
            board[this.position.getRow()][this.position.getCol()] = null;
            this.position = newPosition;
            board[newPosition.getRow()][newPosition.getCol()] = this;
            Piece rowWhiteOne = board[0][0];
            rowWhiteOne.position = new Position(0, 2);
            board[0][0] = null;
            board[0][2] = rowWhiteOne;
        } else if(newPosition.getRow() == 0 && newPosition.getCol() == 6) {
            board[this.position.getRow()][this.position.getCol()] = null;
            this.position = newPosition;
            board[newPosition.getRow()][newPosition.getCol()] = this;
            Piece rowWhiteTwo = board[0][7];
            rowWhiteTwo.position = new Position(0, 5);
            board[0][7] = null;
            board[0][5] = rowWhiteTwo;
        } else if(newPosition.getRow() == 7 && newPosition.getCol() == 1) {
            board[this.position.getRow()][this.position.getCol()] = null;
            this.position = newPosition;
            board[newPosition.getRow()][newPosition.getCol()] = this;
            Piece rowBackOne = board[7][0];
            rowBackOne.position = new Position(7, 2);
            board[7][0] = null;
            board[7][2] = rowBackOne;
        } else if(newPosition.getRow() == 7 && newPosition.getCol() == 6) {
            board[this.position.getRow()][this.position.getCol()] = null;
            this.position = newPosition;
            board[newPosition.getRow()][newPosition.getCol()] = this;
            Piece rowBackTwo = board[7][7];
            rowBackTwo.position = new Position(7, 5);
            board[7][7] = null;
            board[7][5] = rowBackTwo;
        }
    }


    @Override
    public boolean isValidMove(Position newPosition, Piece[][] board) {
        //todo Gabo
        if(!super.isValidMove(position)){
            return false;
        }

        boolean friendlyPiece = getIsWhite();
        if (friendlyPiece == getIsWhite()) {
            return false;
        }

        if(
            (Math.abs(newPosition.getCol() - this.position.getCol()) <= 1) &&
            (Math.abs(newPosition.getRow() - this.position.getRow()) <= 1)){
            return true;
        }

        return false;

    }

}
