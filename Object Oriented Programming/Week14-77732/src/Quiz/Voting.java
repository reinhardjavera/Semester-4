package Quiz;

import java.util.List;
import java.util.Scanner;
import java.util.HashMap;

public class Voting {
    private List<User> users;
    private List<Paslon> paslonList;
    private HashMap<String, Integer> loginAttempts;

    public Voting(List<User> users, List<Paslon> paslonList) {
        this.users = users;
        this.paslonList = paslonList;
        this.loginAttempts = new HashMap<>();
    }

    public void handleLogin(Scanner scanner) throws PesanError {
        while (true) {
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            try {
                login(username, password, scanner);
                break; // Berhasil login, keluar dari loop
            } catch (PesanError e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public void login(String username, String password, Scanner scanner) throws PesanError {
        if (loginAttempts.containsKey(username) && loginAttempts.get(username) >= 5) {
            throw new PesanError("Akun Anda telah dibanned karena terlalu banyak mencoba login.");
        }

        User currentUser = null;

        // Mencari user berdasarkan username dan password
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                if (user.isBanned()) {
                    throw new PesanError("Akun Anda telah dibanned.");
                }

                if (user.getPassword().equals(password)) {
                    currentUser = user;
                } else {
                    loginAttempts.put(username, loginAttempts.getOrDefault(username, 0) + 1);
                    if (loginAttempts.get(username) >= 5) {
                        user.setBanned(true);
                        throw new PesanError("Akun Anda telah dibanned karena terlalu banyak mencoba login.");
                    } else {
                        throw new PesanError("Password salah. Anda telah mencoba " + loginAttempts.get(username) + " kali.");
                    }
                }
                break;
            }
        }

        if (currentUser == null) {
            throw new PesanError("Username atau password salah.");
        } else {
            if (currentUser instanceof Admin) {
                // Admin dapat melihat hasil voting
                System.out.println("Hasil Voting:");
                for (Paslon paslon : paslonList) {
                    System.out.println(paslon.getNama() + ": " + paslon.getJumlahSuara() + " suara");
                }
            } else if (currentUser instanceof Peserta) {
                // Peserta dapat melakukan vote
                System.out.println("Pilih Paslon:");
                for (int i = 0; i < paslonList.size(); i++) {
                    System.out.println((i + 1) + ". " + paslonList.get(i).getNama());
                }

                System.out.print("Pilihan Anda: ");
                int pilihan = scanner.nextInt();
                scanner.nextLine();  // Consume the newline

                if (pilihan >= 1 && pilihan <= paslonList.size()) {
                    Paslon paslon = paslonList.get(pilihan - 1);
                    paslon.tambahSuara();
                    System.out.println("Vote berhasil!");
                } else {
                    throw new PesanError("Pilihan tidak valid.");
                }
            }
        }
    }
}
