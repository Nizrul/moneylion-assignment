package moneylion.assignment.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_MODIFIED)
public class NotModifiedException extends HttpException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 104;

	public NotModifiedException() {
		super("Data was not modified");
		super.setStatusCode(HttpStatus.NOT_MODIFIED);
	}
	
	public NotModifiedException(String message) {
		super(message);
		super.setMessage(message);
		super.setStatusCode(HttpStatus.NOT_MODIFIED);
	}
}
