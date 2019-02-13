package viko_web_service.restservice.services;

import java.io.File;
import java.util.Collections;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import viko_web_service.restservice.entities.Course;
import viko_web_service.restservice.entities.Student;
import viko_web_service.restservice.utils.XmlConverter;

public class StudentService {
    
    public void getStudent() {
        
        Student student = createStudent();
        XmlConverter xmlConverter = new  XmlConverter();
        xmlConverter.convertToXml(student);
    }

    
    private Student createStudent() {
        Student student = new Student();
        student.setFirstName("Vasya");
        student.setLastName("Pupkin");
        student.setCourses(Collections.singletonList(new Course("Web services", 6, "Blablabla")));
        return student;
    }
}
