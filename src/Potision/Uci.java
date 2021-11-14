package Potision;

public class Uci {
    final int ALPHABET_A_NUM = 97;
    private int size;

    public Uci(int size) {
        this.size = size;
    }

    public boolean validate(String uci) {
        if (uci.length() > 2) {
            return false;
        }
        int[] rowCol = convertToNum(uci);

        return rowCol[0] >= 0 && rowCol[1] >=0 && rowCol[0] < size && rowCol[1] < size;
    }

    public Position getPositionFromUci(String uci) {
        int[] rowCol = convertToNum(uci);
        return new Position(rowCol[0], rowCol[1]);
    }

    public String convertToUci(Position position) {
        return (char)(ALPHABET_A_NUM + position.getCol()) + String.valueOf(position.getRow() + 1);
    }

    private int[] convertToNum(String uci) {
        int row = Character.getNumericValue(uci.charAt(1));
        int col = uci.charAt(0) - ALPHABET_A_NUM;

        return new int[]{row - 1, col};
    }
}
