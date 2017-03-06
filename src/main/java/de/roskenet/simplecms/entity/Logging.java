package de.roskenet.simplecms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Logging {

	@Id
	@SequenceGenerator(name = "logging_id_seq", sequenceName = "logging_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "logging_id_seq")
	@Column(name = "id", updatable = false)
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="reqtime", updatable = false)
	private Date reqtime = new Date();

	private String method;
	
	private String url;
	private String ip;
	private String agent;
	
	public int getId() {
		return id;
	}
	public Date getReqtime() {
		return (Date) reqtime.clone();
	}
	public void setReqtime(Date reqtime) {
		this.reqtime = (Date) reqtime.clone();
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getAgent() {
		return agent;
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
	
}
