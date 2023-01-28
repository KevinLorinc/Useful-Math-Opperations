/**
 * an exception type that indicates that an invalid dimension matrix was fed in by the user
 * @author Kevin Lorinc
 *
 */
public class InvalidDimensionsException extends Exception{
	/**
	 * creates the exception with a message
	 * @param message the message to be displayed with the error
	 */
	public InvalidDimensionsException(String message) {
		super(message);
	}
}
