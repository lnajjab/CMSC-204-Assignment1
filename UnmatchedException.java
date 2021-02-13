/**
 * 
 * @author Laith Najjab
 * Exception thrown when 
 *
 */
public class UnmatchedException extends Exception {
	public UnmatchedException() {
		super("Passwords do not match");
	}
}
