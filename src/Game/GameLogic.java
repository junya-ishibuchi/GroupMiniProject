package Game;

import Pieces.*;
import Potision.Position;
import Potision.Uci;

import java.util.Scanner;

public class GameLogic {
    private Piece[][] board;
    private Scanner scanner;
    private Uci uci;
    private boolean isGameOver;
    private boolean whiteTurn;

    public GameLogic() {
        Scanner scanner = new Scanner(System.in);
        this.board = new Piece[8][8];
        Uci uci = new Uci(8);
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

    private void printBoard() {
        //TODO:
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
    }

    private void printPossibleMove() {
        //todo: sena
    }

    private void printPossibleMove(String from) {
        //todo: sena
        //from is suppose to be "a4" or "b7". length = 2.
    }

    private void move(String uci) {
        //todo: sena
        //like this
//        Position from = this.uci.getPositionFromUci(uci.substring(0, 2));
//        Position to = this.uci.getPositionFromUci(uci.substring(2, 4));
    }

    private void printInvalidInput() {
        System.out.println("Invalid input, please try again");
    }

    private boolean isGameOver() {
        //TODO:
        return false;
    }

}
