package tugas;

public class Baliho extends MediaPromosi{
    private int luas;
    private String letak;

    public Baliho() {
        super();
    }
    public Baliho(String nama, int luas, String letak) {
        super(nama,0);
        this.luas = luas;
        this.letak = letak;
    }
    public int getLuas() {
        return this.luas;
    }
    public String getLetak() {
        return this.letak;
    }
}
