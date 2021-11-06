package Potision;

public class Uci {
    private int size;

    public Uci(int size) {
        this.size = size;
    }

    public boolean validate(String uci) {
        //todo
        //uci is suppose to be "a4" or "b7". length = 2.

        return true;
    }

    public Position getPositionFromUci(String uci) {
        //TODO
        return new Position(0, 0);
    }
}
