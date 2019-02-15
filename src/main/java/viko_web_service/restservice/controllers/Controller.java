package viko_web_service.restservice.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import viko_web_service.restservice.services.Service;

@Path("/student")
public class Controller {
    
    private Service studentService = new Service();
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getStudent() {
        return Response.ok().type(MediaType.APPLICATION_XML).entity(studentService.giveDragonAsXml()).build();
    }

}
