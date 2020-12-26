package br.com.zup.exceptions;

public class CpfAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String CpfAlreadyExistsException = "This CPF is already in our database.";
	
	public CpfAlreadyExistsException() {
		super(CpfAlreadyExistsException);
	}

	
}
