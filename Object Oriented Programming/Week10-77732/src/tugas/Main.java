package tugas;

import java.util.*;
import exceptions.AuthenticationException;
import exceptions.ExcessiveFailedLoginException;
import exceptions.FailedSignUpException;

public class Main {
	static Scanner s = new Scanner(System.in);
    static ArrayList<User>listOfUser = new ArrayList<User>();

    public static void daftarUser() {
    	listOfUser.add(new User("John", "Doe", 'L', "Jl. Merpati No. 1 RT 1 RW 1, Banten", "admin", "admin"));
    }
    
    public static void mainMenu() {
    	System.out.println("1. Login");
    	System.out.println("2. Sign Up");
    }

    public static void handleLogin() {
    	String username, pass;
        for (User user : listOfUser) {
            for(;;) {
            	try {
            		System.out.print("Username : ");
                	username = s.next();
                	System.out.print("Password : ");
                	pass = s.next();
					if(user.login(username, pass) == true) {
						System.out.println(user.greeting());
						break;
					}
					else {
						System.out.println("Username / password salah \n");
					}
				}
            	catch (ExcessiveFailedLoginException e) {
					System.out.println(e.getMessage());
					break;
				}
            }
        }
    }
    
    public static void handleSignUp() {
    	String firstName, lastName, gender, address, uname;
    	System.out.print("Nama Depan          : ");
    	firstName = s.next(); s.nextLine();
    	System.out.print("Nama Belakang       : ");
    	lastName = s.next(); s.nextLine();
    	System.out.print("Jenis Kelamin (L/P) : ");
    	gender = s.next();
    	System.out.print("Alamat              : ");
    	address = s.next(); s.nextLine();
    	System.out.print("Username            : ");
    	uname = s.next();
    	if(uname.length() < 9) {
    		System.out.println("Username harus lebih dari 8 karakter \n");
    		return;
    	}
    	else {
    		try {
    			User u = new User();
    			System.out.print("Password            : ");
    			String password = s.next();
    			if(u.validate(password) == 1) {
    				listOfUser.add(new User(firstName, lastName, gender.charAt(0), address, uname, password));
    				System.out.println("User telah berhasil didaftarkan \n");
    			}
    		}
    		catch(FailedSignUpException f) {
    			System.out.println(f.getMessage());
    		}
    	}
    }
    
    public static void main(String[] args) {
        int pilihan;
        for(;;) {
        	daftarUser();
        	mainMenu();
        	try {
        		System.out.print("Pilihan : ");
            	pilihan = s.nextInt();
            	switch(pilihan) {
            		case 1 :
            			handleLogin();
            			break;
            		case 2 : 
            			handleSignUp();
            			break;
            		default :
            			System.out.println("Masukkan pilihan dengan benar \n");
            			break;
            	}
        	}
        	catch(java.util.InputMismatchException e) {
        		System.out.println("Input Harus Berupa Angka \n");
        	}
        }
    }
}