/**
 * 
 * @author Laith Najjab
 * Exception thrown when password contains no numbers
 *
 */
public class NoDigitException extends Exception {
	public NoDigitException() {
		super("The password must contain at least one digit");
	}
}
