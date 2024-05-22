package tugas;

public class Celebgram extends MediaPromosi{
    private int umur;
    private int tinggiBadan;
    private int beratBadan;
    private int followers;
    private String akunMedia;
    private String bidang;

    public Celebgram() {
        super();
    }

    public Celebgram(String nama, int umur, int tinggiBadan,int beratBadan , int followers, String akunMedia, String bidang) {
        super(nama, 0);
        this.umur = umur;
        this.tinggiBadan = tinggiBadan;
        this.beratBadan = beratBadan;
        this.followers = followers;
        this.akunMedia = akunMedia;
        this.bidang = bidang;
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
    public int getFollowers() {
        return this.followers;
    }
    public String getAkunMedia() {
        return this.akunMedia;
    }
    public String getBidang() {
        return this.bidang;
    }
}