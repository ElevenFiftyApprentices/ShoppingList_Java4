package org.elevenfifty.shoppinglist.beans;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table( name = "shopping_list_item")
public class ShoppingListItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	private long shoppingListId;
	
	@Size(max = 100)
	private String contents;
	
	private int priority;
	
	private boolean isChecked;
	
	private Date createdUtc;
	
	private Date modifiedUtc;
	
	protected ShoppingListItem(){}
	
	public ShoppingListItem(String contents, int priority , boolean isChecked, Date createdUtc, Date modifiedUtc){
		this.contents = contents;
		this.priority = priority;
		this.isChecked = isChecked;
		this.createdUtc = createdUtc;
		this.modifiedUtc = modifiedUtc;
	}
 
	

	@Override
	public String toString() {
		return "ShoppingListItem [id=" + id + ", shoppingListId=" + shoppingListId + ", contents=" + contents
				+ ", priority=" + priority + ", isChecked=" + isChecked + ", createdUtc=" + createdUtc
				+ ", modifiedUtc=" + modifiedUtc + "]";
	}
	
	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getShoppingListId() {
		return shoppingListId;
	}

	public void setShoppingListId(long shoppingListId) {
		this.shoppingListId = shoppingListId;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
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
	
	

}
