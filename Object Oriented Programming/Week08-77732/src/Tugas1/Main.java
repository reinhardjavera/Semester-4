package Tugas1;

import Tugas1.Model.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
    private static ArrayList<Barang> barangs = new ArrayList<>();
    private static ArrayList<Order> orders = new ArrayList<>();
    private static int orderIdCounter = 1;

    public static void main(String[] args) {
        initializeData(); // Sample data

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("-----------Menu Toko Voucher & HP-----------");
            System.out.println("1. Pesan Barang");
            System.out.println("2. Lihat Barang");
            System.out.println("3. Barang Baru");
            System.out.print("Pilihan : ");

            String choiceString = scanner.next();

            int choice = 0;
            try {
                choice = Integer.parseInt(choiceString);
            } catch (NumberFormatException e) {
                if (choiceString.equalsIgnoreCase("o")) {
                    exit = true;
                    System.out.println("Terima kasih telah menggunakan layanan kami.");
                    break;
                } else {
                    System.out.println("Pilihan tidak valid, silakan pilih lagi.");
                    continue;
                }
            }

            switch (choice) {
                case 1:
                    pesanBarang(scanner);
                    break;
                case 2:
                    lihatBarang();
                    break;
                case 3:
                    tambahBarang(scanner);
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }

        scanner.close();
    }

    private static void pesanBarang(Scanner scanner) {
        while (true) {
            System.out.println("Daftar Barang yang Tersedia:");
            System.out.println("1. Handphone");
            System.out.println("2. Voucher");
            System.out.print("Pilih barang: ");
            String choiceString = scanner.next();
            if (choiceString.equalsIgnoreCase("o")) {
                return;
            }

            // Convert integer
            int choice = 0;
            try {
                choice = Integer.parseInt(choiceString);
            } catch (NumberFormatException e) {
                System.out.println("Pilihan tidak valid, silakan pilih lagi.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Daftar Handphone yang Tersedia:");
                    for (Barang barang : barangs) {
                        if (barang instanceof Handphone) {
                            Handphone hp = (Handphone) barang;
                            System.out.println("ID:  " + hp.getId());
                            System.out.println("Nama: " + hp.getNama());
                            System.out.println("Stock: " + hp.getStok());
                            System.out.println("Harga: " + formatCurrency(hp.getHarga()));
                            System.out.println("--------------------------------------------");
                        }
                    }
                    System.out.print("Pesan Barang (ID) : ");
                    int hpId = scanner.nextInt();
                    Handphone handphone = (Handphone) findBarangById(hpId);
                    if (handphone != null) {
                        System.out.println("Masukkan jumlah barang: ");
                        int jumlah = scanner.nextInt();
                        if (jumlah > 0 && jumlah <= handphone.getStok()) {
                            System.out.println(jumlah + " @ " + handphone.getNama() + " dengan total harga " + formatCurrency(handphone.getHarga() * jumlah));
                            System.out.println("Masukkan jumlah uang : ");
                            double uang = scanner.nextDouble();
                            double total = handphone.getHarga() * jumlah;
                            if (uang >= total) {
                                orders.add(new Order("OH" + orderIdCounter++, handphone, jumlah));
                                System.out.println("Berhasil Dipesan");
                            } else {
                                System.out.println("Jumlah uang tidak mencukupi");
                            }
                        } else {
                            System.out.println("Jumlah barang tidak valid atau stok tidak mencukupi.");
                        }
                    } else {
                        System.out.println("Handphone dengan ID tersebut tidak tersedia.");
                    }
                    break;
                case 2:
                    System.out.println("Daftar Voucher yang Tersedia:");
                    for (Barang barang : barangs) {
                        if (barang instanceof Voucher) {
                            Voucher v = (Voucher) barang;
                            double hargaTotal = v.getHarga() * (1 + v.getPajak());
                            double ppn = v.getHarga() * v.getPajak();
                            System.out.println("ID:  " + v.getId());
                            System.out.println("Nama: " + v.getNama());
                            System.out.println("Nominal: " + formatCurrency(v.getHarga()));
                            System.out.println("PPN: " + formatCurrency(ppn));
                            System.out.println("Stock: " + v.getStok());
                            System.out.println("Harga: " + formatCurrency(hargaTotal));
                            System.out.println("--------------------------------------------");
                        }
                    }
                    System.out.print("Pesan Barang (ID) : ");
                    int vId = scanner.nextInt();
                    Voucher voucher = (Voucher) findBarangById(vId);
                    if (voucher != null) {
                        System.out.println("Masukkan jumlah barang: ");
                        int jumlah = scanner.nextInt();
                        if (jumlah > 0 && jumlah <= voucher.getStok()) {
                            double total = voucher.getHarga() * (1 + voucher.getPajak()) * jumlah;
                            double ppn = voucher.getHarga() * voucher.getPajak();
                            System.out.println(jumlah + " @ " + voucher.getNama() + " dengan total harga " + formatCurrency(total));
                            System.out.println("PPN: " + formatCurrency(ppn));
                            System.out.println("Masukkan jumlah uang : ");
                            double uang = scanner.nextDouble();
                            if (uang >= total) {
                                orders.add(new Order("OV" + orderIdCounter++, voucher, jumlah));
                                System.out.println("Berhasil Dipesan");
                            } else {
                                System.out.println("Jumlah uang tidak mencukupi");
                            }
                        } else {
                            System.out.println("Jumlah barang tidak valid atau stok tidak mencukupi.");
                        }
                    } else {
                        System.out.println("Voucher dengan ID tersebut tidak tersedia.");
                    }
                    break;
            }
        }
    }

    private static void lihatBarang() {
        System.out.println("Daftar Barang Toko Voucher & HP");
        System.out.println("Handphone:");
        for (Barang barang : barangs) {
            if (barang instanceof Handphone) {
                Handphone hp = (Handphone) barang;
                System.out.println("ID:  " + hp.getId());
                System.out.println("Nama: " + hp.getNama());
                System.out.println("Stock: " + hp.getStok());
                System.out.println("Harga: " + formatCurrency(hp.getHarga()));
                System.out.println("--------------------------------------------");
            }
        }
        System.out.println("Voucher:");
        for (Barang barang : barangs) {
            if (barang instanceof Voucher) {
                Voucher v = (Voucher) barang;
                double hargaTotal = v.getHarga() * (1 + v.getPajak());
                double ppn = v.getHarga() * v.getPajak();
                System.out.println("ID:  " + v.getId());
                System.out.println("Nama: " + v.getNama());
                System.out.println("PPN: " + formatCurrency(ppn));
                System.out.println("Nominal: " + formatCurrency(v.getHarga()));
                System.out.println("Stock: " + v.getStok());
                System.out.println("Harga: " + formatCurrency(hargaTotal));
                System.out.println("--------------------------------------------");
            }
        }
    }

    private static void tambahBarang(Scanner scanner) {
        System.out.print("Voucher / Handphone (V/H): ");
        String choice = scanner.next();
        switch (choice) {
            case "V":
                System.out.print("Nama: ");
                String vNama = scanner.next();
                System.out.print("Harga: ");
                double vHarga = scanner.nextDouble();
                System.out.print("Stok: ");
                int vStok = scanner.nextInt();
                System.out.print("PPN (dalam desimal): ");
                double pajak = scanner.nextDouble();
                barangs.add(new Voucher(barangs.size() + 1, vNama, vHarga, vStok, pajak));
                System.out.println("Voucher telah berhasil diinput.");
                break;
            case "H":
                System.out.print("Nama: ");
                String hpNama = scanner.next();
                System.out.print("Harga: ");
                double hpHarga = scanner.nextDouble();
                System.out.print("Stok: ");
                int hpStok = scanner.nextInt();
                System.out.print("Warna: ");
                String hpWarna = scanner.next();
                barangs.add(new Handphone(barangs.size() + 1, hpNama, hpHarga, hpStok, hpWarna));
                System.out.println("Handphone telah berhasil diinput.");
                break;
            default:
                System.out.println("Input tidak valid.");
                break;
        }
    }


    private static void initializeData() {
        barangs.add(new Handphone(1, "Samsung S9+ Hitam", 14499000, 10, "Hitam"));
        barangs.add(new Handphone(2, "Samsung S9+ Putih", 17999000, 10, "Putih"));
        barangs.add(new Voucher(3, "Google Play", 20000, 100, 0.1));
        barangs.add(new Voucher(4, "iTunes", 30000, 50, 0.05));
    }

    private static Barang findBarangById(int id) {
        for (Barang barang : barangs) {
            if (barang.getId() == id) {
                return barang;
            }
        }
        return null;
    }

    private static String formatCurrency(double amount) {
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        return formatter.format(amount);
    }

}
