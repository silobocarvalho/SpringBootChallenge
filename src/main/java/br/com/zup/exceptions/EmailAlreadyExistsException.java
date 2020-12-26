package br.com.zup.exceptions;

public class EmailAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String EmailAlreadyExistsException = "This email is already in our database.";
	
	public EmailAlreadyExistsException() {
		super(EmailAlreadyExistsException);
	}

}
