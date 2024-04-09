package tugas;

public class Barang {
	private int id, stock, harga;
	private String nama;
	
	public Barang() {}
	public Barang(int id, int stock, int harga, String nama) {
		this.id = id;
		this.stock = stock;
		this.harga = harga;
		this.nama = nama;
	}
	
	public int getId() {
		return id;
	}

	public int getStock() {
		return stock;
	}

	public int getHarga() {
		return harga;
	}

	public String getNama() {
		return nama;
	}
	
	public void minusStock(int qty) {
		this.stock -= qty; 
	}

}
