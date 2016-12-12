package org.elevenfifty.shoppinglist.repositories;

import java.util.List;

import org.elevenfifty.shoppinglist.beans.ShoppingList;
import org.elevenfifty.shoppinglist.beans.ShoppingListItem;
import org.springframework.data.repository.CrudRepository;



public interface ShoppingListItemRepository extends CrudRepository<ShoppingListItem, Long> {
	
	List <ShoppingListItem> findByShoppingListOrderByContentsAsc(ShoppingList shoppingList);
	
	
}
