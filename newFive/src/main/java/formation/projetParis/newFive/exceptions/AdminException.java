package formation.projetParis.newFive.exceptions;

public class AdminException extends RuntimeException { //no estar obligado de poner trycatch con RuntimeException

	public AdminException() {

	}

	public AdminException(String message) {
		super(message);

	}

}
