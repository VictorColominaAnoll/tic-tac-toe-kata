package victor.colomina.anoll.tictactoekata;

public class Game {

    private final FieldOnBoard[][] grid;

    public Game() {
        grid = new FieldOnBoard[3][3];
    }

    public int getBoardWidth() {
        return 3;
    }

    public int getBoardHeigth() {
        return 3;
    }

    public String getField(Coordinate x, Coordinate y) {

        if (isGridEmptyInPosition(x.getValue(), y.getValue()))
            return null;

        return grid[x.getValue()][y.getValue()].getContent();
    }

    private boolean isGridEmptyInPosition(int x, int y) {
        return grid[x][y] == null;
    }

    public boolean isFieldEmpty(Coordinate x, Coordinate y) {
        return true;
    }

    public void addField(Coordinate x, Coordinate y, String playerLogo) {
        grid[x.getValue()][y.getValue()] = new FieldOnBoard(playerLogo);
    }

    public boolean hasGameEnded() {

        if (playerHasFirstRowCompleted())
            return true;

        if (playerHasMiddleRowCompleted())
            return true;

        if (playerHasBottomRowCompleted())
            return true;

        if (playerHasFirstColumnCompleted())
            return true;

        if (playerHasMiddleColumnCompleted())
            return true;

        if (playerHasLastColumnCompleted())
            return true;

        if (playerHasLeftDiagonalCompleted())
            return true;

        return playerHasRightDiagonalCompleted();
    }


    private boolean playerHasLeftDiagonalCompleted() {
        return isFirstFieldEqualToSecondField(0, 0, 1, 1)
                && isFirstFieldEqualToSecondField(1, 1, 2, 2);
    }

    private boolean playerHasRightDiagonalCompleted() {
        return isFirstFieldEqualToSecondField(0, 2, 1, 1)
                && isFirstFieldEqualToSecondField(1, 1, 2, 0);
    }

    private boolean playerHasFirstColumnCompleted() {
        return isFirstFieldEqualToSecondField(0, 0, 0, 1)
                && isFirstFieldEqualToSecondField(0, 1, 0, 2);
    }

    private boolean playerHasMiddleColumnCompleted() {
        return isFirstFieldEqualToSecondField(1, 0, 1, 1)
                && isFirstFieldEqualToSecondField(1, 1, 1, 2);
    }

    private boolean playerHasLastColumnCompleted() {
        return isFirstFieldEqualToSecondField(2, 0, 2, 1)
                && isFirstFieldEqualToSecondField(2, 1, 2, 2);
    }

    private boolean playerHasFirstRowCompleted() {
        return isFirstFieldEqualToSecondField(0, 0, 1, 0)
                && isFirstFieldEqualToSecondField(1, 0, 2, 0);
    }

    private boolean playerHasMiddleRowCompleted() {
        return isFirstFieldEqualToSecondField(0, 1, 1, 1)
                && isFirstFieldEqualToSecondField(1, 1, 2, 1);
    }

    private boolean playerHasBottomRowCompleted() {
        return isFirstFieldEqualToSecondField(0, 2, 1, 2)
                && isFirstFieldEqualToSecondField(1, 2, 2, 2);
    }

    private boolean isFirstFieldEqualToSecondField(int firstFieldXCoordinate, int firstFieldYCoordinate, int secondFieldXCoordinate, int secondFieldYCoordinate) {
        String firstField = this.getField(new Coordinate(firstFieldXCoordinate), new Coordinate(firstFieldYCoordinate));
        String secondField = this.getField(new Coordinate(secondFieldXCoordinate), new Coordinate(secondFieldYCoordinate));

        if(firstField == null || secondField == null)
            return false;

        return firstField.equalsIgnoreCase(secondField);
    }
}
