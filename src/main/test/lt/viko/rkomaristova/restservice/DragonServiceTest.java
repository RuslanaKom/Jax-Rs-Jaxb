package viko_web_service.restservice.services;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;

import org.hamcrest.core.IsNot;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

import lt.viko.rkomaristova.restservice.entities.Dragon;
import lt.viko.rkomaristova.restservice.services.DragonService;
import lt.viko.rkomaristova.restservice.utils.XmlConverter;

/**
 * Test class for {@link DragonService}
*/
public class DragonServiceTest {

    private DragonService service = new DragonService();

    @Test
    public void testWriteDragonToFile() {
        service.writeDragonToFile();
    }

    @Test
    public void testGiveDragonAsXMLString() {
        System.out.println(service.giveDragonAsXml());
    }
    
    @Test
    public void testGetDragonFromFile() throws JAXBException {
        String fileName = "src\\main\\resources\\xmlFiles\\Dragon.xml";
        Dragon dragon = service.getDragonFromXmlFile(fileName);
        assertThat(dragon.getName(), is(not(nullValue())));
    }
    
    @Test(expected = UnmarshalException.class)
    public void testGetDragonFromBadFile() throws JAXBException {
        String fileName = "src\\main\\resources\\xmlFiles\\BadDragon.xml";
        service.getDragonFromXmlFile(fileName);
    }

    @Test
    public void generateXsdSchema() throws IOException, JAXBException {
        XmlConverter converter = new XmlConverter();
        converter.generateXsdSchema(Dragon.class);
    }

}
