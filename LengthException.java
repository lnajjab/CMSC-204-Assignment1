/**
 * 
 * @author Laith Najjab
 * Exception thrown when password is less than 6 characters long
 *
 */
public class LengthException extends Exception {

	public LengthException() {
		super("The password must be at least 6 characters long");
	}
}
