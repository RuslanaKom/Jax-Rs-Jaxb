package viko_web_service.restservice.services;

import java.io.File;
import viko_web_service.restservice.dao.InMemoryDao;
import viko_web_service.restservice.entities.Dragon;
import viko_web_service.restservice.utils.XmlConverter;

/**
 * Class for performing transformations on {@link Dragon} entity
 */
public class DragonService {

    private XmlConverter xmlConverter = new XmlConverter();
    private InMemoryDao dao = new InMemoryDao();

    /**
     * Extracts first dragon from dao and returns it as XML string
     * @return XML string representing dragon
     */
    public String giveDragonAsXml() {
        Dragon dragon = dao.getDragons().get(0);
        return xmlConverter.convertToXmlString(dragon);
    }
    
    /**
     * Extracts first dragon from dao and writes it as XML to file
     */
    public void writeDragonToFile() {
        Dragon dragon = dao.getDragons().get(0);
        xmlConverter.convertToXmlFile(dragon);
    }
    
    /**
     * Creates Dragon class object from xml file
     * @return created dragon object
     */
    public Dragon getDragonFromXmlFile() {
        File file = new File("src\\main\\resources\\xmlFiles\\Dragon.xml");
        return (Dragon) xmlConverter.convertToPOJO(file, Dragon.class);
    }

}
