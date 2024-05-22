package tugas;

public class Majalah extends MediaPromosi{
    private int luas;
    private String letak;
    private String bidang;

    public Majalah() {
        super();
    }
    public Majalah(String nama, int luas, String letak,String bidang) {
        super(nama, 0);
        this.luas = luas;
        this.letak = letak;
        this.bidang = bidang;
    }
    public int getLuas() {
        return this.luas;
    }
    public String getLetak() {
        return this.letak;
    }
    public String getBidang() {
        return this.bidang;
    }
}
