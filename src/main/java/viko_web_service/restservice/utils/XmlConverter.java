package viko_web_service.restservice.utils;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XmlConverter {

    public void generateXsdSchema(Class sourceClass) throws IOException, JAXBException {
        JAXBContext jc = JAXBContext.newInstance(sourceClass);
        jc.generateSchema(new SchemaOutputResolver() {

            @Override
            public Result createOutput(String namespaceURI, String fileName) throws IOException {
                return new StreamResult(fileName);
            }
        });
    }

    public void convertToXmlFile(Object object) {
        File file = new File("src\\main\\resources\\xmlFiles\\"+object.getClass().getSimpleName()+".xml");
        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(object, file);
            jaxbMarshaller.marshal(object, System.out);

        }
        catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    
    
    public String convertToXmlString(Object object) {
        StringWriter sw = new StringWriter();

        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(object, sw);

        }
        catch (JAXBException e) {
            e.printStackTrace();
        }
        
        return sw.toString();
    }

    public Object convertToPOJO(File file, Class targetClass) {
        File schemaFile = new File("src\\main\\resources\\xsdSchemas\\" + targetClass.getSimpleName()+ ".xsd");
        Object object = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(targetClass);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = sf.newSchema(schemaFile);
            jaxbUnmarshaller.setSchema(schema);

            object = jaxbUnmarshaller.unmarshal(file);
        }
        catch (JAXBException e) {
            e.printStackTrace();
        }

        catch (SAXException e) {
            e.printStackTrace();
        }
        return object;
    }
}
