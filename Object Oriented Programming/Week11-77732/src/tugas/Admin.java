package tugas;

public class Admin extends User {
    public Admin(String email, String password) {
        super(email, password);
    }

    public void sendEmail(String recipient, String status) {
        String message;
        if (status.equals("Lolos")) {
            message = "Congratulation! You being advanced to step 2 : Interview process.";
        } else {
            message = "Unfortunately, based on the result we will not be advancing your application to the next step.";
        }
        System.out.println("Email sent to " + recipient + ": " + message);
    }
}