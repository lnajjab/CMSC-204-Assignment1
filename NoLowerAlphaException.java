/**
 * 
 * @author Laith Najjab
 * Exception thrown when password contains no lower case letters
 *
 */
public class NoLowerAlphaException extends Exception {
	public NoLowerAlphaException() {
		super("The password must contain at least one lower case alphabetic character");
	}

}
