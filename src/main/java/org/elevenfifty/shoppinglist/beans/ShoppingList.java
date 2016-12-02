package org.elevenfifty.shoppinglist.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "shopping_list")
public class ShoppingList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private long userId;
	private String email;

	private String name;
	private String color;

	@Column(unique = true)
	private String created_utc;
	private String modified_utc;

//	@OneToMany(mappedBy = "shoppingList")
//	private List<ShoppingListItem> listItems;

	protected ShoppingList() {
	}

	public ShoppingList(long userId) {
		this.userId = userId;
	}

	public ShoppingList(String name, String color, String created_utc, String modified_utc, long userId) {
		this.name = name;
		this.color = color;
		this.created_utc = created_utc;
		this.modified_utc = modified_utc;
		this.userId = userId;
	}	
	
	@Override
	public String toString() {
		return "ShoppingList [id=" + id + ", userId=" + userId + ", email=" + email + ", name=" + name + ", color="
				+ color + ", created_utc=" + created_utc + ", modified_utc=" + modified_utc + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCreated_utc() {
		return created_utc;
	}

	public void setCreated_utc(String created_utc) {
		this.created_utc = created_utc;
	}

	public String getModified_utc() {
		return modified_utc;
	}

	public void setModified_utc(String modified_utc) {
		this.modified_utc = modified_utc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}