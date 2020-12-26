package br.com.zup.model;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity //Javax Persistence
public class Account {
	
	public Account() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private int agencyNumber;
	
	@NotNull
	@Column(unique = true)
	private int accountNumber;
	
	@NotNull
	private BigDecimal balance = BigDecimal.ZERO;
	
	@NotNull
	@ManyToOne
	private Client client;
	
	public Account(int agencyNumber, int accountNumber, Client client) {
		this.agencyNumber = agencyNumber;
		this.accountNumber = accountNumber;
		this.client = client;
	}
	
	public long getId() {
		return id;
	}
	
	public @NotNull int getAccountNumber() {
		return accountNumber;
	}
	
	public @NotNull int getAgencyNumber() {
		return agencyNumber;
	}
	
	public BigDecimal getBalance() {
		return this.balance;
	}
	
	public BigDecimal addValue(BigDecimal value) {
		this.balance = this.balance.add(value);
		return this.balance;
	}
	
	public BigDecimal decreaseValue(BigDecimal value) {
		this.balance = this.balance.subtract(value);
		return this.balance;
	}
	
	public Client getClient() {
		return client;
	}
	
}
