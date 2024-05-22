package tugas;

public class Order {
    private MediaPromosi mediaPromosi;
    private String bidang;
    private String tanggal;
    private int jangkaWaktu;

    public Order() {

    }
    public Order(MediaPromosi mediaPromosi, String bidang, String tanggal, int jangkaWaktu) {
        this.mediaPromosi = mediaPromosi;
        this.bidang = bidang;
        this.tanggal = tanggal;
        this.jangkaWaktu = jangkaWaktu;
    }
    public MediaPromosi getMediaPromosi() {
        return this.mediaPromosi;
    }
    public String getBidang() {
        return this.bidang;
    }
    public String getTanggal() {
        return this.tanggal;
    }
    public int getJangkaWaktu() {
        return this.jangkaWaktu;
    }
}
