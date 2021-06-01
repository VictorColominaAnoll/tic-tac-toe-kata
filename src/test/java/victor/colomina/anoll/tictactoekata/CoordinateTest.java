package victor.colomina.anoll.tictactoekata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CoordinateTest {
    @Test
    void whenCoordinateIsValid_thenIsOk() {
        assertNotNull(createValidCoordinate());
    }

    @Test
    void whenGetCoordinateValue_thenReturnTheValue() {
        Coordinate coordinate = createValidCoordinate();

        assertEquals(coordinate.getValue(), 2);
    }

    private Coordinate createValidCoordinate() {
        return new Coordinate(2);
    }

    @Test
    void whenCreateInValidCoordinate_thenReturnException() {
        assertThrows(
                FieldOutOfBound.class,
                () -> new Coordinate(-1)
        );
    }

    @Test
    void whenCreateOutOfBoundCoordinate_thenReturnException() {
        assertThrows(
                FieldOutOfBound.class,
                () -> new Coordinate(3)
        );
    }
}
