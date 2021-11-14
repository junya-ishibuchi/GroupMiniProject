package Game;

import Pieces.*;
import Potision.Position;
import Potision.Uci;

import java.util.Scanner;

public class GameLogic{
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
                printResign();
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

    private void printResign(){
        int winCount = 0;
        int loseCount = 0;
        if (whiteTurn) {
            winCount++;
            System.out.println(
                "Game over - " +
                winCount + " - " + loseCount +
                "White resigned. Black won by resignation"
            );
        } else {
            winCount++;
            System.out.println(
                "Game over - " +
                loseCount + " - " + winCount +
                "Black resigned. White won by resignation"
            );
        }
        System.exit(0);
    }

    private void printBoard() {
        //TODO:
        final String empty = ". ";
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j] + " ");
                } else {
                    System.out.print(empty);
                }
                if (j == 7) {
                    System.out.print(" " + (i + 1));
                }
            }
            System.out.println();
        }
        System.out.println("\na b c d e f g h\n");
    }

    private String askWannaDo() {
        System.out.println();
        System.out.print("Enter UCI (type 'help' for help): ");
        return scanner.next();
    }

    private void printTurn() {
        System.out.println(whiteTurn ? "White" : "Black" + " to move");
    }

    private void printHelp() {
        //TODO:
        System.out.println(
            "* type 'help' for help\n" +
            "* type 'board' to see the board again\n " +
            "* type 'resign' to resign\n" +
            "* type 'moves' to list all possible moves\n" +
            "* type a square (e.g. b1, e2) to list possible moves for that square\n" +
            "* type UCI (e.g. b1c3, e7e8) to make a move"
        );
    }

    private void printPossibleMove() {
        //todo: sena

        // You can use printPossibleMove method. Check the entire board with a loop statement.
    }

    private void printPossibleMove(String from) {
        //todo: sena
        //from is suppose to be "a4" or "b7". length = 2.

        // You may use a loop statement like for. And find out where you can go and make the string.
    }

    private void move(String uci) {
        //todo: sena
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
//            System.out.println

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
