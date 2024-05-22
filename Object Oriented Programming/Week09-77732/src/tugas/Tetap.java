package tugas;

public class Tetap extends Karyawan{
	public Tetap() {}
	public Tetap(String id, String nama) {
		super(id, nama);
	}
	
	public int getGaji() {
		return 3000000;
	}
}
