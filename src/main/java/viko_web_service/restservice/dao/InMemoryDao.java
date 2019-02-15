package viko_web_service.restservice.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.client.utils.DateUtils;

import viko_web_service.restservice.entities.Dragon;
import viko_web_service.restservice.entities.Knight;
import viko_web_service.restservice.entities.Princess;

public class InMemoryDao {

    private List<Dragon> dragons = new ArrayList();
    private List<Knight> knights = new ArrayList();
    private List<Princess> princesses = new ArrayList();
    
    public InMemoryDao() {
        createEveryone();
    }

    private void createEveryone() {     
        Princess princess1 = new Princess("Emeralda", "East Kingdom", true, true);
        Princess princess2 = new Princess("Aurora", "North Kingdom", false, true);
        
        Knight knight1 = new Knight("Sir", "Arthur", "The Mouse Slayer", 0);
        Knight knight2 = new Knight("Sir", "Lancelot", "The Tortoise Heart", 1);
        Knight knight3 = new Knight("Sir", "Percival", "Green", 0);
        
        Dragon dragon1 = new Dragon();
        dragon1.setName("Alexstrasza");
        dragon1.setAmountOfGold(5600);
        dragon1.setDateOfBirth(DateUtils.parseDate("1101.02.01"));
        dragon1.setCanFly(true);
        dragon1.setPrincessCurrentlyStolen(princess1);
        dragon1.setKnightsEaten(new ArrayList<Knight>(Arrays.asList(knight1, knight3)));
        
        this.dragons.add(dragon1);
        this.princesses.addAll(Arrays.asList(princess1, princess2));
        this.knights.addAll(Arrays.asList(knight1,knight2, knight3));
    }

    public List<Dragon> getDragons() {
        return dragons;
    }

    public void setDragons(List<Dragon> dragons) {
        this.dragons = dragons;
    }

    public List<Knight> getKnights() {
        return knights;
    }

    public void setKnights(List<Knight> knights) {
        this.knights = knights;
    }

    public List<Princess> getPrincesses() {
        return princesses;
    }

    public void setPrincesses(List<Princess> princesses) {
        this.princesses = princesses;
    }

}
