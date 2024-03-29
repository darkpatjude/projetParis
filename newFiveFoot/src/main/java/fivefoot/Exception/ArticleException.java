package fivefoot.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, value = HttpStatus.NOT_FOUND, reason = "not found")
public class ArticleException extends RuntimeException {
	public ArticleException() {

	}

	public ArticleException(String message) {
		super(message);
	}

}
