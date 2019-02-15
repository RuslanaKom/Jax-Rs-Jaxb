package viko_web_service.restservice.entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Princess {
    
    private String name;
    private String kingdom;
    private boolean stolen;
    private boolean beautiful;
    
    public Princess() {}
    
    public Princess(String name, String kingdom, boolean stolen, boolean beautiful) {
        super();
        this.name = name;
        this.kingdom = kingdom;
        this.stolen = stolen;
        this.beautiful = beautiful;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKingdom() {
        return kingdom;
    }

    public void setKingdom(String kingdom) {
        this.kingdom = kingdom;
    }

    public boolean isStolen() {
        return stolen;
    }

    public void setStolen(boolean stolen) {
        this.stolen = stolen;
    }

    public boolean isBeautiful() {
        return beautiful;
    }

    public void setBeautiful(boolean beautiful) {
        this.beautiful = beautiful;
    }
    
    

}
