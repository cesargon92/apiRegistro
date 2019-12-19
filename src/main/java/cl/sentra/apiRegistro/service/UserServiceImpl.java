package cl.sentra.apiRegistro.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cl.sentra.apiRegistro.dao.UserDao;
import cl.sentra.apiRegistro.exception.EmailRegisteredException;
import cl.sentra.apiRegistro.model.User;
import cl.sentra.apiRegistro.util.JwtTokenUtil;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class.toString());
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private JwtTokenUtil jwtUtil;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User save(User user) throws EmailRegisteredException {
		
		LOGGER.info("[save] Inicio");
		User registeredUser = userDao.findByEmail(user.getEmail());
		if(registeredUser != null) {
			LOGGER.info("[save] Throwing EmailRegisteredException");
			throw new EmailRegisteredException();
		}
		
		String userToken = jwtUtil.generateToken(user.getEmail());
		user.setToken(userToken);
		user.setActive(true);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		LOGGER.info("[save] Fin ok");
		return userDao.save(user);
	}
	

}
