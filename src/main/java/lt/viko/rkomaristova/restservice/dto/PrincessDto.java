package lt.viko.rkomaristova.restservice.dto;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Link;
import javax.ws.rs.core.UriBuilder;

import lt.viko.rkomaristova.restservice.controllers.PrincessController;
import lt.viko.rkomaristova.restservice.entities.Princess;

public class PrincessDto {
	
	private Princess princess;

	private List<Link> links;

	public PrincessDto() {
	};

	public PrincessDto(Princess princess) {
		this.princess = princess;
		this.links=new ArrayList<>();
		
		UriBuilder builder = UriBuilder
				.fromResource(PrincessController.class)
				.path(PrincessController.class, "getPrincessByName");
		Link linkSelf = Link.fromUri(builder.build(princess.getName())).rel("self").build();
		links.add(linkSelf);
	}

	public Princess getPrincess() {
		return princess;
	}

	public void setPrincess(Princess princess) {
		this.princess = princess;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
}
