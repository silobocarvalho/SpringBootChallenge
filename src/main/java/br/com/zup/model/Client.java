package br.com.zup.model;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;



@Entity //Javax Persistence
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "Name can not be empty.")
	@Size(min = 10, max = 80, message = "The NAME must be between {min} and {max} characters.")
	private String name;
	
	@NotBlank(message = "Email can not be empty.")
	@Size(min = 5, max = 30, message = "The EMAIL must be between {min} and {max} characters.")
	@Column(unique = true)
	private String email;
	
	@NotBlank(message = "CPF can not be empty.")
	@Column(unique = true)
	@Size(min = 11, max = 11, message = "The CPF must be in format XXX.XXX.XXX-XX.")
	private String cpf;
	
	@DateTimeFormat
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date birthDate;
	

	public String getEmail() {
		Assert.state(email != null, "Email can not be null.");
		return email;
	}
	public String getCpf() {
		Assert.state(cpf != null, "Cpf can not be null.");
		return cpf;
	}
	
	public String getName() {
		return name;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}

	
}
