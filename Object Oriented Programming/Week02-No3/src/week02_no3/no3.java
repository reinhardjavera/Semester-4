package week02_no3;

import java.util.Scanner;

public class no3 {

	public static void main(String[] args) {
		int terkecil;
		int terbesar;
		int angka;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Masukkan angka terkecil : ");
		terkecil = scanner.nextInt();
		
		System.out.println("Masukkan angka terbesar : ");
		terbesar = scanner.nextInt();
		
		scanner.close();
		
		int prima = 0;
		
		for (angka = terkecil; angka <= terbesar; angka++) {
			if (angka > 1 && isPrima(angka)) {
				prima += angka;
			}
		}
		System.out.println("Jumlah dari semua nilai prima dari " + terkecil + " sampai " + terbesar + " adalah " + prima);
	}
	
	private static boolean isPrima(int angka) {
        for (int i = 2; i <= Math.sqrt(angka); i++) {
            if (angka % i == 0) {
                return false;
            }
        }
        return true;
    }

}
