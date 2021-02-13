
import java.util.ArrayList;
import java.util.regex.*;
/**
 * 
 * @author Laith Najjab
 * Utility class with a collection of methods used to check the validity of passwords
 *
 */
public class PasswordCheckerUtility {
	
	public PasswordCheckerUtility() {
		
	}
	/**
	 * Compares two password strings to verify they are the same
	 * @param password
	 * @param passwordConfirm
	 * @throws UnmatchedException
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException  {
		if (!password.equals(passwordConfirm)) {
			throw new UnmatchedException();
		}
	}
	/**
	 * Compares two password strings to verify they are the same and then returns true if they are and false if not
	 * @param password
	 * @param passwordConfirm
	 * @return
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		if(password.equals(passwordConfirm)) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Checks whether password string is between six and nine characters long
	 * @param password
	 * @return
	 */
	public static boolean hasBetweenSixAndNineChars(String password) {
		if(password.length() <= 9 && password.length() >= 6) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Checks whether password string has a number
	 * @param password
	 * @return
	 * @throws NoDigitException
	 */
	public static boolean hasDigit(String password) throws NoDigitException {
		for(int i = 0; i < password.length(); i++) {
			if(Character.isDigit(password.charAt(i))){
				return true;
			}
		}
		throw new NoDigitException();
	}
	/**
	 * Checks whether password has lower case letters
	 * @param password
	 * @return
	 * @throws NoLowerAlphaException
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
		for(int i = 0; i < password.length(); i++) {
			if(Character.isLowerCase(password.charAt(i))){
				return true;
			}
		}
		throw new NoLowerAlphaException();
	}
	/**
	 * Checks whether password has upper case letters
	 * @param password
	 * @return
	 * @throws NoUpperAlphaException
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		for(int i = 0; i < password.length(); i++) {
			if(Character.isUpperCase(password.charAt(i))){
				return true;
			}
		}
		throw new NoUpperAlphaException();
	}
	/**
	 * Checks if there are 3 of the same character in a row within the password
	 * @param password
	 * @return
	 * @throws InvalidSequenceException
	 */
	public static boolean hasSameCharInSequence(String password) throws InvalidSequenceException {
		for(int i = 2; i < password.length(); i++) {
			if(password.charAt(i-2) == password.charAt(i) && password.charAt(i-1) == password.charAt(i)) {
				throw new InvalidSequenceException();
			}
		}
		return true;
	}
	/**
	 * Checks whether password has a non alphabet or number character
	 * @param password
	 * @return
	 * @throws NoSpecialCharacterException
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException{
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);
		if (matcher.matches()) {
			throw new NoSpecialCharacterException();
		}
		return true;
	}
	/**
	 * Ensures password is at least 6 characters long
	 * @param password
	 * @return
	 * @throws LengthException
	 */
	public static boolean isValidLength(String password) throws LengthException{
		if(password.length() < 6) {
			throw new LengthException();
		}
		return true;
	}
	/**
	 * Ensures password meets all requirements to be valid
	 * @param password
	 * @return
	 * @throws LengthException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoDigitException
	 * @throws NoSpecialCharacterException
	 * @throws InvalidSequenceException
	 */
	public static boolean isValidPassword(String password) throws LengthException,
																  NoUpperAlphaException,
																  NoLowerAlphaException,
																  NoDigitException,
																  NoSpecialCharacterException,
																  InvalidSequenceException {
		if(isValidLength(password))
			if(hasUpperAlpha(password))
				if(hasLowerAlpha(password))
					if(hasDigit(password))
						if(hasSpecialChar(password))
							if(hasSameCharInSequence(password))
								return true;
		return false;
		}
	/**
	 * Checks if the password is valid but is between 6 to 9 characters long
	 * @param password
	 * @return
	 * @throws WeakPasswordException
	 * @throws LengthException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoDigitException
	 * @throws NoSpecialCharacterException
	 * @throws InvalidSequenceException
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException,
																 LengthException,
														  	     NoUpperAlphaException,
															     NoLowerAlphaException,
															     NoDigitException,
															     NoSpecialCharacterException,
															     InvalidSequenceException {
		if(isValidPassword(password))
			if(hasBetweenSixAndNineChars(password))
				 throw new WeakPasswordException();
		return false;		
	}
	
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		ArrayList<String> invalidPasswords = new ArrayList<>();
		for(int i =0; i < passwords.size(); i++) {
			try {
				isValidPassword(passwords.get(i));
			}
			catch(Exception e) {
				invalidPasswords.add(passwords.get(i) + " - " + e.getMessage());
			}
		}
		return invalidPasswords;
	}
}
