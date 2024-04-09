package tugas;

public class Handphone extends Barang{
	private String warna;
	public static int total;
	
	public Handphone() {}
	public Handphone(int id, String nama, double harga, int stock, String warna) {
		super(id, harga, nama, stock);
		this.warna = warna;
	}
	
	public String getWarna() {
		return warna;
	}
}
