package tugas;
import java.util.Scanner;

public class Menu {
	static Barang[] barang = new Barang[5];
	
	public static void isiBarang() {
		barang[0] = new Barang(1, 120, 2000, "Pulpen Easy Gel 0.5mm");
		barang[1] = new Barang(2, 20, 5000, "Penggaris 30cm");
		barang[2] = new Barang(3, 30, 7000, "Tipe X Roller");
		barang[3] = new Barang(4, 50, 5000, "Pensil Mekanik");
		barang[4] = new Barang(5, 100, 6000, "Buku Tulis");
	}
	
	static Order[] order = new Order[0];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		isiBarang();

		while(true) {
			System.out.println("-------Menu Toko Multiguna-------");
			System.out.println("1. Pesan Barang");
			System.out.println("2. Lihat Pesanan");
			System.out.print("Pilihan: ");
			int menu = scan.nextInt();
			
			switch(menu) {
				case 1:
					order = pesanBarang(scan, order);
					break;
				case 2:
					lihatPesanan(order);
					break;
			}
		}
	}
	
	public static void menuBarang() {
		System.out.println("Daftar Barang Toko Multiguna");
		for(int i=0; i<5; i++) {
			System.out.println("ID\t: "+barang[i].getId());
			System.out.println("Nama\t: "+barang[i].getNama());
			System.out.println("Stock\t: "+barang[i].getStock());
			System.out.println("Harga\t: "+barang[i].getHarga());
			System.out.println("---------------------------------");
		}
	}
	
	public static Order[] pesanBarang(Scanner scan, Order[] order) {	//Mungkin bisa pakai Class Order untuk return ke array Order
		//Pilih barang
		menuBarang();
		System.out.println("Ketik 0 untuk batal");
		
		System.out.print("Pesan Barang (ID): ");
		int idPesan = scan.nextInt();
		if(idPesan == 0 || idPesan > barang.length) {
			return null;
		}
		
		
		//Pesan jumlah barang dan bayar barang
		int qtyPesan;
		do {
			System.out.print("Masukkan Jumlah: ");
			qtyPesan = scan.nextInt();
		}while(qtyPesan <= 0 || qtyPesan > barang[idPesan-1].getStock());
		
		barang[idPesan-1].minusStock(qtyPesan);
		int harusBayar = barang[idPesan-1].getHarga()*qtyPesan;
		
		System.out.println(qtyPesan+" @ "+barang[idPesan-1].getNama()+" dengan total harga "+harusBayar);
		int totalBayar;
		
		
		//Proses simpan Order Barang
		do {
			System.out.print("Masukkan Jumlah Uang: ");
			totalBayar = scan.nextInt();
			if(totalBayar < harusBayar) {
				System.out.println("Jumlah uang tidak mencukupi");
			}
			else if(totalBayar > harusBayar) {
				System.out.println("Jumlah uang yang dimasukkan harus pas!");
			}
			else {
				int n = order.length;
				Order pesan = new Order(n+1, barang[idPesan-1], qtyPesan);
				Order[] newOrder = new Order[n+1];

				for(int i = 0; i<n+1; i++) {
					if(i<n) {
						newOrder[i] = order[i];
					}
					else {
						newOrder[i] = pesan;
					}
				}
				order = newOrder;
				
				System.out.println("Berhasil dipesan");
				return order;
			}
		}while(true);
	}

	
	public static void lihatPesanan(Order[] order) {
		System.out.println("-------Menu Toko Multiguna-------");
		for(int i=0; i<order.length;i++) {
			int idPesan = order[i].getId();
			String namaPesan = order[i].getBarang().getNama();
			int jumlahPesan = order[i].getJumlah();
			int totalPesan = order[i].getJumlah()*order[i].getBarang().getHarga();
			
			System.out.println("ID\t: "+idPesan);
			System.out.println("Nama\t: "+namaPesan);
			System.out.println("Jumlah\t: "+jumlahPesan);
			System.out.println("Total\t: "+totalPesan);
			System.out.println("---------------------------------");
		}
	}

}
