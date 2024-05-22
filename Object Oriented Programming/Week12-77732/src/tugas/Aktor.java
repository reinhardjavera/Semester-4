package tugas;

public class Aktor extends MediaPromosi{
    private int umur;
    private int tinggiBadan;
    private int beratBadan;
    private int fans;
    private String fanClub;

    public Aktor() {
        super();
    }
    public Aktor(String nama, int umur, int tinggiBadan, int beratBadan , int fans, String fanclub) {
        super(nama,0);
        this.umur = umur;
        this.tinggiBadan = tinggiBadan;
        this.beratBadan = beratBadan;
        this.fans = fans;
        this.fanClub = fanclub;
    }
    public int getUmur() {
        return this.umur;
    }
    public int getTinggiBadan() {
        return this.tinggiBadan;
    }
    public int getBeratBadan() {
        return this.beratBadan;
    }
    public int getFans() {
        return this.fans;
    }
    public String getFanClub() {
        return this.fanClub;
    }

}
