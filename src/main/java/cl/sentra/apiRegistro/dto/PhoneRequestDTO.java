package cl.sentra.apiRegistro.dto;

import javax.validation.constraints.NotBlank;

public class PhoneRequestDTO {
	
	
	private Long id;
	
	@NotBlank(message="Debe agregar el número de contacto")
	private String number;
	
	@NotBlank(message="Debe agregar el código de ciudad")
	private String cityCode;
	
	@NotBlank(message="Debe agregar el código del país")
	private String contryCode;
	
	public PhoneRequestDTO() {

	}
	
	public PhoneRequestDTO(Long id, String number, String cityCode, String contryCode) {
		this.id = id;
		this.number = number;
		this.cityCode = cityCode;
		this.contryCode = contryCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getContryCode() {
		return contryCode;
	}

	public void setContryCode(String contryCode) {
		this.contryCode = contryCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PhoneRequestDTO [id=");
		builder.append(id);
		builder.append(", number=");
		builder.append(number);
		builder.append(", cityCode=");
		builder.append(cityCode);
		builder.append(", contryCode=");
		builder.append(contryCode);
		builder.append("]");
		return builder.toString();
	}

	
	
	
	
}
