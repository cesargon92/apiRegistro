package cl.sentra.apiRegistro.controller;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.sentra.apiRegistro.dto.UserRequestDTO;
import cl.sentra.apiRegistro.dto.UserResponseDTO;
import cl.sentra.apiRegistro.model.User;
import cl.sentra.apiRegistro.service.UserServiceImpl;

@RestController
public class UserController {

	private static final Logger LOGGER = Logger.getLogger(UserController.class.toString());
	
	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private ModelMapper mapper;

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ResponseEntity<?> addUser(@RequestBody @Valid UserRequestDTO userRequest) {

		LOGGER.info("[addUser] Inicio");
		LOGGER.info("[addUser] Mapping from Request DTO");
		User user = mapper.map(userRequest, User.class);
		LOGGER.info("[addUser] Calling to service");
		User insertedUser = userService.save(user);
		LOGGER.info("[addUser] Mapping to Response DTO");
		UserResponseDTO userResponse = mapper.map(insertedUser, UserResponseDTO.class);
		LOGGER.info("[addUser] Fin Ok");
		
		return ResponseEntity.ok(userResponse);
	}
}
