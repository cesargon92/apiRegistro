package cl.sentra.apiRegistro.dao;

import cl.sentra.apiRegistro.dto.UserDTO;

public interface UserDao {

	public int saveUser(UserDTO user);
	
	public UserDTO getUserByEmail(String email);
}
