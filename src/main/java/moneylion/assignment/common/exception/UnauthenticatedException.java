package moneylion.assignment.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthenticatedException extends HttpException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 101;

	public UnauthenticatedException() {
		super("Invalid username or password");
		super.setStatusCode(HttpStatus.UNAUTHORIZED);
	}
}
