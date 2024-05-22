package tugas;

import java.util.*;

public class Main {
		static ArrayList<Karyawan> karyawanList = new ArrayList<Karyawan>();
		static Scanner s = new Scanner(System.in);
		
		public static void mainMenu() {
			System.out.println("-----Program Data Karyawan-----");
			System.out.println("1. Lihat Karyawan");
			System.out.println("2. Tambah Karyawan");
			System.out.println("3. Keluar");
		}
		
		public static void lihatKaryawan() {
			int m = 1, r = 1, i = 1;
			boolean managerExists = false;
			boolean tetapExists = false;
			boolean magangExists = false;
			for(Karyawan karyawan : karyawanList) {
				if(karyawan instanceof Manager) {
					System.out.println("-----Daftar Manager-----");
					managerExists = true;
					System.out.println("ID        : M" + m++);
					System.out.println("Nama      : " + karyawan.getNama());
					System.out.println("Gaji      : Rp. " + karyawan.getGaji());
					System.out.println("-----------------------------");
				}
			}
			if(!managerExists) {
				System.out.println("-----Daftar Manager-----");
				System.out.println("Tidak ada");
			}
			
			for(Karyawan karyawan : karyawanList) {
				if(karyawan instanceof Tetap) {
					System.out.println("-----Daftar Pegawai Tetap-----");
					tetapExists = true;
					System.out.println("ID        : R" + r++);
					System.out.println("Nama      : " + karyawan.getNama());
					System.out.println("Gaji      : Rp. " + karyawan.getGaji());
					System.out.println("-----------------------------");
				}
			}
			if(!tetapExists) {
				System.out.println("-----Daftar Pegawai Tetap-----");
				System.out.println("Tidak ada");
			}
			
			for(Karyawan karyawan : karyawanList) {
				if(karyawan instanceof Magang) {
					System.out.println("-----Daftar Pegawai Magang-----");
					magangExists = true;
					System.out.println("ID        : I" + i++);
					System.out.println("Nama      : " + karyawan.getNama());
					System.out.println("Gaji      : Rp. " + karyawan.getGaji());
					System.out.println("-----------------------------");
				}
			}
			if(!magangExists) {
				System.out.println("-----Daftar Pegawai Magang-----");
				System.out.println("Tidak ada");
			}
		}
		
		public static void tambahKaryawan() {
			int pilih;
			System.out.println("-----Tambah Karyawan-----");
			System.out.println("1. Manager");
			System.out.println("2. Karyawan Tetap");
			System.out.println("3. Karyawan Magang");
			System.out.print("Pilih : ");
			pilih = s.nextInt();
			if(pilih == 1) {
				System.out.print("Nama : ");
				String nama = s.next();
				s.nextLine();
				Karyawan karyawan = new Manager("", nama);
				karyawanList.add(karyawan);
				System.out.println("Manager baru telah ditambahkan");
			}
			else if(pilih == 2) {
				System.out.print("Nama : ");
				String nama = s.next();
				s.nextLine();
				Karyawan karyawan = new Tetap("", nama);
				karyawanList.add(karyawan);
				System.out.println("Pegawai tetap baru telah ditambahkan");
			}
			else if(pilih == 3) {
				System.out.print("Nama : ");
				String nama = s.next();
				s.nextLine();
				Karyawan karyawan = new Magang("", nama);
				karyawanList.add(karyawan);
				System.out.println("Pegawai magang baru telah ditambahkan");
			}
			else {
				System.out.println("Silahkan masukan input yang benar");
				return;
			}
		}
		
		public static void main(String[] args) {
			int menu;
			for(;;) {
				mainMenu();
				System.out.print("Pilihan : ");
				menu = s.nextInt();
				switch(menu) {
					case 1:
						lihatKaryawan();
						break;
					case 2:
						tambahKaryawan();
						break;
					case 3:
						System.exit(0);
						break;
					default:
						System.out.println("Masukkan input yang benar");
						break;
				}
			}

		}
	}

