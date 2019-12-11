package cl.sentra.apiRegistro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.sentra.apiRegistro.model.Phone;

@Repository
public interface PhoneDao extends JpaRepository<Phone, Long>{

}
