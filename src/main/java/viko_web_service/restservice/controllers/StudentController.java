package viko_web_service.restservice.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/student")
public class StudentController {
    
    @GET
    @Produces(MediaType.TEXT_XML)
    public String getStudent() {
        return "<?xml version=\"1.0\"?>" + "<student> Hello Jersey" + "</student>";
    }

}
