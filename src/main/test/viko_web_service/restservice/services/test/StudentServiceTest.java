package viko_web_service.restservice.services.test;

import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;

import viko_web_service.restservice.entities.Student;
import viko_web_service.restservice.services.StudentService;

public class StudentServiceTest {
    
    @Test
    public void testStudentService() {
        
        StudentService studentService = new StudentService();
        
        studentService.getStudent();
        
        
    }
    
    @Test
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

}
