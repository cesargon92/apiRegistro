package cl.sentra.apiRegistro.dto;

import javax.validation.constraints.NotBlank;

public class PhoneRequestDTO {
	
	@NotBlank(message="Debe agregar el n�mero de contacto")
	private String number;
	
	@NotBlank(message="Debe agregar el c�digo de ciudad")
	private String cityCode;
	
	@NotBlank(message="Debe agregar el c�digo del pa�s")
	private String contryCode;
	
	public PhoneRequestDTO() {

	}
	
	public PhoneRequestDTO(String number, String cityCode, String contryCode) {
		this.number = number;
		this.cityCode = cityCode;
		this.contryCode = contryCode;
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
		builder.append("PhoneRequestDTO [number=");
		builder.append(number);
		builder.append(", cityCode=");
		builder.append(cityCode);
		builder.append(", contryCode=");
		builder.append(contryCode);
		builder.append("]");
		return builder.toString();
	}

	
	
	
	
	
}
