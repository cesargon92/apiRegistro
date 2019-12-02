package cl.sentra.apiRegistro.dto;

public class PhoneDTO {

	private String userId;
	private String number;
	private String cityCode;
	private String contryCode;
		
	public PhoneDTO() {
		super();
	}
	
	public PhoneDTO(String userId, String number, String cityCode, String contryCode) {
		super();
		this.userId = userId;
		this.number = number;
		this.cityCode = cityCode;
		this.contryCode = contryCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
		builder.append("PhoneDTO [userId=");
		builder.append(userId);
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
