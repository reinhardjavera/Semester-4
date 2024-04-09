package tugas;

public class Barang {
	protected int id, stock;
	protected double harga;
	protected String nama;
	
	public Barang() {}
	public Barang (int id, double harga, String nama, int stock) {
		this.id = id;
		this.harga = harga;
		this.nama = nama;
		this.stock = stock;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNama() {
		return nama;
	}
	
	public double getHarga() {
		return harga;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void minusStock(int jmlh) {
		this.stock -= jmlh;
	}
}