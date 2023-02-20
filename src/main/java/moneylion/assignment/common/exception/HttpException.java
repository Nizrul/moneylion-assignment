package moneylion.assignment.common.exception;

import org.springframework.http.HttpStatus;

public class HttpException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1759059498784962527L;
	private HttpStatus statusCode;
	private String message;
	
	public HttpException() {
		super("Default http exception");
	}
	
	public HttpException(String message) {
		super(message);
		this.message = message;
	}
	
	public HttpException(String message, HttpStatus statusCode) {
		super(message);
		this.message = message;
		this.statusCode = statusCode;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
