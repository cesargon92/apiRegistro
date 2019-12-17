package cl.sentra.apiRegistro.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler  {

	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
		Map<String, String> errors = new LinkedHashMap<>();
		Map<String, Map<String, String>> firstError = new LinkedHashMap<>();

		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

		firstError.put("mensaje", errors);

		return new ResponseEntity<>(firstError, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmailRegisteredException.class)
	public ResponseEntity<Object> handleConstraintViolation(EmailRegisteredException ex) {
		Map<String, String> errors = new LinkedHashMap<>();
		System.out.println("ANTES----------------");
		errors.put("mensaje", ex.getMessage());
		System.out.println("FIN ENTRO----------------");
		System.out.println("FIN----------------");
		return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
