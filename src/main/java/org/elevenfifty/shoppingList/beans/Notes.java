package org.elevenfifty.shoppingList.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notes")
public class Notes {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	
	private String body;
	
	private Date createdUtc;
	
	private Date modifiedUtc;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getCreatedUtc() {
		return createdUtc;
	}

	public void setCreatedUtc() {
		this.createdUtc = new Date(System.currentTimeMillis());
	}

	public Date getModifiedUtc() {
		return modifiedUtc;
	}

	public void setModifiedUtc() {
		this.modifiedUtc = new Date(System.currentTimeMillis());
	}
}
