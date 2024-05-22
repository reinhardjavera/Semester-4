package tugas;

public class User {
    String email;
    String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public void sendMessage(String message) {
        System.out.println("Message: " + message);
    }
}