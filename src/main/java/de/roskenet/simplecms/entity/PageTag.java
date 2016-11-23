package de.roskenet.simplecms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class PageTag {

	@EmbeddedId
	private PageTagId pageTagId = new PageTagId();

	public String getPageId() {
		return pageTagId.pageId;
	}
	public void setPageId(String pageId) {
		pageTagId.pageId = pageId;
	}
	public String getTagId() {
		return pageTagId.tagId;
	}
	public void setTagId(String tagId) {
		pageTagId.tagId = tagId;
	}
	
	

}

@Embeddable
class PageTagId implements Serializable {
	@Column(name="page_id")
    public String pageId;

	@Column(name="tag_id")
	public String tagId;
}