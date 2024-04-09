package week3lec;

import java.util.Arrays;

public class lat1 {

    public static void main(String[] args) {
        int[] list_score = new int[10];

        // input random ke dalam array
        for (int a = 0; a < list_score.length; a++) {
            list_score[a] = (int) (Math.random() * 100);
        }

        Arrays.sort(list_score);
        System.out.println("");

        System.out.println("Nilai minimum: " + list_score[0]);
        System.out.println("Nilai maksimum: " + list_score[list_score.length - 1]);

        // lihat isi array
        for (int b = 0; b < list_score.length; b++) {
            System.out.print(list_score[b] + ",");
        }
    }
}

