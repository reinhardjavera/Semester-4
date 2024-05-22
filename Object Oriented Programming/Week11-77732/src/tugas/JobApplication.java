package tugas;

public class JobApplication {
    Candidate candidate;
    Job job;
    String status;

    public JobApplication(Candidate candidate, Job job, String status) {
        this.candidate = candidate;
        this.job = job;
        this.status = status;
    }

    public String getDetails() {
        return candidate.email + " - " + job.title + "\nDetails: " + status;
    }
}