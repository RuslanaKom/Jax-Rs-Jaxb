package lt.viko.rkomaristova.restservice.controllers;

import javax.servlet.annotation.WebServlet;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import lt.viko.rkomaristova.restservice.services.DragonService;

/**
 * Rest controller 
 */
@WebServlet
@Path("/dragon")
public class Controller {
    
    private DragonService service = new DragonService();
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getStudent() {
        return Response.ok().type(MediaType.APPLICATION_XML).entity(service.giveDragonAsXml()).build();
    }

}
