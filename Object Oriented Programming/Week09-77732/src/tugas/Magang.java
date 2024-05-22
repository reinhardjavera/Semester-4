package tugas;

public class Magang extends Karyawan {
	public Magang() {}
	public Magang(String id, String nama) {
		super(id, nama);
	}
	
	public int getGaji() {
		return 1500000;
	}
}
