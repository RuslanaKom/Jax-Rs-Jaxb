package lt.viko.rkomaristova.restservice.entities;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity class representing Dragon
 */
@XmlRootElement
public class Dragon {

    private String name;
    private Date dateOfBirth;
    private double amountOfGold;
    private boolean canFly;
    private Princess princessCurrentlyStolen;

    private List<Knight> knightsEaten;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getAmountOfGold() {
        return amountOfGold;
    }

    public void setAmountOfGold(double amountOfGold) {
        this.amountOfGold = amountOfGold;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    public Princess getPrincessCurrentlyStolen() {
        return princessCurrentlyStolen;
    }

    public void setPrincessCurrentlyStolen(Princess princessCurrentlyStolen) {
        this.princessCurrentlyStolen = princessCurrentlyStolen;
    }
    
    @XmlElementWrapper(name = "knightsEaten")
    @XmlElement(name = "knight")
    public List<Knight> getKnightsEaten() {
        return knightsEaten;
    }

    public void setKnightsEaten(List<Knight> knightsEaten) {
        this.knightsEaten = knightsEaten;
    }
}
