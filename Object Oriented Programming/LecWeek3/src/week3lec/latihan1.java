package week3lec;

public class latihan1 {

	public static void main(String[] args) {
		
		//Cara input array - cara 1
		int[] angka = {10, 80, 75, 69};
		
		//Cara input array - cara 2
		//int[] angka = new int[6];
		angka[0] = 123;
		angka[1] = 321;
		angka[2] = 345;
		//angka[5] = 565;

		//Cara tampilin array - single
		System.out.println("Angka kamu: " + angka[3]);
		
		System.out.println("Banyak: " + angka.length);
		
		//Cara tampilin array - semua
		for(int a=0; a<angka.length; a++) {
			System.out.println(angka[a] + ", ");
		}
		
	}

}
