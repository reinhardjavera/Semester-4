package tugas;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import exceptions.ExcessiveFailedLoginException;
import exceptions.InvalidPropertyException;
import exceptions.FailedSignUpException;

public class User {
	
	private String firstName;
	private String lastName;
	private Character gender;
	private String address;
	private String userName;
	private String password;
	private MessageDigest digest;
	
	private static final int maxLoginAttempts = 3;
	private static int loginAttempts;
	
	private String hash(String strToHash) {
		try {
			digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(strToHash.getBytes(StandardCharsets.UTF_8));
			StringBuilder result = new StringBuilder();
			for(byte b : hash) {
				result.append(String.format("%02x", b));
			}
			return result.toString();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}
	
	public User() {}
	public User(String firstName, String lastName, Character gender, String address, String userName, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.address = address;
		this.userName = userName;
		this.password = hash(password);
	}

	public boolean login(String username, String password) throws ExcessiveFailedLoginException{
		if(this.userName.equals(username)) {
			if(loginAttempts == maxLoginAttempts) {
				loginAttempts++;
				throw new ExcessiveFailedLoginException();
			}
			else if(loginAttempts > maxLoginAttempts) {
				throw new ExcessiveFailedLoginException("Anda telah mencapai batas login \n");
			}
			
			if(this.password.equals(hash(password))) {
				loginAttempts = 0;
				return true;
			}
			else {
				loginAttempts++;
			}
		}
		return false;
	}
	
	public static boolean upperCheck(String string) {
		for(int i = 0; i < string.length(); i++) {
			if(Character.isUpperCase(string.charAt(i))) {
				return true;
			}
		}
		return false;
	}
	
	public int validate(String pw) throws FailedSignUpException{
		if(upperCheck(pw) == false) {
			throw new FailedSignUpException();
		}
		else {
			if(pw.matches(".*[0-9].*") == false) {
				throw new FailedSignUpException();
			}
			else {
				if(pw.length() < 6 || pw.length() > 16) {
					throw new FailedSignUpException();
				}
				else {
					return 1;
				}
			}
		}
	}
	
	public String greeting() {
		String greet = "Selamat Datang ";
		switch(gender) {
		case 'M' : greet += "Tuan "; break;
		case 'F' : greet += "Nona "; break;
		}
		greet += this.firstName + " " + this.lastName + "\n";
		
		return greet;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getPassword() {
		return password;
	}
}