package cl.sentra.apiRegistro.dto;

import java.time.LocalDate;

public class UserResponseDTO {

	private String id;
	private LocalDate createdDate;
	private LocalDate updatedDate;
	private LocalDate lastLogin;
	private String token;
	private boolean isActive;
	
	public UserResponseDTO() {

	}

	public UserResponseDTO(String id, LocalDate createdDate, LocalDate updatedDate, LocalDate lastLogin, String token,
			boolean isActive) {
		super();
		this.id = id;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.lastLogin = lastLogin;
		this.token = token;
		this.isActive = isActive;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	public LocalDate getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDate lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserResponseDTO [id=");
		builder.append(id);
		builder.append(", createdDate=");
		builder.append(createdDate);
		builder.append(", updatedDate=");
		builder.append(updatedDate);
		builder.append(", lastLogin=");
		builder.append(lastLogin);
		builder.append(", token=");
		builder.append(token);
		builder.append(", isActive=");
		builder.append(isActive);
		builder.append("]");
		return builder.toString();
	}
	
}
