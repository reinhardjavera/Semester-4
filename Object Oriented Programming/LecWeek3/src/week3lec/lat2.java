package week3lec;

public class lat2 {

	public static void main(String[] args) {
        float[] tinggi_badan = new float[10];

        // input random ke dalam array
        for (int a = 0; a < tinggi_badan.length; a++) {
            tinggi_badan[a] = (float) ((Math.random() * 35)+145);
        }

        // lihat isi array
        float rata_rata = 0;
        for (int b = 0; b < tinggi_badan.length; b++) {
            System.out.print(tinggi_badan[b] + ",");
            rata_rata += tinggi_badan[b];
        }
        
        System.out.println("\nJumlah: " + rata_rata);
        System.out.println("Rata: " + rata_rata/tinggi_badan.length);
    }
}
