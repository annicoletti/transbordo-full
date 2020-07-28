package br.com.cpqd.conversation.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.cpqd.conversation.exceptions.DatabaseException;
import br.com.cpqd.conversation.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError standardError = new StandardError();
		standardError.setError(error);
		standardError.setMessage(e.getMessage());
		standardError.setPath(request.getRequestURI());
		standardError.setTimestamp(Instant.now());
		standardError.setStatus(status.value());
		return ResponseEntity.status(status).body(standardError);
	}

	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
		String error = "Database error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError standardError = new StandardError();
		standardError.setError(error);
		standardError.setMessage(e.getMessage());
		standardError.setPath(request.getRequestURI());
		standardError.setTimestamp(Instant.now());
		standardError.setStatus(status.value());
		return ResponseEntity.status(status).body(standardError);
	}

}
