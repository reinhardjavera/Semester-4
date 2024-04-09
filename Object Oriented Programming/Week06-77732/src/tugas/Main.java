package tugas;

import java.util.Scanner;

import java.util.*;

public class Main {
	static HashMap<Integer, Handphone> handphone = new HashMap<>();
	static HashMap<Integer, Voucher> voucher = new HashMap<>();
	static List<Voucher> vcr = new ArrayList<Voucher>();
	static List<Handphone> hp = new ArrayList<Handphone>();
	static List<Order> pemesanan = new ArrayList<>();
	
	public static void mainMenu() {
		System.out.println("==========Menu Toko Voucher & HP==========");
		System.out.println("1. Pesan Barang");
		System.out.println("2. Lihat Pesanan");
		System.out.println("3. Barang Baru");
	}
	
	public static void pesanBarang() {
		Scanner scan = new Scanner(System.in);
		int pilihan;
		System.out.println("Daftar Barang Toko Voucher & HP");
		System.out.println("1. Handphone");
		System.out.println("2. Voucher");
		pilihan = scan.nextInt();
		if(pilihan == 1) {
			int id = 0, jml;
			double hargaTotal;
			for(Handphone hp : handphone.values()) {
				System.out.println("ID 	: " +hp.getId());
				System.out.println("Nama 	: " +hp.getNama());
				System.out.println("Stock 	: " +hp.getStock());
				System.out.println("Harga 	: " +hp.getHarga());
				System.out.println("------------------------------------");
			}
			System.out.println("Ketik 0 untuk batal");
			System.out.println("Pesan Barang (masukkan id barang yang ingin dipesan): ");
			int Id = scan.nextInt();
			if(Id == 0) {
				return;
			}
			Handphone pilih = handphone.get(id);
			if(pilih == null) {
				System.out.println("Barang tidak ada yang Tersedia!");
			}
			for(;;) {
				System.out.print("Masukkan Jumlah yang Ingin Dipesan : ");
				jml = scan.nextInt();
				break;
				}
		}else if(pilihan == 2) {
			int id = 0, jml;
			double hargaTotal;
			for(Voucher vo : vcr) {
				System.out.println("ID 	: " + vo.getId());
				System.out.println("Nama 	: " +vo.getNama());
				System.out.println("Stock 	: " +vo.getStock());
				System.out.println("Harga 	: " +vo.getHarga());
				System.out.println("------------------------------------");
			}
			System.out.println("Ketik 0 untuk batal");
			System.out.println("Pesan Barang (masukkan id barang yang ingin dipesan): ");
			int Id = scan.nextInt();
			
			Voucher pilihln = voucher.get(id);
			if(pilihln == null) {
				System.out.println("Tidak Ada Barang yang Tersedia!");
			}
			for(;;) {
				System.out.print("Masukkan Jumlah yang Ingin Dipesan : ");
				jml = scan.nextInt();
				System.out.println("Stok tidak Mencukupi");
			}
			} 
	}
	
	public static void Pesanan() {
		double hargaTotal;
		System.out.println("Daftar Pesanan Toko Multiguna");
		if(Order.total != pemesanan.size()) {
			System.out.println("Terdapat kesalahan");
		}
		System.out.println("Jumlah Pesanan di Keranjang Anda : " +pemesanan.size());
		if(pemesanan.size()==0) {
			System.out.println("Belum ada Pesanan Anda!");
		}
		System.out.print("\n");
		int a = 1;
		for(Order input : pemesanan) {
		System.out.println("Nomor : " +a); a++;
		System.out.println("Id : "+input.getId());
		if(input.getHandphone() != null) {
			System.out.println("Nama : "+input.getHandphone().nama);
		}else {
			System.out.println("Nama : "+input.getVoucher().nama);
			System.out.println("Jumlah : "+input.getJumlah());
			System.out.println("Total : "+input.hargaTotal);
		}
		System.out.println("\n");
		}
	}
	
	public static void InputBarang() {
		String nama, warna, pilihan;
		double harga, pajak;
		int stok, idVcr = 0, id = 0;
		Scanner scn = new Scanner(System.in);
		System.out.print("Voucher / Handphone (V/H) : ");
		pilihan = scn.next();
		scn.nextLine();
		if("V".equals(pilihan) || "v".equals(pilihan)) {
			System.out.print("Nama : ");nama = scn.nextLine();
			System.out.print("Harga : ");harga = scn.nextDouble();
			System.out.print("Stok : ");stok = scn.nextInt();
			System.out.print("PPN : ");pajak = scn.nextDouble();
			System.out.println("Voucher telah berhasil diinput");
			vcr.add(new Voucher(idVcr, nama, harga, stok, pajak));
		}else if("H".equals(pilihan) ||"h".equals(pilihan)) {
			System.out.print("Nama : ");nama = scn.nextLine();
			System.out.print("Harga : ");harga = scn.nextDouble();
			System.out.print("Stok : ");stok = scn.nextInt();scn.nextLine();
			System.out.print("Warna : ");warna = scn.nextLine();
			hp.add(new Handphone(id, nama, harga, stok, pilihan));
		}else {
			System.out.println("Masukkan Pilihan Yang tersedia!");
			return;
		}
	}
	
		private static void newBarang(Voucher voucher2) {
		}

		private static void newBarang(Handphone pilih) {
		}
		
	public static void main(String[] args) {
		int pilihan;
		Scanner scann = new Scanner(System.in);
		for(;;) {
			mainMenu();
			System.out.print("Pilihan : ");
			pilihan = scann.nextInt();
			switch(pilihan) {
			case 1 : 
				pesanBarang();
				break;
			case 2:
				Pesanan();
				break;
			case 3: 
				InputBarang();
				break;
			default:
				System.out.println("Masukkan Pilihan Yang Tepat");
			}
		}
	}
}
