package victor.colomina.anoll.tictactoekata;

public class FieldAlreadyTaken extends RuntimeException {
    public FieldAlreadyTaken(String message) {
        super(message);
    }
}
