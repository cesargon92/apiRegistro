package cl.sentra.apiRegistro.service;

import cl.sentra.apiRegistro.exception.EmailRegisteredException;
import cl.sentra.apiRegistro.model.User;

public interface UserService {

	public User save(User user) throws EmailRegisteredException; 
	
}
