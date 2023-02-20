package moneylion.assignment.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UnauthorizedException extends HttpException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 102;

	public UnauthorizedException() {
		super("User access denied. Please contact admin to request access.");
		super.setStatusCode(HttpStatus.FORBIDDEN);
	}
}
