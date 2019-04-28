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
import lt.viko.rkomaristova.restservice.dto.DragonDto;
import lt.viko.rkomaristova.restservice.dto.KnightDto;
import lt.viko.rkomaristova.restservice.dto.PrincessDto;
import lt.viko.rkomaristova.restservice.entities.Dragon;
import lt.viko.rkomaristova.restservice.entities.Knight;
import lt.viko.rkomaristova.restservice.entities.Princess;


/**
 * Rest controller for Dragon entity
 */
@WebServlet
@Path("dragons")
@Api
public class DragonController {
    
	/* http://localhost:8085/restservice/rest/application.wadl */
	/* http://localhost:8085/restservice/rest/swagger.json */
    
    private InMemoryDao dao = new InMemoryDaoImpl();

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getDragonByName(@PathParam("name") String name) {
    	Dragon dragon = dao.getDragonByName(name);
		return Response.status(200).entity(new DragonDto(dragon)).build();
	}
    
    @DELETE
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	public Response deleteDragonByName(@PathParam("name") String name) {
		return Response.status(200).entity(dao.deleteDragon(name)).build();
	}
    
    @GET
    @Path("/{name}/pricess")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getPrincessStolenByDragonName(@PathParam("name") String name) {
    	Princess princess = dao.getPrincessByDragonName(name);
		return Response.status(200).entity(new PrincessDto(princess)).build();
	}
    
    @PUT
    @Path("/{name}/pricess")
    @Produces(MediaType.APPLICATION_JSON)
	public Response setPrincessStolenByDragonName(@PathParam("name") String name, Princess princess) {
    	Dragon dragon = dao.getDragonByName(name);
    	dragon.getPrincessCurrentlyStolen().setStolen(false);
    	princess.setStolen(true);
    	dragon.setPrincessCurrentlyStolen(princess);
		return Response.status(200).entity(new DragonDto(dragon)).build();
	}
    
    @GET
    @Path("/{name}/knightsEaten")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getKnightEatenByDragonName(@PathParam("name") String dragonName) {
		Dragon dragon = dao.getDragonByName(dragonName);
		List <Knight> knights = dragon.getKnightsEaten();
		List <KnightDto> knightDtos = knights.stream().map(k->new KnightDto(k)).collect(Collectors.toList());
		return Response.status(200).entity(knightDtos).build();
	}
    
    @PUT
    @Path("/{name}/knightsEaten")
    @Consumes(MediaType.APPLICATION_JSON)
	public Response addKnightEatenByDragonName(@PathParam("name") String dragonName, @QueryParam("name") String name, @QueryParam("nobleName") String nobleName,@QueryParam("dragonsDefeated") int dragonsDefeated) {
		Knight knight = new Knight("Sir", name, nobleName, dragonsDefeated);
		Dragon dragon = dao.getDragonByName(dragonName);
		if (null == dragon.getKnightsEaten()) {
			dragon.setKnightsEaten(new ArrayList<>());
		}
		dragon.getKnightsEaten().stream()
		.filter(k->StringUtils.equals(k.getFirstName(), name)&&StringUtils.equals(k.getNobleName(), nobleName))
		.findFirst()
		.ifPresent(k->{throw new IllegalArgumentException();});
		
		dragon.getKnightsEaten().add(knight);
		List <Knight> knights = dragon.getKnightsEaten();
		List <KnightDto> knightDtos = knights.stream().map(k->new KnightDto(k)).collect(Collectors.toList());
		return Response.status(200).entity(knightDtos).build();
	}
    
    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	public Response createDragon(@QueryParam("name") String name, @QueryParam("dateOfBirth") String dateOfBirth, @QueryParam("canFly") boolean canFly) {
		LocalDate date = LocalDate.parse(dateOfBirth, DateTimeFormatter.ISO_LOCAL_DATE);
		Dragon newDragon = dao.saveDragon(new Dragon(name, date, canFly));
		List <Dragon> dragons = dao.getDragons();
		List <DragonDto> dragonDtos = dragons.stream().map(d-> new DragonDto(d)).collect(Collectors.toList());
    	return Response.status(201).entity(dragonDtos).build();
	} 
    
//
//    @GET
//    @Path("/{name}")
//    @Produces(MediaType.APPLICATION_JSON)
//	public Response getDragonByName(@PathParam("name") String name) {
//		return Response.status(200).entity(dao.getDragonByName(name)).build();
//	}
//    
//    @DELETE
//    @Path("/{name}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//	public Response deleteDragonByName(@PathParam("name") String name) {
//		return Response.status(200).entity( dao.deleteDragon(name)).build();
//	}
//    
//    @GET
//    @Path("/{name}/pricess")
//    @Produces(MediaType.APPLICATION_JSON)
//	public Response getPrincessStolenByDragonName(@PathParam("name") String name) {
//		return Response.status(200).entity(dao.getPrincessByDragonName(name)).build();
//	}
//    
//    @PUT
//    @Path("/{name}/pricess")
//    @Produces(MediaType.APPLICATION_JSON)
//	public Response setPrincessStolenByDragonName(@PathParam("name") String name, @QueryParam("princess") Princess princess) {
//    	Dragon dragon = dao.getDragonByName(name);
//    	dragon.setPrincessCurrentlyStolen(princess);
//		return Response.status(200).entity(dragon).build();
//	}
//    
//    @GET
//    @Path("/{name}/knightsEaten")
//    @Produces(MediaType.APPLICATION_JSON)
//	public Response addKnightEatenByDragonName(@PathParam("name") String dragonName) {
//		Dragon dragon = dao.getDragonByName(dragonName);
//		return Response.status(200).entity(dragon.getKnightsEaten()).build();
//	}
//    
//    @PUT
//    @Path("/{name}/knightsEaten")
//    @Consumes(MediaType.APPLICATION_JSON)
//	public Response addKnightEatenByDragonName(@PathParam("name") String dragonName, @QueryParam("name") String name, @QueryParam("nobleName") String nobleName,@QueryParam("dragonsDefeated") int dragonsDefeated) {
//		Knight knight = new Knight("Sir", name, nobleName, dragonsDefeated);
//		Dragon dragon = dao.getDragonByName(dragonName);
//		if (null == dragon.getKnightsEaten()) {
//			dragon.setKnightsEaten(new ArrayList<>());
//		}
//		dragon.getKnightsEaten().stream()
//		.filter(k->StringUtils.equals(k.getFirstName(), name)&&StringUtils.equals(k.getNobleName(), nobleName))
//		.findFirst()
//		.ifPresent(k->{throw new IllegalArgumentException();});
//		
//		dragon.getKnightsEaten().add(knight);
//		return Response.status(200).build();
//	}
//    
//    @POST
//    @Path("/create")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//	public Response createDragon(@QueryParam("name") String name, @QueryParam("dateOfBirth") String dateOfBirth, @QueryParam("canFly") boolean canFly) {
//		LocalDate date = LocalDate.parse(dateOfBirth, DateTimeFormatter.ISO_LOCAL_DATE);
//		Dragon newDragon = dao.saveDragon(new Dragon(name, date, canFly));
//		List <Dragon> dragons = dao.getDragons();
//    	return Response.status(201).entity(dragons).build();
//	} 
}
