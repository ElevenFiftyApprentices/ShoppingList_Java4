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
	private String createdUtc;
	private String modifiedUtc;



	protected ShoppingList() {
	}

	public ShoppingList(long userId) {
		
	}

	public ShoppingList(String name, String color, String createdUtc, String modifiedUtc, long userId) {
		this.name = name;
		this.color = color;
		this.createdUtc = createdUtc;
		this.modifiedUtc = modifiedUtc;
	}	
	
	@Override
	public String toString() {
		return "ShoppingList [id=" + id +  ", name=" + name + ", color="
				+ color + ", createdUtc=" + createdUtc + ", modifiedUtc=" + modifiedUtc + "]";
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

	public String getCreatedUtc() {
		return createdUtc;
	}

	public void setCreatedUtc(String createdUtc) {
		this.createdUtc = createdUtc;
	}

	public String getModifiedUtc() {
		return modifiedUtc;
	}

	public void setModifiedUtc(String modifiedUtc) {
		this.modifiedUtc = modifiedUtc;
	}


}