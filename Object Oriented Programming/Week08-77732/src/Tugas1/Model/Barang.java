package Tugas1.Model;

public class Barang {
    protected int id;
    protected double harga;
    protected String nama;
    protected int stok;

    public Barang(int id, String nama, double harga, int stok) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public void minuStok(int jml) {
        // Logic to decrease stock by jml
    }
}