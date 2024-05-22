package tugas;

import java.util.*;


public class FMCGRecruitmentSystem {
    static List<User> users = new ArrayList<>();
    static List<JobApplication> submissions = new ArrayList<>();
    static List<Job> jobs = new ArrayList<>();

    public static void main(String[] args) {
        // Inisialisasi data
        initializeData();
    
        Scanner scanner = new Scanner(System.in);
        boolean programRunning = true;
    
        while (programRunning) {
            User user = null;
    
            while (user == null) {
                System.out.println("=== WELCOME ===");
                System.out.println("1. Login");
                System.out.println("2. Sign Up");
                System.out.println("3. Exit");
                System.out.print("Pilihan: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
    
                switch (choice) {
                    case 1:
                        user = login();
                        break;
                    case 2:
                        signUp();
                        break;
                    case 3:
                        System.out.println("Terima kasih. Sampai jumpa lagi!");
                        programRunning = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            }
    
            if (programRunning) {
                if (user instanceof Admin) {
                    displayAdminMenu((Admin) user);
                } else if (user instanceof Candidate) {
                    displayCandidateMenu((Candidate) user);
                }
            }
        }
    }
    


    static void initializeData() {
        // Inisialisasi data lowongan pekerjaan
        jobs.add(new Job(1, "Manager E-commerce", "Full Time", "Sales", "1 to 2 years of experience in Ecommerce Organization", "Jakarta, Indonesia"));
        jobs.add(new Job(2, "Tax Manager", "Full Time", "Finance", "Minimum of bachelor's degree in Accounting", "Jakarta, Indonesia"));
        jobs.add(new Job(3, "Business Intelligence Analyst", "Part Time", "Marketing & Advertising", "Minimum of bachelor's degree in IT, Math or Business", "Jakarta, Indonesia"));
        
        // Inisialisasi data user
        users.add(new Admin("admin@admin.com", "adminpassword"));
        users.add(new Candidate("veyne@google.com", "password"));
    }

    static User login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== LOGIN ===");
      
        
        try {
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
    
            for (User user : users) {
                if (user.email.equals(email) && user.password.equals(password)) {
                    return user;
                }
            }
            System.out.println("Invalid email or password.");
        } catch (Exception e) {
            System.out.println("Error occurred while processing input.");
        }
        
        return null;
    }
    
    static void signUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== SIGN UP ===");
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        User newUser;
        if (email.endsWith("@admin.com")) {
            newUser = new Admin(email, password);
        } else {
            newUser = new Candidate(email, password);
        }
        users.add(newUser);
        System.out.println("Sign up successful.");
    }
    static void displayAdminMenu(Admin admin) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== WELCOME ===");
            System.out.println("1. Submissions");
            System.out.println("2. Send Email");
            System.out.print("Pilihan: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displaySubmissions();
                    break;
                case 2:
                    sendEmail(admin);
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    static void displayCandidateMenu(Candidate candidate) {
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\n=== WELCOME ===");
            System.out.println("1. Search Job");
            System.out.println("2. Apply Now");
            System.out.println("3. Submission Pilihan");
            System.out.println("4. Log Out");
            System.out.print("Pilihan: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
    
            switch (choice) {
                case 1:
                    displayJobs();
                    break;
                case 2:
                    applyForJob(candidate);
                    break;
                case 3:
                    displayCandidateSubmissions(candidate);
                    break;
                case 4:
                    System.out.println("Anda telah keluar.");
                    loggedIn = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    static void displayJobs() {
        System.out.println("\n=== Jobs ===");
        for (Job job : jobs) {
            System.out.println("ID: " + job.id);
            System.out.println("Job Title: " + job.title);
            System.out.println("Job Type: " + job.type);
            System.out.println("Job Category: " + job.category);
            System.out.println("Qualification: " + job.qualification);
            System.out.println("Location: " + job.location);
            System.out.println("_________________________________________________________________________________");
        }
    }

    static void applyForJob(Candidate candidate) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Apply Job ===");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Education: ");
        String education = scanner.nextLine();
        System.out.print("Position you want to Apply (1-" + jobs.size() + "): ");
        int position = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (position < 1 || position > jobs.size()) {
            System.out.println("Invalid position choice.");
            return;
        }

        Job selectedJob = jobs.get(position - 1);
        String submissionStatus = "Submission status : Success! ";
        submissions.add(new JobApplication(candidate, selectedJob, submissionStatus));
        System.out.println("Thank you for applying.");
    }

    static void displayCandidateSubmissions(Candidate candidate) {
        System.out.println("\n=== Submission ===");
        int count = 1;
        for (JobApplication submission : submissions) {
            if (submission.candidate.equals(candidate)) {
                System.out.println(count + ". You applied for " + submission.job.title);
                System.out.println("Details: " + submission.status);
                count++;
            }
        }
    }

    static void displaySubmissions() {
        System.out.println("\n=== Submissions ===");
        int count = 1;
        for (JobApplication submission : submissions) {
            System.out.println(count + ". " + submission.candidate.email + " - " + submission.job.title);
            count++;
        }
    }

    static void sendEmail(Admin admin) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== SEND EMAIL ===");
        System.out.print("To: ");
        String recipient = scanner.nextLine();
        System.out.print("Add Details (Lolos/Tidak Lolos): ");
        String status = scanner.nextLine();

        admin.sendEmail(recipient, status);

    }
}