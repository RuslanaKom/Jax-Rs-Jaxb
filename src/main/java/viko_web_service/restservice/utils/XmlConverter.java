package viko_web_service.restservice.utils;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;


public class XmlConverter {
    
    public void generateXsdSchema(Object object) throws IOException, JAXBException {
        JAXBContext jc = JAXBContext.newInstance(object.getClass());   
        jc.generateSchema(new SchemaOutputResolver() {

            @Override
            public Result createOutput(String namespaceURI, String fileName)
                throws IOException {
                return new StreamResult(fileName);
            }
        });
    }
    
    public void convertToXml(Object object) {
        File file = new File("C:\\Users\\rkomaristova\\Desktop\\file.xml");
        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(object, file);
            jaxbMarshaller.marshal(object, System.out);

              } catch (JAXBException e) {
            e.printStackTrace();
              }
    }

    
    public void convertToPOJO(File file) {} 
}
