package cl.sentra.apiRegistro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cl.sentra.apiRegistro.dao.UserDao;
import cl.sentra.apiRegistro.model.User;
import cl.sentra.apiRegistro.util.JwtTokenUtil;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private JwtTokenUtil jwtUtil;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User save(User user) {
		String userToken = jwtUtil.generateToken(user.getEmail());
		user.setToken(userToken);
		user.setActive(true);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		return userDao.save(user);
	}
	

}
