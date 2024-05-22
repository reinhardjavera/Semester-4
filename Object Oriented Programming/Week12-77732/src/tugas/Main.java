package tugas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Aktor> aktors = new ArrayList<>();
    private static List<Celebgram> celebgrams = new ArrayList<>();
    private static List<Majalah> majalahs = new ArrayList<>();
    private static List<Baliho> balihos = new ArrayList<>();
    private static List<Order> orders = new ArrayList<>();

    public static void main(String[] args) {
        tambahSeedData();

        boolean exit = false;
        while (!exit) {
            System.out.println("Wemen Marketing Agent");
            System.out.println("1. Penambahan Media");
            System.out.println("2. Penyewaan Media");
            System.out.println("3. Check Employment / Rental");
            System.out.println("4. Credits");
            System.out.println("5. Exit");
            System.out.print("Pilih Menu (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    tambahMedia();
                    break;
                case 2:
                    penyewaanMedia();
                    break;
                case 3:
                    lihatDanAturOrder();
                    break;
                case 4:
                    System.out.println("Wemen Marketing Agent");
                    System.out.println("Name : Axel Reginald Wiranto");
                    System.out.println("NIM : 00000078456");
                    System.out.println("Tekan apapun untuk melanjutkan.");
                    scanner.nextLine();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        }
    }

    private static void tambahSeedData() {
        // Seed data untuk Aktor
        aktors.add(new Aktor("Chris Evans", 30, 170, 60, 100000, "Captain America Lovers"));
        aktors.add(new Aktor("Robert Downey Jr", 31, 171, 61, 120000, "Ironman Lovers"));
        aktors.add(new Aktor("Chris Hemsworth", 32, 172, 62, 140000, "Thor Lovers"));

        // Seed data untuk Celebgram
        celebgrams.add(new Celebgram("Awkarin", 25, 165, 45, 100000, "Instagram", "Furnitur"));
        celebgrams.add(new Celebgram("Anya Geraldine", 26, 166, 46, 120000, "Twitter", "Makanan"));
        celebgrams.add(new Celebgram("Devina Aurel", 27, 167, 47, 140000, "Youtube", "Tanaman"));

        // Seed data untuk Majalah
        majalahs.add(new Majalah("Home Decor", 15, "Halaman 2", "Furnitur"));
        majalahs.add(new Majalah("Sedap", 18, "Halaman 3", "Makanan"));
        majalahs.add(new Majalah("Otomotif", 21, "Halaman 4", "Tanaman"));

        // Seed data untuk Baliho
        balihos.add(new Baliho("Baliho Jakarta Pusat", 6, "Jakarta Pusat"));
        balihos.add(new Baliho("Baliho Jakarta Barat", 8, "Jakarta Barat"));
        balihos.add(new Baliho("Baliho Jakarta Utara", 9, "Jakarta Utara"));
    }

    private static void tambahMedia() {
        System.out.println("Wemen Marketing Agent");
        System.out.println("1. Celebgram");
        System.out.println("2. Majalah");
        System.out.print("Pilih Media (1-2): ");
        int mediaChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (mediaChoice) {
            case 1:
                tambahCelebgram();
                break;
            case 2:
                tambahMajalah();
                break;
            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                break;
        }
    }

    private static void tambahCelebgram() {
        System.out.println("Wemen Marketing Agent - Penambahan Celebgram");
        System.out.println("1. Furnitur");
        System.out.println("2. Makanan");
        System.out.println("3. Tanaman");
        System.out.println("4. Otomotif");
        System.out.println("5. Musik");
        System.out.print("Pilih Kategori (1-5): ");
        int categoryChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String bidang = "";
        switch (categoryChoice) {
            case 1:
                bidang = "Furnitur";
                break;
            case 2:
                bidang = "Makanan";
                break;
            case 3:
                bidang = "Tanaman";
                break;
            case 4:
                bidang = "Otomotif";
                break;
            case 5:
                bidang = "Musik";
                break;
            default:
                System.out.println("Pilihan tidak valid. Bidang akan diatur ke default.");
                break;
        }

        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan umur: ");
        int umur = scanner.nextInt();
        System.out.print("Masukkan tinggi badan: ");
        int tinggiBadan = scanner.nextInt();
        System.out.print("Masukkan berat badan: ");
        int beratBadan = scanner.nextInt();
        System.out.print("Masukkan jumlah followers: ");
        int followers = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Masukkan media sosial yang digunakan: ");
        String akunMedia = scanner.nextLine();

        Celebgram celebgram = new Celebgram(nama, umur, tinggiBadan, beratBadan, followers, akunMedia, bidang);
        celebgrams.add(celebgram);
        System.out.println("Media baru telah dimasukkan.");
    }

    private static void tambahMajalah() {
        System.out.println("Wemen Marketing Agent - Penambahan Majalah");
        System.out.println("1. Furnitur");
        System.out.println("2. Makanan");
        System.out.println("3. Tanaman");
        System.out.println("4. Otomotif");
        System.out.println("5. Musik");
        System.out.print("Pilih Kategori (1-5): ");
        int categoryChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String bidang = "";
        switch (categoryChoice) {
            case 1:
                bidang = "Furnitur";
                break;
            case 2:
                bidang = "Makanan";
                break;
            case 3:
                bidang = "Tanaman";
                break;
            case 4:
                bidang = "Otomotif";
                break;
            case 5:
                bidang = "Musik";
                break;
            default:
                System.out.println("Pilihan tidak valid. Bidang akan diatur ke default.");
                break;
        }

        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan luas: ");
        int luas = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Masukkan letak halaman promosi: ");
        String letak = scanner.nextLine();

        Majalah majalah = new Majalah(nama, luas, letak, bidang);
        majalahs.add(majalah);
        System.out.println("Media baru telah dimasukkan.");
    }

    private static void penyewaanMedia() {
        System.out.println("Wemen Marketing Agent");
        System.out.println("1. Furnitur");
        System.out.println("2. Makanan");
        System.out.println("3. Tanaman");
        System.out.print("Pilih Kategori (1-3): ");
        int categoryChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Tanggal mulai (DDMMYYYY): ");
        String tanggal = scanner.nextLine();
        System.out.print("Banyak hari penyewaan: ");
        int jangkaWaktu = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String bidang = "";
        switch (categoryChoice) {
            case 1:
                bidang = "Furnitur";
                break;
            case 2:
                bidang = "Makanan";
                break;
            case 3:
                bidang = "Tanaman";
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                return;
        }

        int no = 1; // Reset nomor media

        System.out.println("\nDaftar Media yang Tersedia:");
        // Menampilkan aktor
        System.out.println("Influencer (Aktor):");
        for (Aktor aktor : aktors) {
            System.out.println("No: " + no++);
            System.out.println("Media: Aktor");
            System.out.println("Nama: " + aktor.getNama());
            System.out.println("Umur: " + aktor.getUmur());
            System.out.println("Tinggi Badan: " + aktor.getTinggiBadan());
            System.out.println("Berat Badan: " + aktor.getBeratBadan());
            System.out.println("Jumlah Fans: " + aktor.getFans());
            System.out.println("Nama Fans Club: " + aktor.getFanClub());
            System.out.println("Harga: " + (aktor.getFans() * 2000));
        }


        System.out.println("\nInfluencer (Celebgram):");
        for (Celebgram celebgram : celebgrams) {
            System.out.println("No: " + no++);
            System.out.println("Media: Celebgram");
            System.out.println("Nama: " + celebgram.getNama());
            System.out.println("Umur: " + celebgram.getUmur());
            System.out.println("Tinggi Badan: " + celebgram.getTinggiBadan());
            System.out.println("Berat Badan: " + celebgram.getBeratBadan());
            System.out.println("Jumlah Followers: " + celebgram.getFollowers());
            System.out.println("Akun Media Sosial: " + celebgram.getAkunMedia());
            System.out.println("Bidang: " + celebgram.getBidang());
            int hargaSewa = celebgram.getFollowers() * 1000;
            if (celebgram.getBidang().equalsIgnoreCase(bidang)) {
                hargaSewa += 500000;
            }
            System.out.println("Harga: " + hargaSewa);
        }


        System.out.println("\nObjek (Majalah):");
        for (Majalah majalah : majalahs) {
            System.out.println("No: " + no++);
            System.out.println("Media: Majalah");
            System.out.println("Nama: " + majalah.getNama());
            System.out.println("Luas: " + majalah.getLuas());
            System.out.println("Letak: " + majalah.getLetak());
            System.out.println("Bidang: " + majalah.getBidang());
            int hargaPemasangan = majalah.getLuas() * 50000;
            if (majalah.getBidang().equalsIgnoreCase(bidang)) {
                hargaPemasangan += 200000;
            }
            System.out.println("Harga: " + hargaPemasangan);
        }


        System.out.println("\nObjek (Baliho):");
        for (Baliho baliho : balihos) {
            System.out.println("No: " + no++);
            System.out.println("Media: Baliho");
            System.out.println("Nama: " + baliho.getNama());
            System.out.println("Luas: " + baliho.getLuas());
            System.out.println("Letak: " + baliho.getLetak());
            int hargaPemasangan = baliho.getLuas() * 3000000;
            System.out.println("Harga: " + hargaPemasangan);
        }

        System.out.print("\nMasukkan nomor media: ");
        int mediaChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Masukkan uang untuk pembayaran : ");
        int uangPembayaran = scanner.nextInt();


        switch (mediaChoice) {
            case 1: // Aktor
                Aktor aktor = aktors.get(mediaChoice - 1);
                int totalHargaAktor = aktor.getFans() * 2000;
                if (uangPembayaran >= totalHargaAktor) {
                    orders.add(new Order(aktor, bidang, tanggal, jangkaWaktu));
                    System.out.println("Pemesanan anda sukses.");
                } else {
                    System.out.println("Uang tidak mencukupi.");
                }
                break;
            case 2: // Celebgram
                Celebgram celebgram = celebgrams.get(mediaChoice - 1);
                int totalHargaCelebgram = celebgram.getFollowers() * 1000;
                if (celebgram.getBidang().equalsIgnoreCase(bidang)) {
                    totalHargaCelebgram += 500000;
                }
                if (uangPembayaran >= totalHargaCelebgram) {
                    orders.add(new Order(celebgram, bidang, tanggal, jangkaWaktu));
                    System.out.println("Pemesanan anda sukses.");
                } else {
                    System.out.println("Uang tidak mencukupi.");
                }
                break;
            case 3: // Majalah
                Majalah majalah = majalahs.get(mediaChoice - 1);
                int totalHargaMajalah = majalah.getLuas() * 50000;
                if (majalah.getBidang().equalsIgnoreCase(bidang)) {
                    totalHargaMajalah += 200000;
                }
                if (uangPembayaran >= totalHargaMajalah) {
                    orders.add(new Order(majalah, bidang, tanggal, jangkaWaktu));
                    System.out.println("Pemesanan anda sukses.");
                } else {
                    System.out.println("Uang tidak mencukupi.");
                }
                break;
            case 4: // Baliho
                Baliho baliho = balihos.get(mediaChoice - 1);
                int totalHargaBaliho = baliho.getLuas() * 3000000;
                if (uangPembayaran >= totalHargaBaliho) {
                    orders.add(new Order(baliho, bidang, tanggal, jangkaWaktu));
                    System.out.println("Pemesanan anda sukses.");
                } else {
                    System.out.println("Uang tidak mencukupi.");
                }
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }
    }


    private static void lihatDanAturOrder() {
        System.out.println("Wemen Marketing Agent - Lihat dan Atur Order");

        // Menampilkan daftar order
        int index = 1;
        for (Order order : orders) {
            System.out.println("No : " + index);
            System.out.println("Media : " + order.getMediaPromosi().getClass().getSimpleName());
            System.out.println("Nama : " + order.getMediaPromosi().getNama());
            System.out.println("Tanggal : " + order.getTanggal());
            System.out.println("Durasi Kontrak : " + order.getJangkaWaktu());
            System.out.println("Harga : " + order.getMediaPromosi().getHarga());
            index++;
        }

        // Memilih order untuk diatur
        System.out.print("Pilih order yang ingin diatur (1-" + orders.size() + "): ");
        int orderChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Memeriksa apakah order dapat dibatalkan
        Order selectedOrder = orders.get(orderChoice - 1);
        if (orderBisaDibatalkan(selectedOrder)) {
            // Menampilkan pilihan untuk batalkan order atau kembali
            System.out.println("1. Batalkan Order");
            System.out.println("2. Kembali ke menu utama");
            System.out.print("Pilih menu (1-2): ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    // Batalkan order
                    orders.remove(selectedOrder);
                    System.out.println("Pesanan berhasil dibatalkan.");
                    break;
                case 2:
                    // Kembali ke menu utama
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        } else {
            System.out.println("Pesanan ini tidak bisa dibatalkan.");
        }
    }

    // Fungsi untuk memeriksa apakah order bisa dibatalkan
    private static boolean orderBisaDibatalkan(Order order) {
        // Implementasi logika pengecekan apakah order bisa dibatalkan
        LocalDate tanggalOrder = LocalDate.parse(order.getTanggal(), DateTimeFormatter.ofPattern("ddMMyyyy"));
        LocalDate tanggalUjian = LocalDate.of(2024, 5, 20); // Sesuaikan dengan tanggal ujian
        return !tanggalOrder.isEqual(tanggalUjian);
    }
}