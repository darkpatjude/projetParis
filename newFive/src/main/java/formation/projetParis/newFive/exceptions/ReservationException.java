package formation.projetParis.newFive.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, value = HttpStatus.NOT_FOUND, reason = "not found")
public class ReservationException extends RuntimeException {
	public ReservationException() {

	}

	public ReservationException(String message) {
		super(message);
	}

}
