package lt.viko.rkomaristova.restservice.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.annotation.WebServlet;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;

import io.swagger.annotations.Api;
import lt.viko.rkomaristova.restservice.dao.InMemoryDao;
import lt.viko.rkomaristova.restservice.dao.InMemoryDaoImpl;
import lt.viko.rkomaristova.restservice.entities.Dragon;
import lt.viko.rkomaristova.restservice.entities.Knight;
import lt.viko.rkomaristova.restservice.services.DragonService;


/**
 * Rest controller 
 */
@WebServlet
@Path("/dragons")
@Api
public class DragonController {
    
    private DragonService service = new DragonService();
    
    private InMemoryDao dao = new InMemoryDaoImpl();
    
//    @GET
//    @Produces(MediaType.APPLICATION_XML)
//    public Response getDragon() {
//        return Response.ok().type(MediaType.APPLICATION_XML).entity(service.giveDragonAsXml()).build();
//    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDragons() {
        return Response.status(200).entity(dao.getDragons()).build();
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getDragonByName(@PathParam("name") String name) {
		return Response.status(200).entity(dao.getDragonByName(name)).build();
	}
    
    @GET
    @Path("/{name}/pricess")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getPrincessStolenByDragonName(@PathParam("name") String name) {
		return Response.status(200).entity(dao.getPrincessByDragonName(name)).build();
	}
    
    @PUT
    @Path("/{name}/eatKnight")
    @Consumes(MediaType.APPLICATION_JSON)
	public Response addKnightEatenByDragonName(@PathParam("name") String dragonName, @QueryParam("name") String name,@QueryParam("nobleName") String nobleName,@QueryParam("dragonsDefeated") int dragonsDefeated) {
		Knight knight = new Knight("Sir", name, nobleName, dragonsDefeated);
		Dragon dragon = dao.getDragonByName(dragonName);
		if (null == dragon.getKnightsEaten()) {
			dragon.setKnightsEaten(new ArrayList<>());
		}
		List<Knight> dublicateKnights = dragon.getKnightsEaten().stream().filter(k->StringUtils.equals(k.getFirstName(),name)&&StringUtils.equals(k.getNobleName(),nobleName)).collect(Collectors.toList());
		if (dublicateKnights.isEmpty()) {
			dragon.getKnightsEaten().add(knight);
		}
		return Response.status(200).build();
	}
    
    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	public Response createDragon(@QueryParam("name") String name, @QueryParam("dateOfBirth") String dateOfBirth, @QueryParam("canFly") boolean canFly) {
		LocalDate date = LocalDate.parse(dateOfBirth, DateTimeFormatter.ISO_LOCAL_DATE);
		dao.saveDragon(new Dragon(name, date, canFly));
    	return Response.status(201).build();
	}
    
    @DELETE
    @Path("/{name}/delete")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	public Response deleteDragonByName(@PathParam("name") String name) {
		return Response.status(200).entity( dao.deleteDragon(name)).build();
	}
}
