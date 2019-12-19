package cl.sentra.apiRegistro.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserRequestDTO {

	private Long id;
	
	@NotNull(message="Debe agregar su nombre")
	private String name;
	
	@NotNull(message="Debe agregar su email")
	@Email(message="Correo ingresado no es v�lido")
	private String email;
	
	@NotNull(message="Debe incluir una contrase�a")
	@Pattern(regexp="^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9].*[0-9]).{1,}",
			message="Su contrase�a debe contener al menos una may�scula, una min�scula y dos n�meros")
	private String password;
	
	@NotEmpty(message="Debe agregar al menos un n�mero de tel�fono")
	@Valid
	private List<PhoneRequestDTO> phones;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<PhoneRequestDTO> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneRequestDTO> phones) {
		this.phones = phones;
	}
	
	
}
