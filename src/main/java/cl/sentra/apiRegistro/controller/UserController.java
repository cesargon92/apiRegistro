package cl.sentra.apiRegistro.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.sentra.apiRegistro.dto.PhoneDTO;

@RestController
public class UserController {

	@RequestMapping(value="/addUser", method=RequestMethod.GET)
	public PhoneDTO addUser() {
		return new PhoneDTO("1", "66779175", "56", "9");
	}
}
