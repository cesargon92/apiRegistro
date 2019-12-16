package cl.sentra.apiRegistro.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.sentra.apiRegistro.dto.UserRequestDTO;
import cl.sentra.apiRegistro.dto.UserResponseDTO;
import cl.sentra.apiRegistro.model.User;
import cl.sentra.apiRegistro.service.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private ModelMapper mapper;

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ResponseEntity<?> addUser(@RequestBody @Valid UserRequestDTO userRequest) {

		User user = mapper.map(userRequest, User.class);
		User insertedUser = userService.save(user);
		UserResponseDTO userResponse = mapper.map(insertedUser, UserResponseDTO.class);
		
		return ResponseEntity.ok(userResponse);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, Map<String, String>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new LinkedHashMap<>();
		Map<String, Map<String, String>> firstError = new LinkedHashMap<>();

		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

		firstError.put("mensaje", errors);

		return firstError;
	}
}
