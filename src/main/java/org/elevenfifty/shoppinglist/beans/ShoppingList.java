package org.elevenfifty.shoppinglist.beans;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "shoppinglists")
public class ShoppingList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Size(max = 16)
	private long userId;
	
	@Size(max = 36)
	private String Name;
	
	@Size(max = 36)
	private String Color;

	@Size(max = 36)
	private String CreatedUtc;
	
	@Size(max = 36)
	private String ModifiedUtc;

	
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
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public String getCreatedUtc() {
		return CreatedUtc;
	}

	public void setCreatedUtc(String createdUtc) {
		CreatedUtc = createdUtc;
	}

	public String getModifiedUtc() {
		return ModifiedUtc;
	}

	public void setModifiedUtc(String modifiedUtc) {
		ModifiedUtc = modifiedUtc;
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

}