package de.roskenet.simplecms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {

	@Id
	private String id;
	private String supercat = "Home";
	private String pageId;
	private Integer sortKey;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSupercat() {
		return supercat;
	}
	public void setSupercat(String supercat) {
		this.supercat = supercat;
	}
	public String getPageId() {
		return pageId;
	}
	public void setPageId(String pageId) {
		this.pageId = pageId;
	}
    public Integer getSortKey() {
        return sortKey;
    }
    public void setSortKey(Integer sortKey) {
        this.sortKey = sortKey;
    }
	
}
