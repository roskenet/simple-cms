package de.roskenet.simplecms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tag {

	@Id
	private String id;

	public Tag() {
		
	}
	
	public Tag(final String id) {
		this.id=id;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
