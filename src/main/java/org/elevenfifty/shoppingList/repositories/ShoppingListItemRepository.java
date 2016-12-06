package org.elevenfifty.shoppinglist.repositories;

import org.elevenfifty.shoppinglist.beans.ShoppingList;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingListItemRepository extends CrudRepository<ShoppingList, Long> {
	

}
