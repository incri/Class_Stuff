/**
 * This class throws the exception when there is input error.
 * It has a custom message field which can be set and same message will be passed.
 */
package Helper;
public class InputException extends Exception {
	private static final long serialVersionUID = 1L;
	public InputException() {
		super("The data you entered is not correct. Please check the input");
	}
	public InputException(String message) {
		super(message);
	}
}
