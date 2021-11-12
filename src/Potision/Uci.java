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
        int[] lineRow = convertToNum(uci);

        return lineRow[0] >= 0 && lineRow[1] >=0 && lineRow[0] <= size && lineRow[1] <= size;
    }

    public Position getPositionFromUci(String uci) {
        int[] lineRow = convertToNum(uci);
        return new Position(lineRow[0], lineRow[1]);
    }

    private int[] convertToNum(String uci) {
        int line = uci.charAt(0) - ALPHABET_A_NUM;
        int row = Character.getNumericValue(uci.charAt(1));

        return new int[]{line, row};
    }
}
