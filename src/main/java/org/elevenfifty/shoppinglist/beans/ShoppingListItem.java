package org.elevenfifty.shoppinglist.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name = "shopping_list_item")
public class ShoppingListItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
    @JoinColumn(name = "shopping_list_id")
    private ShoppingList list;
	
	private String contents;

	private Integer priority;
	
	public boolean isChecked;
	
	private Date createdUtc;
	
	private Date modifiedUtc;
	
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "note_id")
	private Notes notes;


	

	public ShoppingList getList() {
		return list;
	}

	public void setList(ShoppingList list) {
		this.list = list;
	}



	public Notes getNote() {
		return notes;
	}

	public void setNote(Notes notes) {
		this.notes = notes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
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
