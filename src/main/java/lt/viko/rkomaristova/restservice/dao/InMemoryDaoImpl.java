package lt.viko.rkomaristova.restservice.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import lt.viko.rkomaristova.restservice.entities.Dragon;
import lt.viko.rkomaristova.restservice.entities.Knight;
import lt.viko.rkomaristova.restservice.entities.Princess;

/**
 * Class simulating DataBase access and creating entities for application use.
 */
public class InMemoryDaoImpl implements InMemoryDao {

	private List<Dragon> dragons = new ArrayList<>();

	private List<Knight> knights = new ArrayList<>();

	private List<Princess> princesses = new ArrayList<>();

	public InMemoryDaoImpl() {
		createEveryone();
	}

	public Dragon getDragonByName(String name) {
		return dragons.stream().filter(d -> StringUtils.equals(d.getName(), name)).findFirst().orElse(null);
	}

	public Princess getPrincessByDragonName(String name) {
		return getDragonByName(name).getPrincessCurrentlyStolen();
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

		dragon1.setDateOfBirth(LocalDate.of(1032, 03, 05));
		dragon1.setCanFly(true);
		dragon1.setPrincessCurrentlyStolen(princess1);
		dragon1.setKnightsEaten(new ArrayList<Knight>(Arrays.asList(knight1, knight3)));

		this.dragons.add(dragon1);
		this.princesses.addAll(Arrays.asList(princess1, princess2));
		this.knights.addAll(Arrays.asList(knight1, knight2, knight3));
	}

	@Override
	public Dragon saveDragon(Dragon dragon) {
		if (!dragons.contains(dragon)) {
			dragons.add(dragon);
			return dragon;
		}
		return null;
	}

	@Override
	public Dragon deleteDragon(String name) {
		Dragon dragon = getDragonByName(name);
		if(null!=dragon) {
			dragons.remove(dragon);
			return dragon;
		}
		return null;
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
