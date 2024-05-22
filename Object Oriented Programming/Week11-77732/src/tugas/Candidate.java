package tugas;

public class Candidate extends User {
    public Candidate(String email, String password) {
        super(email, password);
    }
    public void receiveMessage(String message) {
        sendMessage(message);
    }
}