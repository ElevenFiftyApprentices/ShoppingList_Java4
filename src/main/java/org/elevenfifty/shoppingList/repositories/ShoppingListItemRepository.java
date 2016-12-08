package org.elevenfifty.shoppinglist.repositories;

import org.elevenfifty.shoppinglist.beans.ShoppingListItem;
import org.springframework.data.repository.CrudRepository;



public interface ShoppingListItemRepository extends CrudRepository<ShoppingListItem, Long> {
	
	ShoppingListItem findByShoppingListIdAndId(long shoppingListId, long id);
}
