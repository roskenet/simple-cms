package de.roskenet.simplecms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Attribute {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	private String level;
	private String categorySelector;
	private String pageSelector;
	private String name;
	private String value;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getCategorySelector() {
		return categorySelector;
	}

	public void setCategorySelector(String categorySelector) {
		this.categorySelector = categorySelector;
	}

	public String getPageSelector() {
		return pageSelector;
	}

	public void setPageSelector(String pageSelector) {
		this.pageSelector = pageSelector;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
