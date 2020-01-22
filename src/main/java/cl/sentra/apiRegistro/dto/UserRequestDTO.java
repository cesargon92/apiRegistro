package cl.sentra.apiRegistro.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Detalles del Usuario")
public class UserRequestDTO {

	@ApiModelProperty(notes = "Nombre del Usuario", required = true)
	@NotNull(message="Debe agregar su nombre")
	private String name;
	
	@ApiModelProperty(notes = "Email del Usuario", required = true)
	@NotNull(message="Debe agregar su email")
	@Email(message="Correo ingresado no es válido")
	private String email;
	
	@ApiModelProperty(notes = "Contraseña del Usuario", required = true)
	@NotNull(message="Debe incluir una contraseña")
	@Pattern(regexp="^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9].*[0-9]).{1,}",
			message="Su contraseña debe contener al menos una mayúscula, una minúscula y dos números")
	private String password;
	
	@ApiModelProperty(notes = "Lista de Teléfonos del Usuario")
	@NotEmpty(message="Debe agregar al menos un número de teléfono")
	@Valid
	private List<PhoneRequestDTO> phones;

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
