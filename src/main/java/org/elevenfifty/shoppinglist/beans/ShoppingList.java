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

	private String name;
	private String color;

	@Column(unique = true)
	private Date createdUtc;
	private Date modifiedUtc;
	// private String password;
	private boolean active;

//	@OneToMany(mappedBy = "shoppingList")
//	private List<ShoppingListItem> listItems;

	protected ShoppingList() {
		active = true;
	}

	public ShoppingList(long userId) {
		this.userId = userId;
		this.active = true;
	}

	public ShoppingList(String name, String color, Date createdUtc, Date modifiedUtc, String password, boolean active,
			long userId) {
		this.name = name;
		this.color = color;
		this.createdUtc = createdUtc;
		this.modifiedUtc = modifiedUtc;
		// this.password = password;
		this.active = active;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", color=" + color + ", createdUtc=" + createdUtc
				+ ", modifiedUtc=" + modifiedUtc + active + "]";
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

	public Date getCreatedUtc() {
		return createdUtc;
	}

	public void setCreatedUtc(Date createdUtc) {
		this.createdUtc = createdUtc;
	}

	public Date getModifiedUtc() {
		return modifiedUtc;
	}

	public void setModifiedUtc(Date modifiedUtc) {
		this.modifiedUtc = modifiedUtc;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}