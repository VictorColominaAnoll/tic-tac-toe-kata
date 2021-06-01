package victor.colomina.anoll.tictactoekata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void whenPlayerTriesToAddOnOccupiedField_expectException() {
        game.addField(0, 0, "X");

        Assertions.assertThrows(
                FieldAlreadyTaken.class,
                () -> game.addField(0, 0, "X")
        );
    }

    @Test
    void whenPlayerHasThreeFieldsInFirstLine_thenPlayerWins() {
        playerAddFieldsInLineHorizontal(0, 0);

        Assertions.assertTrue(game.hasGameEnded());
    }

    @Test
    void whenPlayerHasThreeFieldsInTheMiddle_thenPlayerWins() {
        playerAddFieldsInLineHorizontal(1, 0);

        Assertions.assertTrue(game.hasGameEnded());
    }

    @Test
    void whenPlayerHasThreeFieldsAtTheBottom_thenPlayerWins() {
        playerAddFieldsInLineHorizontal(2, 0);

        Assertions.assertTrue(game.hasGameEnded());
    }

    @Test
    void whenPlayerHasThreeFieldsInFirstColumn_thenPlayerWins() {
        playerAddFieldsInLineVertical(0, 1);

        Assertions.assertTrue(game.hasGameEnded());
    }

    @Test
    void whenPlayerHasThreeFieldsInMiddleColumn_thenPlayerWins() {
        playerAddFieldsInLineVertical(0, 2);

        Assertions.assertTrue(game.hasGameEnded());
    }

    @Test
    void whenPlayerHasThreeFieldsInLastColumn_thenPlayerWins() {
        playerAddFieldsInLineVertical(0, 2);

        Assertions.assertTrue(game.hasGameEnded());
    }

    @Test
    void whenPlayerHasLeftDiagonal_thenPlayerWins() {
        playerAddFieldsInLeftDiagonal();

        Assertions.assertTrue(game.hasGameEnded());
    }

    @Test
    void whenPlayerHasRightDiagonal_thenPlayerWins() {
        playerAddFieldsInRightDiagonal();

        Assertions.assertTrue(game.hasGameEnded());
    }

    @Test
    void whenPlayerHasNoDiagonalOrLine_thenGameIsNotEnd() {
        Assertions.assertFalse(game.hasGameEnded());
    }

    private void playerAddFieldsInRightDiagonal() {
        playerAddFieldInCoordinates(2, 0);
        playerAddFieldInCoordinates(1, 1);
        playerAddFieldInCoordinates(0, 2);
    }

    private void playerAddFieldsInLeftDiagonal() {
        playerAddFieldInCoordinates(0, 0);
        playerAddFieldInCoordinates(1, 1);
        playerAddFieldInCoordinates(2, 2);
    }

    private void playerAddFieldsInLineHorizontal(int x, int y) {
        for (int i = 0; i < 3; i++) {
            playerAddFieldInCoordinates(x, y + i);
        }
    }

    private void playerAddFieldsInLineVertical(int x, int y) {
        for (int i = 0; i < 3; i++) {
            playerAddFieldInCoordinates(x + i, y);
        }
    }

    private void playerAddFieldInCoordinates(int x, int y) {
        game.addField(new Coordinate(x), new Coordinate(y), "X");
    }
}
