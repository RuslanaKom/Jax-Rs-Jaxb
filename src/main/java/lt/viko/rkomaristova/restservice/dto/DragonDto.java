package lt.viko.rkomaristova.restservice.dto;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Link;
import javax.ws.rs.core.UriBuilder;

import lt.viko.rkomaristova.restservice.controllers.DragonController;
import lt.viko.rkomaristova.restservice.entities.Dragon;

public class DragonDto {

	private Dragon dragon;

	private List<Link> links;

	public DragonDto() {
	}

	public DragonDto(Dragon dragon) {
		this.dragon = dragon;
		this.links=new ArrayList<>();

		UriBuilder builder = UriBuilder
				.fromResource(DragonController.class)
				.path(DragonController.class, "getDragonByName");
		Link linkSelf = Link.fromUri(builder.build(dragon.getName())).rel("self").build();
		links.add(linkSelf);
		
		builder = UriBuilder
				.fromResource(DragonController.class)
				.path(DragonController.class, "getPrincessStolenByDragonName");
		Link linkPrincess = Link.fromUri(builder.build(dragon.getName())).rel("princess").build();
		links.add(linkPrincess);
		
		builder = UriBuilder
				.fromResource(DragonController.class)
				.path(DragonController.class, "addKnightEatenByDragonName");
		Link linkKnight = Link.fromUri(builder.build(dragon.getName())).rel("knight").build();
		links.add(linkKnight);
	}

	public Dragon getDragon() {
		return dragon;
	}

	public void setDragon(Dragon dragon) {
		this.dragon = dragon;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

}
