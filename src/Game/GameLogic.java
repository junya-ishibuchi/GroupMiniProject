package Game;

import Pieces.*;
import Potision.Position;
import Potision.Uci;

import java.util.HashMap;
import java.util.Scanner;

public class GameLogic {
    private final Piece[][] board;
    private final Scanner scanner;
    private final Uci uci;
    private boolean isGameOver;
    private boolean whiteTurn;

    public GameLogic() {
        this.scanner = new Scanner(System.in);
        this.board = new Piece[8][8];
        this.uci = new Uci(8);
        this.isGameOver = false;
        this.init();
    }

    private void init() {
        for (int i = 0; i < this.board.length; i++) {
            Piece[] row = this.board[i];

            if (i == 1 || i == 6) {
                boolean isWhite = i == 6;
                for (int j = 0; j < row.length; j++) {
                    this.board[i][j] = new Pawn(isWhite, new Position(i, j));
                }
            }

            if (i == 0 || i == 7) {
                boolean isWhite = i == 7;
                this.board[i][0] = new Rook(isWhite, new Position(i, 0));
                this.board[i][1] = new Knight(isWhite, new Position(i, 1));
                this.board[i][2] = new Bishop(isWhite, new Position(i, 2));
                this.board[i][3] = new Queen(isWhite, new Position(i, 3));
                this.board[i][4] = new King(isWhite, new Position(i, 4));
                this.board[i][5] = new Bishop(isWhite, new Position(i, 5));
                this.board[i][6] = new Knight(isWhite, new Position(i, 6));
                this.board[i][7] = new Rook(isWhite, new Position(i, 7));
            }
        }
    }

    public void start() {
        printBoard();
        while (!isGameOver) {
            String userInput = askWannaDo();

            if (userInput.equals("help")) {
                printHelp();
            } else if (userInput.equals("board")) {
                printBoard();
            } else if (userInput.equals("resign")) {
                //TODO:
            } else if (userInput.equals("moves")) {
                printPossibleMove();
            } else if (userInput.length() == 2 && uci.validate(userInput)) {
                printPossibleMove(userInput);
            } else if (userInput.length() == 4 && uci.validate(userInput.substring(0, 2)) && uci.validate(userInput.substring(2, 4))) {
                move(userInput);
            } else {
                printInvalidInput();
            }
            whiteTurn = !whiteTurn;
        }
    }

    private Piece[][] printBoard() {
        //TODO:

        for (int row = 7; row >= 0; row--) {
            for (int column = 0; column < board[row].length; column++) {
                Piece p = null;
                if (row == 0) {
                    if (column == 0 || column == 7) {
                        p = new Rook(true, new Position(column, row));
                    } else if (column == 1 || column == 6) {
                        p = new Knight(true, new Position(column, row));
                    } else if (column == 2 || column == 5) {
                        p = new Bishop(true, new Position(column, row));
                    } else if (column == 4) {
                        p = new Queen(true, new Position(column, row));
                    } else if (column == 3) {
                        p = new King(true, new Position(column, row));
                    }
                } else if (row == 1) {
                    p = new Pawn(true, new Position(column, row));
                } else if (row == 6) {
                    p = new Pawn(false, new Position(column, row));
                } else if (row == 7) {
                    if (column == 0 || column == 7) {
                        p = new Rook(false, new Position(column, row));
                    } else if (column == 1 || column == 6) {
                        p = new Knight(false, new Position(column, row));
                    } else if (column == 2 || column == 5) {
                        p = new Bishop(false, new Position(column, row));
                    } else if (column == 4) {
                        p = new Queen(false, new Position(column, row));
                    } else if (column == 3) {
                        p = new King(false, new Position(column, row));
                    }
                }
                board[row][column] = p;
                return board;
            }
        }

        return new Piece[0][];
    }

    private String askWannaDo() {
        System.out.println();
        System.out.print("Enter UCI (type 'help' for help): ");
        return scanner.next();
    }

    private void printTurn() {
        String userInput = askWannaDo();
        if (userInput.equals("Turn")) {
            System.out.println(whiteTurn ? "White" : "Black" + " to move");
        }
    }

    private void printHelp() {
        //TODO:
    }

    private void printPossibleMove() {
        //todo: sena
        for (int row = 7; row >= 0; row--) {
            for (int column = 0; column < board[row].length; column++) {
                Piece piece = board[row][column];
                if (piece !=null && piece.getIsWhite() == whiteTurn)
                    printPossibleMove(piece.getPiece());
            }
        }
        // You can use printPossibleMove method. Check the entire board with a loop statement.
    }

    private Integer printPossibleMove(String from) {
        //todo: sena
        HashMap<String, Integer> convertToNum = new HashMap<>();
        convertToNum.put("a", 0);
        convertToNum.put("b", 1);
        convertToNum.put("c", 2);
        convertToNum.put("d", 3);
        convertToNum.put("e", 4);
        convertToNum.put("f", 5);
        convertToNum.put("g", 6);
        convertToNum.put("h", 7);

        return convertToNum.get(from);

    }

    private void move(String uci) {
        //todo: sena
        for (int r = 7; r>= 0; r--) {
            for (int c = 0; c <= 7; c++) {
                Position from = this.uci.getPositionFromUci(uci.substring(r,c));

            }

        }


        Position to = this.uci.getPositionFromUci(uci.substring(2,4));

        //like this
//        Position from = this.uci.getPositionFromUci(uci.substring(0, 2));
//        Position to = this.uci.getPositionFromUci(uci.substring(2, 4));
//
//        Piece targetPiece = board[from.getRow()][from.getCol()];
//        // Gabo, LOOK AT THE CONDITION.
//        if (targetPiece.isValidMove(to)) {
//            board[to.getRow()][to.getCol()] = targetPiece;
//            targetPiece.setPosition(to);
//        } else {
//            System.out.println("Invalid move");
//        }
        // You have to consider about white turn or not... plz write the code.
        // You have to consider about whether the pawn can take the enemy's piece or not... plz write the code.
    }

    private void printInvalidInput() {
        System.out.println("Invalid input, please try again");
    }

    private boolean isGameOver() {
        //TODO:
        return false;
    }

}
