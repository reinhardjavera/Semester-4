package tugas;

public class Voucher extends Barang{
	private double pajak;
	public static int total;
	
	
	public Voucher(int id, String nama, double harga, int stock, double pajak) {
		super(id, harga, nama, stock);
		this.pajak = pajak;
	}
	
	public double getPajak() {
		return pajak;
	}
	
	public double gethargaJual() {
		return (int) harga + (harga*pajak);
	}

}
