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
	private String shoppingListId;
	
	@Size(max = 36)
	private String shoppingListName;
	
	@Size(max = 36)
	private String shoppingListColor;

	@Size(max = 36)
	private String shoppingListCreatedUtc;
	
	@Size(max = 36)
	private String shoppingListModifiedUtc;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getShoppingListId() {
		return shoppingListId;
	}
	public void setShoppingListId(String shoppingListId) {
		this.shoppingListId = shoppingListId;
	}
	public String getShoppingListName() {
		return shoppingListName;
	}
	public void setPShoppingListName(String shoppingListName) {
		this.shoppingListName = shoppingListName;
	}
	public String getShoppingListColor() {
		return shoppingListColor;
	}
	public void setShoppingListColor(String shoppingListColor) {
		this.shoppingListColor = shoppingListColor;
	}
	public String getShoppingListCreatedUtc() {
		return shoppingListCreatedUtc;
	}
	public void setShoppingListCreatedUtc(String shoppingListCreatedUtc) {
		this.shoppingListCreatedUtc = shoppingListCreatedUtc;
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

	public String getShoppingListModifiedUtc() {
		return shoppingListModifiedUtc;
	}

	public void setShoppingListModifiedUtc(String shoppingListModifieddUtc) {
		this.shoppingListModifiedUtc = shoppingListModifiedUtc;
	}

}