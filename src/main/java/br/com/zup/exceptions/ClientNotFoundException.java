package br.com.zup.exceptions;

public class ClientNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static String ClientNotFoundException = "Client not found in database. Create the client before create an account.";
	
	public ClientNotFoundException() {
		super(ClientNotFoundException);
	}

	
}
