package cl.sentra.apiRegistro.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.sentra.apiRegistro.dto.PhoneDTO;

@Repository
public class PhoneDaoImpl implements PhoneDao{

	@Autowired
    JdbcTemplate jdbcTemplate;
	
	public int addPhone (PhoneDTO phone) {
		
		String sql = "insert into phones (user_id, number, city_code, contry_code) values ('?',  '?', '?', '?')";
		return jdbcTemplate.update(sql, phone.getUserId(), phone.getNumber(), phone.getCityCode(), phone.getContryCode());
	}
}
