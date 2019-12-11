package cl.sentra.apiRegistro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.sentra.apiRegistro.dao.UserDao;
import cl.sentra.apiRegistro.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
//	@Autowired
//	private PhoneDao phoneDao;
	
	public User save(User user) {
		return userDao.save(user);
	}
	

}
