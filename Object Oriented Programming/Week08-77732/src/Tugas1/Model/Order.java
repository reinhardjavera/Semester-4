package Tugas1.Model;

public class Order {
    private String id;
    private Barang barang;
    private int jumlah;

    public Order(String id, Barang barang, int jumlah) {
        this.id = id;
        this.barang = barang;		
        this.jumlah = jumlah;
    }

    public String getId() {
        return id;
    }

    public Barang getBarang() {
        return barang;
    }

    public int getJumlah() {
        return jumlah;
    }
}
