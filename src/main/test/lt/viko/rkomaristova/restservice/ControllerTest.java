package lt.viko.rkomaristova.restservice;

import lt.viko.rkomaristova.restservice.controllers.DragonController;
import lt.viko.rkomaristova.restservice.entities.Dragon;
import lt.viko.rkomaristova.restservice.entities.Princess;

import static org.junit.Assert.assertTrue;

import javax.ws.rs.core.Response;

import org.junit.Test;

public class ControllerTest {

	private static final String DRAGON_NAME = "Alexstrasza";

	DragonController dragonService= new DragonController();

	@Test
    public void shouldReturnDragonByName(){
		//when
        Response result = dragonService.getDragonByName(DRAGON_NAME);
        //then      
        assertTrue(result.getEntity() instanceof Dragon);
    }

	@Test
    public void shouldGetPrincessStolenByDragonName(){
		//when
		Response result = dragonService.getPrincessStolenByDragonName(DRAGON_NAME);
        //then      
        assertTrue(result.getEntity() instanceof Princess);
    }
}
