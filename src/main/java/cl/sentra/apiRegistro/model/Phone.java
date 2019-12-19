package cl.sentra.apiRegistro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_phones")
public class Phone implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "phone_number")
	private String number;
	
	@Column(name = "city_code")
	private String cityCode;
	
	@Column(name = "country_code")
	private String contryCode;
		
	public Phone() {
		super();
	}
	
	public Phone(Long id, String number, String cityCode, String contryCode) {
		super();
		this.id = id;
		this.number = number;
		this.cityCode = cityCode;
		this.contryCode = contryCode;
	}

	public Long getId() {
		return id;
	}

	public void setUserId(Long id) {
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
		builder.append("PhoneDTO [id=");
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
