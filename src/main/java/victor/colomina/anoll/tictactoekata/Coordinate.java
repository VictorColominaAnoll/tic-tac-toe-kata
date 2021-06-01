package victor.colomina.anoll.tictactoekata;

public class Coordinate {
    private int value;

    public Coordinate(int value) {
        if (isNegativeCoordinate(value) || isOutOfBound(value))
            throw new FieldOutOfBound("Value is out of bound: " + value);

        this.value = value;
    }

    private boolean isOutOfBound(int value) {
        return value >= 3;
    }

    private boolean isNegativeCoordinate(int value) {
        return value < 0;
    }

    public int getValue() {
        return value;
    }
}
