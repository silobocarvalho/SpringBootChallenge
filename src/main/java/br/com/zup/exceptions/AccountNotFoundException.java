package br.com.zup.exceptions;

public class AccountNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String AccountNotFoundException = "Account not found in database.";
	
	public AccountNotFoundException() {
		super(AccountNotFoundException);
	}
}
