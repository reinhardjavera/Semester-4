package week03_tugas2;

import java.util.Scanner;

public class Tugas2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Masukkan Nama : ");
		String nama = scanner.nextLine();
		
		System.out.println("---------------------------------");
		System.out.println("String anda : " + nama);
		
		System.out.println("1. charAt");
        System.out.println("2. length");
        System.out.println("3. substring(n)");
        System.out.println("4. substring(m, n)");
        System.out.println("5. contains");
        System.out.println("6. concat");
        System.out.println("7. replace");
        System.out.println("8. split");
        System.out.println("9. lowerCase");
        System.out.println("10. upperCase");
        System.out.print("Pilih Menu : ");
        int pilihan = scanner.nextInt();
        
        switch (pilihan) {
        case 1:
            charAt(nama);
            break;
        case 2:
            length(nama);
            break;
        case 3:
            substringPertama(nama);
            break;
        case 4:
            substringKedua(nama);
            break;
        case 5:
            contains(nama);
            break;
        case 6:
        	concat(nama);
        	break;
        case 7:
        	replace(nama);
        	break;
        case 8:
        	split(nama);
        	break;
        case 9:
        	lowerCase(nama);
        	break;
        case 10:
        	upperCase(nama);
        	break;
        default:
            System.out.println("Pilihan menu tidak tersedia.");
    }
        
	
		scanner.close();
	}
	
	private static void charAt(String nama) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("-----charAt-----");
		System.out.println("Nama : " + nama);
		
		System.out.print("Input angka indeks : ");
		int input = scanner.nextInt();
		try {
			char result = nama.charAt(input);
			System.out.println("Hasil : " + result);
		} catch (StringIndexOutOfBoundsException e) {
            System.out.println("Indeks tidak valid.");
        }
		scanner.close();
	}
	
	private static void length(String nama) {
		System.out.println("-----length-----");
		System.out.println("Nama : " + nama);
		
		System.out.println("Hasil : " + nama.length());
	}
	
	private static void substringPertama(String nama) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("-----substring(n)-----");
		System.out.println("Nama : " + nama);
		
        System.out.print("Masukkan nilai n: ");
        int n = scanner.nextInt();
        String result = nama.substring(n);
        System.out.println("Hasil: " + result);
        scanner.close();
	}
	
	private static void substringKedua(String nama) {
		Scanner scanner = new Scanner(System.in);
	     
		System.out.println("-----substring(m, n)-----");
		System.out.println("Nama : " + nama);
		 
		System.out.print("Masukkan nilai m: ");
	    int m = scanner.nextInt();
	    System.out.print("Masukkan nilai n: ");
	    int n = scanner.nextInt();
	    String result = nama.substring(m, n);
	    System.out.println("Hasil: " + result);
	    scanner.close();
	}
	
	private static void contains(String nama) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("-----contains-----");
		System.out.println("Nama : " + nama);
		
		System.out.print("Input : ");
		String input = scanner.nextLine();
		boolean result = nama.contains(input);
		System.out.println("Hasil : " + result);
		scanner.close();
	}
	
	private static void concat(String nama) {
		Scanner scanner = new Scanner(System.in); 
		
		System.out.println("-----concat-----");
		System.out.println("Nama : " + nama);
		
		System.out.print("Input : ");
		String input = scanner.nextLine();
		String result = nama.concat(input);
		System.out.println("Hasil : " + result);
		scanner.close();
	}
	
	private static void replace(String nama) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("-----replace-----");
		System.out.println("Nama : " + nama);
		
		System.out.print("Input kata yang diganti : ");
		String ganti = scanner.nextLine();
		System.out.print("Input kata pengganti : ");
		String pengganti = scanner.nextLine();
		String result = nama.replace(ganti, pengganti);
		System.out.println("Hasil : " + result);
		scanner.close();
	}
	
	private static void split(String nama) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("-----split-----");
		System.out.println("Nama : " + nama);
		
		System.out.print("Input : ");
		String input = scanner.nextLine();
        System.out.println("Hasil :");
        String[] result = nama.split(input);
        for (String part : result) {
            System.out.println(part);
        }
        scanner.close();
	}
	
	private static void lowerCase(String nama) {
		System.out.println("-----lowerCase-----");
		System.out.println("Nama : " + nama);
		
		String result = nama.toLowerCase();
		System.out.println("Hasil : " + result);
	}
	
	private static void upperCase(String nama) {
		System.out.println("-----upperCase-----");
		System.out.println("Nama : " + nama);
		
		String result = nama.toUpperCase();
		System.out.println("Hasil : " + result);
	}
	

}

