package com.SpringBootCustomValidation.payload;

import com.SpringBootCustomValidation.validations.PasswordMatching;
import com.SpringBootCustomValidation.validations.StrongPassword;

import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Pattern.Flag;

@PasswordMatching(password = "password", confirmPassword = "confirmPassword", message = "Password and Confirm Password must be matched!")
public class SignupRequest {
	@NotBlank
	@Size(min = 3, max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
    flags = Pattern.Flag.CASE_INSENSITIVE)
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
	private String email;

	@StrongPassword
	private String password;

	private String confirmPassword;

	public SignupRequest() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public SignupRequest(@NotBlank @Size(min = 3, max = 20) String username,
			@NotBlank @Size(max = 50) @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Flag.CASE_INSENSITIVE) @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$") String email,
			String password, String confirmPassword) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "SignupRequest [username=" + username + ", email=" + email + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + "]";
	}

}