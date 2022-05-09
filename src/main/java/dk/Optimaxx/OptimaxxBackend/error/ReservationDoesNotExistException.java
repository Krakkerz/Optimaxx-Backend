package dk.Optimaxx.OptimaxxBackend.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ReservationDoesNotExistException extends ResponseStatusException {
    public ReservationDoesNotExistException() {
        super(HttpStatus.NOT_ACCEPTABLE);
    }

    public ReservationDoesNotExistException(String reason) {
        super(HttpStatus.NOT_ACCEPTABLE, reason);
    }

    public ReservationDoesNotExistException(String reason, Throwable cause) {
        super(HttpStatus.NOT_ACCEPTABLE, reason, cause);
    }
}
