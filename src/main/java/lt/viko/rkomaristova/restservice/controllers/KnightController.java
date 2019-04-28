package lt.viko.rkomaristova.restservice.controllers;

import javax.servlet.annotation.WebServlet;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;

import io.swagger.annotations.Api;
import lt.viko.rkomaristova.restservice.dao.InMemoryDao;
import lt.viko.rkomaristova.restservice.dao.InMemoryDaoImpl;
import lt.viko.rkomaristova.restservice.dto.KnightDto;
import lt.viko.rkomaristova.restservice.entities.Knight;

@WebServlet
@Path("knights")
@Api
public class KnightController {

	private InMemoryDao dao = new InMemoryDaoImpl();

	@GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getKnightByNobleName(@PathParam("name") String name) {
    	Knight knight = dao.getKnights().stream()
    			.filter(k -> StringUtils.equals(k.getNobleName(), name))
    			.findFirst()
    			.orElseThrow(() -> new IllegalArgumentException());
    			
		return Response.status(200).entity(new KnightDto(knight)).build();
	}
}
