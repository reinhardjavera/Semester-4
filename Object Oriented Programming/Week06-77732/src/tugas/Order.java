package tugas;

public class Order {
	private int id;
	private Voucher voucher;
	private Handphone handphone;
	private int jumlah;
	public String hargaTotal;
	public static int total;
	
	public Order(int id, Voucher voucher, int jumlah) {
		this.id = id;
		this.voucher = voucher;
		this.jumlah = jumlah;
	}
	
	public Order(int id, Handphone handphone, int jumlah) {
		this.id = id;
		this.handphone = handphone;
		this.jumlah = jumlah;
	}
	
	public int getId() {
		return id;
	}
	public Voucher getVoucher() {
		return voucher;
	}
	public Handphone getHandphone() {
		return handphone;
	}
	public int getJumlah() {
		return jumlah;
	}
}
