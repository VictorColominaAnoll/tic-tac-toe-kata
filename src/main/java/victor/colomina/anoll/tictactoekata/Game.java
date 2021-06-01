package victor.colomina.anoll.tictactoekata;

public class Game {

    private FieldOnBoard[][] grid;

    public Game() {
        grid = new FieldOnBoard[3][3];
    }

    public int getBoardWidth() {
        return 3;
    }

    public int getBoardHeigth() {
        return 3;
    }

    public Object getField(Coordinate x, Coordinate y) {

        if(isGridEmptyInPosition(x.getValue(), y.getValue()))
            return null;

        return grid[x.getValue()][y.getValue()].getContent();
    }

    private boolean isCoordinateOutOfBound(int coordinate) {
        return coordinate >= 3;
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
}
