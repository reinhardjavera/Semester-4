package tugas;

public class MediaPromosi {
    private String nama;
    private int harga;

    public MediaPromosi(){

    }
    public MediaPromosi(String nama, int harga){
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama(){
        return this.nama;
    }

    public int getHarga(){
        return this.harga;
    }
}
