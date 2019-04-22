package lt.viko.rkomaristova.restservice.services;

import java.io.File;

import javax.xml.bind.JAXBException;

import lt.viko.rkomaristova.restservice.dao.InMemoryDao;
import lt.viko.rkomaristova.restservice.dao.InMemoryDaoImpl;
import lt.viko.rkomaristova.restservice.entities.Dragon;
import lt.viko.rkomaristova.restservice.utils.XmlConverter;

/**
 * Class for performing transformations on {@link Dragon} entity.
 */
public class DragonService {

    private XmlConverter xmlConverter = new XmlConverter();
    private InMemoryDao dao = new InMemoryDaoImpl();

    /**
     * Extracts first dragon from dao and returns it as XML string.
     * @return XML string representing dragon
     */
    public String giveDragonAsXml() {
        Dragon dragon = dao.getDragons().get(0);
        return xmlConverter.convertToXmlString(dragon);
    }
    
    /**
     * Extracts first dragon from dao and writes it as XML to file.
     */
    public void writeDragonToFile() {
        Dragon dragon = dao.getDragons().get(0);
        xmlConverter.convertToXmlFile(dragon);
    }
    
    /**
     * Creates Dragon class object from xml file.
     * @return created dragon object
     * @throws JAXBException 
     */
    public Dragon getDragonFromXmlFile(String filename) throws JAXBException {
        File file = new File(filename);
        return (Dragon) xmlConverter.convertToPOJO(file, Dragon.class);
    }

}
