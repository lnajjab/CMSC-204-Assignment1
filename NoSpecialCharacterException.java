/**
 * 
 * @author Laith Najjab
 * Exception thrown when password contains only letters and numbers
 *
 */
public class NoSpecialCharacterException extends Exception {
	public NoSpecialCharacterException() {
		super("The password must contain at least one special character");
	}

}
