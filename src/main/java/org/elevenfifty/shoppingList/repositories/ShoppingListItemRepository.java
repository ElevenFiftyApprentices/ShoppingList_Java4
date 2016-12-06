package org.elevenfifty.shoppingList.repositories;

import org.elevenfifty.shoppingList.beans.ShoppingList;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingListItemRepository extends CrudRepository<ShoppingList, Long> {
	

}
