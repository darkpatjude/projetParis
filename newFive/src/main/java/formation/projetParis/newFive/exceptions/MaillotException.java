package formation.projetParis.newFive.exceptions;

public class MaillotException extends RuntimeException { //no estar obligado de poner trycatch con RuntimeException

	public MaillotException() {

	}

	public MaillotException(String message) {
		super(message);

	}

}
