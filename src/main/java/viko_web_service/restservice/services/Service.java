package viko_web_service.restservice.services;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import viko_web_service.restservice.entities.Knight;
import viko_web_service.restservice.dao.InMemoryDao;
import viko_web_service.restservice.entities.Dragon;
import viko_web_service.restservice.utils.XmlConverter;

public class Service {
    private XmlConverter xmlConverter = new XmlConverter();
    private InMemoryDao dao = new InMemoryDao();

    public String giveDragonAsXml() {
        Dragon dragon = dao.getDragons().get(0);
        return xmlConverter.convertToXmlString(dragon);
    }

    public void writeDragonToFile() {
        Dragon dragon = dao.getDragons().get(0);
        xmlConverter.convertToXmlFile(dragon);
    }

    public Dragon getDragonFromXmlFile() {
        File file = new File("src\\main\\resources\\xmlFiles\\Dragon.xml");
        return (Dragon) xmlConverter.convertToPOJO(file, Dragon.class);
    }

}
