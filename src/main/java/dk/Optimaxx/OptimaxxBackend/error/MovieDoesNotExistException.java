package dk.Optimaxx.OptimaxxBackend.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MovieDoesNotExistException extends ResponseStatusException {
    public MovieDoesNotExistException() {
        super(HttpStatus.NOT_ACCEPTABLE);
    }

    public MovieDoesNotExistException(String reason) {
        super(HttpStatus.NOT_ACCEPTABLE, reason);
    }

    public MovieDoesNotExistException(String reason, Throwable cause) {
        super(HttpStatus.NOT_ACCEPTABLE, reason, cause);
    }
}
