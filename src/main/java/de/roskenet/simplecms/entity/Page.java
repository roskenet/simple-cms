package de.roskenet.simplecms.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Page {

	@Id
	private String id;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "page_tag", 
               joinColumns = @JoinColumn(name = "page_id", referencedColumnName = "id"), 
               inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
	private Set<Tag> tags;

	@ManyToOne
	private Suser suser;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	
	private String header;
	private String tldr;
	private String avatar;
	private String path;
	
//	@OneToMany
//    @JoinColumn(name = "page_id", referencedColumnName = "id")
//	private List<AttributeView> attributes;

	@ElementCollection
	@JoinTable(name="attribute_view", joinColumns=@JoinColumn(name="page_id", referencedColumnName="id"))
	@MapKeyColumn (name="name")
	@Column(name="value")
	private Map<String, String> attributes = new HashMap<String, String>();
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public Suser getSuser() {
		return suser;
	}

	public void setSuser(Suser suser) {
		this.suser = suser;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getTldr() {
		return tldr;
	}

	public void setTldr(String tldr) {
		this.tldr = tldr;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
}