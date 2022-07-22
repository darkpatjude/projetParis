package fivefoot.Exception;

public class ClientException extends RuntimeException { //no estar obligado de poner trycatch con RuntimeException

	public ClientException() {

	}

	public ClientException(String message) {
		super(message);

	}

}
