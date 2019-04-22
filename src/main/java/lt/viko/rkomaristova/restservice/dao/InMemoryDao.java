package lt.viko.rkomaristova.restservice.dao;

import java.util.List;

import lt.viko.rkomaristova.restservice.entities.Dragon;
import lt.viko.rkomaristova.restservice.entities.Knight;
import lt.viko.rkomaristova.restservice.entities.Princess;


public interface InMemoryDao {
	
	List<Dragon> getDragons();
	List<Knight> getKnights();
	List<Princess> getPrincesses();
	
	Dragon getDragonByName(String name);
	
	Princess getPrincessByDragonName(String name);
	
	Dragon saveDragon(Dragon dragon);
	Dragon deleteDragon(String name);

}
