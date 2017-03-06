package de.roskenet.simplecms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Suser {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String name;
	private String avatar;
	private String passwd;

	public Suser() {}
	
	public Suser(final String id) {
		this.id=id;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}
