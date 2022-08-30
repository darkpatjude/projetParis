package fivefoot.Exception;

public class MarchandiseException extends RuntimeException { //no estar obligado de poner trycatch con RuntimeException

	public MarchandiseException() {

	}

	public MarchandiseException(String message) {
		super(message);

	}

}
