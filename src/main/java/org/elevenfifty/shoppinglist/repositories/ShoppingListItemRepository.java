package org.elevenfifty.shoppinglist.repositories;

import java.util.List;

import org.elevenfifty.shoppinglist.beans.ShoppingList;
import org.elevenfifty.shoppinglist.beans.ShoppingListItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingListItemRepository extends CrudRepository<ShoppingListItem, Long> {
	
	ShoppingList findByShoppingListIdAndId(long userId, long id);
	
	List<ShoppingList> findByName(String name);

	List<ShoppingListItem> findAllByShoppingListIdOrderByPriotyAscContentsAsc(long shoppingListId);
	
	
}
