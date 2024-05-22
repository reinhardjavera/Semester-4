package tugas;

public class Manager extends Karyawan {
	public Manager() {}
	public Manager(String id, String nama) {
		super(id, nama);
	}
	
	public int getGaji() {
		return 10000000;
	}
}
