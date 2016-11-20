package de.roskenet.simplecms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CategoryView {

	@Id
	private String id;
	
	private String main;

	private String pageId;
	
	private int level;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	
}
