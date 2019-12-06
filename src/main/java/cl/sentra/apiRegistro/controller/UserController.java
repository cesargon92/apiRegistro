package cl.sentra.apiRegistro.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.dozer.Mapper;
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

import cl.sentra.apiRegistro.dto.UserDTO;
import cl.sentra.apiRegistro.dto.UserRequestDTO;
import cl.sentra.apiRegistro.service.UserServiceImpl;

@RestController
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private Mapper mapper;

	@Autowired
	private UserDTO user;
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public ResponseEntity<String> addUser(@RequestBody @Valid UserRequestDTO userRequest) {
		
		try {
			System.out.println("MAPPING request to bean...");
			user = mapper.map(userRequest, UserDTO.class);
			System.out.println("MAPPING request to bean OK");
		}catch (Exception e) {
			System.out.println("MAPPING exception");
		}
		
		userService.saveUser(user);
		System.out.println("SAVE OK");
		//return new PhoneDTO("1", "66779175", "56", "9");
		return ResponseEntity.ok("User data is valid");
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	 
	    ex.getBindingResult().getFieldErrors().forEach(error -> 
	        errors.put(error.getField(), error.getDefaultMessage()));
	     
	    return errors;
	}
}
