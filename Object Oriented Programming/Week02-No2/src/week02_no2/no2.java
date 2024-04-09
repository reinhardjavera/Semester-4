package week02_no2;

import java.util.Scanner;

public class no2 {

	public static void main(String[] args) {
		int angka;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Masukkan sebuah angka: ");
        angka = scanner.nextInt();
        
        scanner.close();
        
        if (angka <= 1) {
            System.out.println(angka + " bukan bilangan prima.");
        } else {
            boolean prima = true;
            for (int i = 2; i <= Math.sqrt(angka); i++) {
                if (angka % i == 0) {
                    prima = false;
                    break;
                }
            }

            if (prima) {
                System.out.println(angka + " adalah bilangan prima.");
            } else {
                System.out.println(angka + " bukan bilangan prima.");
            }
        }
	}

}
