package exceptions;

public class FailedSignUpException extends Exception{
	public FailedSignUpException() {
		super("Password harus mengandung huruf besar, angka, minimum 6 karakter dan maksimum 16 karakter");
	}
	
	public FailedSignUpException(String msg) {
		super(msg);
	}
}
