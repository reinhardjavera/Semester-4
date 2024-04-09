package week02_no1;

import java.util.Scanner;

public class no1 {

	public static void main(String[] args) {
		int input;
		Scanner scanner = new Scanner(System.in);
		
		String[] januari = {
				"Bulan Januari memiliki 31 hari."
		};
		
		String[] februari = {
				"Bulan Februari memiliki 28 atau 29 hari"
		};
		
		String[] maret = {
				"Bulan Maret memiliki 31 hari"
		};

		String[] april = {
				"Bulan April memiliki 30 hari"
		};

		String[] mei = {
				"Bulan Mei memiliki 31 hari"
		};

		String[] juni = {
				"Bulan Juni memiliki 30 hari"
		};

		String[] juli = {
				"Bulan Juli memiliki 31 hari"
		};

		String[] agustus = {
				"Bulan Agustus memiliki 30 hari"
		};

		String[] september = {
				"Bulan September memiliki 31 hari"
		};

		String[] oktober = {
				"Bulan Oktober memiliki 30 hari"
		};

		String[] november = {
				"Bulan November memiliki 31 hari"
		};

		String[] desember = {
				"Bulan Desember memiliki 30 hari"
		};
		
		System.out.println("Masukkan bulan(1-12) : ");
		input = scanner.nextInt();
		
		switch(input) {
			case 1: show(januari); break;
			case 2: show(februari); break;
			case 3: show(maret); break;
			case 4: show(april); break;
			case 5: show(mei); break;
			case 6: show(juni); break;
			case 7: show(juli); break;
			case 8: show(agustus); break;
			case 9: show(september); break;
			case 10: show(oktober); break;
			case 11: show(november); break;
			case 12: show(desember); break;
			default: System.out.println("Tolong hanya masukkan angka 1-12");
		
		scanner.close();
		}
	}
	
	public static void show(String[] bulan) {
		for(String eachBulan : bulan) {
			System.out.println(eachBulan);
		}

	}
	
}