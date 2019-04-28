package lt.viko.rkomaristova.restservice.entities;

import java.time.LocalDate;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lt.viko.rkomaristova.restservice.utils.LocalDateAdapter;

/**
 * Entity class representing Dragon
 */
@XmlRootElement
public class Dragon {

    private String name;
    private LocalDate dateOfBirth;
    private double amountOfGold;
    private boolean canFly;
    private Princess princessCurrentlyStolen;
    private List<Knight> knightsEaten;

	public Dragon() {
	}
	
	public Dragon(String name, LocalDate dateOfBirth, boolean canFly) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.canFly = canFly;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    
    public void setDateOfBirth(LocalDate dateOfBirth) {
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
