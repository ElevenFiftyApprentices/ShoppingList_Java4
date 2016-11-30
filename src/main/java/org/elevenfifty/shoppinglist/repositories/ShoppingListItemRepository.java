package org.elevenfifty.shoppinglist.repositories;

import java.util.List;

import org.elevenfifty.shoppinglist.beans.ShoppingListItem;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingListItemRepository extends CrudRepository<ShoppingListItem, Long> {

	ShoppingListItem findByShoppingListIdAndId(long shoppingListId, long id);
	
	List<ShoppingListItem> findAllByShoppingListIdOrderByPriorityAscContentsAsc(long shoppingListId);

	List<ShoppingListItem> findByShoppingListItemId(long shoppingListItemId);
	
	
}
