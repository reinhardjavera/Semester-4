package tugas;

public class Job {
    int id;
    String title;
    String type;
    String category;
    String qualification;
    String location;

    public Job(int id, String title, String type, String category, String qualification, String location) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.category = category;
        this.qualification = qualification;
        this.location = location;
    }
}