package viko_web_service.restservice.entities;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity class representing Knight
 */
@XmlRootElement
public class Knight {
    
    private String title;
    private String firstName;
    private String nobleName;
    private int numberOfDragonsDefeated;
    
    public Knight() {}

    public Knight(String title, String firstName, String lastName, int numberOfDragonsDefeated) {
        super();
        this.title = title;
        this.firstName = firstName;
        this.nobleName = lastName;
        this.numberOfDragonsDefeated = numberOfDragonsDefeated;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getNobleName() {
        return nobleName;
    }

    public void setNobleName(String nobleName) {
        this.nobleName = nobleName;
    }

    public int getNumberOfDragonsDefeated() {
        return numberOfDragonsDefeated;
    }

    public void setNumberOfDragonsDefeated(int numberOfDragonsDefeated) {
        this.numberOfDragonsDefeated = numberOfDragonsDefeated;
    }

}
