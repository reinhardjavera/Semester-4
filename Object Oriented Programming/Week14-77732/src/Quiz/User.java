package Quiz;

public class User {
    private String nama;
    private String username;
    private String password;
    private boolean isBanned;

    public User(String nama, String username, String password) {
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.isBanned = false;
    }

    public String getNama() {
        return nama;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean isBanned) {
        this.isBanned = isBanned;
    }
}
