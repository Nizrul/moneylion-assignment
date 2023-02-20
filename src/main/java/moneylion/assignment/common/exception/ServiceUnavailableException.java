package moneylion.assignment.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class ServiceUnavailableException extends HttpException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 105;

	public ServiceUnavailableException() {
		super("Service is currently unavailable, please contact admin for assistance.");
		super.setStatusCode(HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	public ServiceUnavailableException(String message) {
		super(message);
		super.setMessage(message);
		super.setStatusCode(HttpStatus.SERVICE_UNAVAILABLE);
	}
}
