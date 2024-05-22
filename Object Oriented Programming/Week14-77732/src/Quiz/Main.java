package Quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        List<Paslon> paslonList = new ArrayList<>();

        users.add(new Admin("Admin 1", "admin1", "admin123"));
        users.add(new Admin("Admin 2", "admin2", "admin456"));

        users.add(new Peserta("Peserta 1", "abi", "abi123"));
        users.add(new Peserta("Peserta 2", "rio", "rio123"));
        users.add(new Peserta("Peserta 3", "reinjv", "reinjv123"));
        users.add(new Peserta("Peserta 4", "loler", "loler123"));
        users.add(new Peserta("Peserta 5", "atria", "atria123"));

        paslonList.add(new Paslon("Anies Baswedan"));
        paslonList.add(new Paslon("Prabowo Subianto"));
        paslonList.add(new Paslon("Reinhard Javera Maheswara"));

        Scanner scanner = new Scanner(System.in);

        // Membuat objek Voting dan menangani login
        Voting voting = new Voting(users, paslonList);


        boolean exit = false;

        while (!exit) {
            try {
                voting.handleLogin(scanner);
            } catch (PesanError e) {
                System.out.println("Error saat login: " + e.getMessage());
            }

            System.out.print("Apakah Anda ingin login ulang atau keluar? (login/exit): ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("exit")) {
                exit = true;
            }
        }

        scanner.close();
    }
}