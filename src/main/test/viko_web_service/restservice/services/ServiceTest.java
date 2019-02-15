package viko_web_service.restservice.services;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.junit.Test;

import viko_web_service.restservice.entities.Dragon;
import viko_web_service.restservice.entities.Knight;
import viko_web_service.restservice.services.Service;
import viko_web_service.restservice.utils.XmlConverter;

public class ServiceTest {

    private Service service = new Service();

    @Test
    public void testWriteDragonToFile() {
        service.writeDragonToFile();
    }

    @Test
    public void testGiveDragonAsXMLString() {
        System.out.println(service.giveDragonAsXml());
    }
    
    @Test
    public void testGetDragonFromFile() {
        Dragon dragon = service.getDragonFromXmlFile();

        System.out.println(dragon.getName());

    }

    @Test
    public void generateXsdSchema() throws IOException, JAXBException {
        XmlConverter converter = new XmlConverter();
        converter.generateXsdSchema(Dragon.class);
    }

}
