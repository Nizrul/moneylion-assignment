package moneylion.assignment.common.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import moneylion.assignment.common.exception.HttpException;
import moneylion.assignment.common.exception.NotModifiedException;
import moneylion.assignment.common.exception.ServiceUnavailableException;
import moneylion.assignment.common.exception.UnauthenticatedException;
import moneylion.assignment.common.exception.UnauthorizedException;

@RestControllerAdvice
public class HttpExceptionHandler {

	@ExceptionHandler(value = { NotModifiedException.class, ServiceUnavailableException.class, UnauthenticatedException.class, UnauthorizedException.class })
	public ResponseEntity<Object> handleHttpException(HttpException ex) {
		return new ResponseEntity<Object>(ex.getMessage(), ex.getStatusCode());
	}
}
