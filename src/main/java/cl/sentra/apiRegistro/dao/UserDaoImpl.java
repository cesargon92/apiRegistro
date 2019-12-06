package cl.sentra.apiRegistro.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.sentra.apiRegistro.dto.UserDTO;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
    JdbcTemplate jdbcTemplate;
		
	public int saveUser(UserDTO user) {
		
		String sql = "insert into users (id, name, email, password) values ('?',  '?', '?',  '?')";
		return jdbcTemplate.update(sql, user.getId(), user.getName(), user.getEmail(), user.getPassword());
	}
	
	public UserDTO getUserByEmail(String email) {
		
		String sql = "select * from users where email LIKE '?'";
		UserDTO user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class), email);
		return user;
		
	}
}
