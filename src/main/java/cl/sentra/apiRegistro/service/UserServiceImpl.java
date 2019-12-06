package cl.sentra.apiRegistro.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.sentra.apiRegistro.dao.PhoneDaoImpl;
import cl.sentra.apiRegistro.dao.UserDaoImpl;
import cl.sentra.apiRegistro.dto.PhoneDTO;
import cl.sentra.apiRegistro.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDaoImpl userDao;
	
	@Autowired
	private PhoneDaoImpl phoneDao;
	
	
	public void saveUser(UserDTO user) {
		UUID uuid = UUID.randomUUID();
		user.setId(uuid.toString());
		userDao.saveUser(user);
		for(int i = 0; i < user.getPhones().size(); i++) {
			PhoneDTO phone = user.getPhones().get(i);
			phone.setUserId(user.getId());
			phoneDao.addPhone(phone);
		}
	}
}
