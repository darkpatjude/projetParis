package formation.projetParis.newFive.exceptions;

public class BallonException extends RuntimeException { //no estar obligado de poner trycatch con RuntimeException

	public BallonException() {

	}

	public BallonException(String message) {
		super(message);

	}

}
