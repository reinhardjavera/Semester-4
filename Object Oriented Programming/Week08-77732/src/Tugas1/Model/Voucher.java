package Tugas1.Model;

public class Voucher extends Barang {
    private double pajak;

    public Voucher(int id, String nama, double harga, int stok, double pajak) {
        super(id, nama, harga, stok);
        this.pajak = pajak;
    }

    public double getPajak() {
        return pajak;
    }

    public void setPajak(double pajak) {
        this.pajak = pajak;
    }
}