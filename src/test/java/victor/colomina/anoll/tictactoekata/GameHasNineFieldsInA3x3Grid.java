package victor.colomina.anoll.tictactoekata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameHasNineFieldsInA3x3Grid {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void whenCreateNewGame_thenCheckThatIs3x3() {
        assertEquals(game.getBoardWidth(), 3);
        assertEquals(game.getBoardHeigth(), 3);
    }

    @Test
    void whenGetFieldInPosition2x2_returnNull() {
        assertNull(game.getField(new Coordinate(2), new Coordinate(2)));
    }

    @Test
    void when_X_isOutOfBound_thenExceptException() {
        assertThrows(FieldOutOfBound.class, () -> game.getField(new Coordinate(2), new Coordinate(3)));
    }

    @Test
    void when_Y_isOutOfBound_thenExceptException() {
        assertThrows(FieldOutOfBound.class, () -> game.getField(new Coordinate(2), new Coordinate(3)));
    }

    @Test
    void whenFieldIsNotEmpty_returnTrue() {
        assertTrue(game.isFieldEmpty(new Coordinate(2),new Coordinate(2)));
    }

    @Test
    void whenGetField_thenReturnTheField() {
        game.addField(new Coordinate(2),new Coordinate(2), "X");

        assertEquals(game.getField(new Coordinate(2),new Coordinate(2)), "X");
    }
}
