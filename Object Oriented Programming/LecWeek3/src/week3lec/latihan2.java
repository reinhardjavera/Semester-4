package week3lec;

public class latihan2 {

	public static void main(String[] args) {
		
		//cara input arrat multidimensional - cara 1
		int[][] angka = {
						{50,60,70},
						{80,90},
						{40,55,77}
						};
						
		//cara penulisan array multidimensional kedua
		//int[][] angka = {{50,60,70},{80,90},{40,55,77}};
						
		//cara input arrat multidimensional - cara 2
		angka[0][1] = 57;
		angka[0][2] = 91;
		
		//cara tampil arrya multidimensional - satuan
		System.out.println("SATUAN: " + angka[0][2]);
		
		//cara tampil arrya multidimensional - semua
		for(int a = 0; a<angka.length; a++) {
			for(int b = 0; b<angka[a].length; b++) {
				System.out.println(angka[a][b] + ",");
			}
			System.out.print("");
		}

	}

}
