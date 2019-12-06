package cl.sentra.apiRegistro.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserRequestDTO {

	private String id;
	
	@NotNull(message="Debe agregar su nombre")
	private String name;
	
	@NotNull(message="Debe agregar su email")
	@Email(message="Correo ingresado no es v�lido")
	private String email;
	
	@NotNull(message="Debe incluir una contrase�a")
	@Pattern(regexp="^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9].*[0-9]).{1,}$",
			message="Su contrase�a debe contener al menos una may�scula, una min�scula y dos n�meros")
	private String password;
	
	@NotEmpty(message="Debe agregar al menos un n�mero de tel�fono")
	private List<PhoneDTO> phones;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public List<PhoneDTO> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneDTO> phones) {
		this.phones = phones;
	}
	
	
}
