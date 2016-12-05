package org.elevenfifty.shoppinglist.beans;

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

@Entity
@Table(name = "shopping_list")
public class ShoppingList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	
	@OneToMany(mappedBy="shoppingList", cascade = CascadeType.ALL)
	private  List <ShoppingListItem> shoppingListItem; 
	
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;	

	private String name;
	private String color;

	@Column(unique = true)
	private String created_utc;
	private String modified_utc;



	protected ShoppingList() {
	}

	public ShoppingList(User userId) {
		this.user = userId;
	}

	public ShoppingList(String name, String color, String created_utc, String modified_utc, long userId) {
		this.name = name;
		this.color = color;
<<<<<<< HEAD
		this.created_utc = created_utc;
		this.modified_utc = modified_utc;
		this.userId = userId;
=======
		this.createdUtc = createdUtc;
		this.modifiedUtc = modifiedUtc;
>>>>>>> 7722dff870ffc0493908dc1bf5ff93d1c0548d06
	}	
	
	@Override
	public String toString() {
<<<<<<< HEAD
		return "ShoppingList [id=" + id + ", userId=" + userId + ", email=" + email + ", name=" + name + ", color="
				+ color + ", created_utc=" + created_utc + ", modified_utc=" + modified_utc + "]";
=======
		return "ShoppingList [id=" + id +  ", name=" + name + ", color="
				+ color + ", createdUtc=" + createdUtc + ", modifiedUtc=" + modifiedUtc + "]";
>>>>>>> 7722dff870ffc0493908dc1bf5ff93d1c0548d06
	}

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

<<<<<<< HEAD
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
=======
>>>>>>> 7722dff870ffc0493908dc1bf5ff93d1c0548d06

}