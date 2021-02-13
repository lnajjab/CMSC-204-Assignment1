/**
 * 
 * @author Laith Najjab
 * Exception thrown when there are 3 or more of the same character in a row within a password
 *
 */
public class InvalidSequenceException extends Exception {
	public InvalidSequenceException() {
		super("The password cannot contain more than two of the same character in sequence");
	}

}
