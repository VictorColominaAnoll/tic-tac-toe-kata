package victor.colomina.anoll.tictactoekata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    void whenPlayerTriesToAddOnOccupiedField_expectException() {
        Game game = new Game();

        game.addField(0, 0, "X");

        Assertions.assertThrows(
                FieldAlreadyTaken.class,
                () -> game.addField(0, 0, "X")
        );

    }
}
