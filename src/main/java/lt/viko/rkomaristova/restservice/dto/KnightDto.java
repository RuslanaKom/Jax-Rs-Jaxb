package lt.viko.rkomaristova.restservice.dto;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Link;
import javax.ws.rs.core.UriBuilder;

import lt.viko.rkomaristova.restservice.controllers.KnightController;
import lt.viko.rkomaristova.restservice.entities.Knight;


public class KnightDto {
	
	private Knight knight;

	private List<Link> links;

	public KnightDto() {
	};

	public KnightDto(Knight knight) {
		this.knight = knight;
		this.links=new ArrayList<>();
		
		UriBuilder builder = UriBuilder
				.fromResource(KnightController.class)
				.path(KnightController.class, "getKnightByNobleName");
		Link linkSelf = Link.fromUri(builder.build(knight.getNobleName())).rel("self").build();
		links.add(linkSelf);
	}

	public Knight getKnight() {
		return knight;
	}

	public void setKnight(Knight knight) {
		this.knight = knight;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
}
