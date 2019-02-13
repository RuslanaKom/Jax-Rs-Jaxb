package viko_web_service.restservice.entities;

public class Course {
    
    private String title;
    private int credits;
    private String description;
    
    
    
    public Course(String title, int credits, String description) {
        super();
        this.title = title;
        this.credits = credits;
        this.description = description;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getCredits() {
        return credits;
    }
    public void setCredits(int credits) {
        this.credits = credits;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
