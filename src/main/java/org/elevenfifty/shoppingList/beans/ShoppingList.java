package org.elevenfifty.shoppinglist.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.elevenfifty.shoppinglist.beans.User;



@Entity
@Table(name = "shopping_list")
public class ShoppingList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	
	@OneToMany(mappedBy="shoppingList", cascade = CascadeType.ALL)
	private  List <ShoppingListItem> shoppingListItem; 
	
	
//	@ManyToOne
//	@JoinColumn(name = "user_id")
//	private User user;	

	@Size(max = 100)
	private String name;
	private String color;

	@Column(unique = true)
	private Date createdUtc;
	private Date modifiedUtc;


	public List<ShoppingListItem> getShoppingListItem() {
		return shoppingListItem;
	}

	public void setShoppingListItem(List<ShoppingListItem> shoppingListItem) {
		this.shoppingListItem = shoppingListItem;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public void setCreatedUtc() {
		this.createdUtc = new Date(System.currentTimeMillis());
	}

	public Date getModifiedUtc() {
		return modifiedUtc;
	}

	public void setModifiedUtc() {
		this.modifiedUtc = new Date(System.currentTimeMillis());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingList other = (ShoppingList) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ShoppingList [id=" + id + ", shoppingListItems=" + shoppingListItem + ", name=" + name + ", color="
				+ color + ", createdUtc=" + createdUtc + ", modifiedUtc=" + modifiedUtc + "]";
	}

	
}