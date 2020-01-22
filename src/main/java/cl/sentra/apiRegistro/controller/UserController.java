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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value="Sistema de administración de registros")
@RestController
public class UserController {

	private static final Logger LOGGER = Logger.getLogger(UserController.class.toString());
	
	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private ModelMapper mapper;

	@ApiOperation(value = "Registra un nuevo usuario en Base de Datos y retorna objeto con token", response = ResponseEntity.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Usuario ingresado con éxito"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Error. Email ya registrado")
	})
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ResponseEntity<?> addUser(
			@ApiParam(value = "Usuario a almacenar en base de datos", required = true)
			@RequestBody @Valid UserRequestDTO userRequest) {

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
