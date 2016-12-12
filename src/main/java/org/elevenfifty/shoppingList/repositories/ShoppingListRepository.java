package org.elevenfifty.shoppinglist.repositories;


import java.util.List;

import org.elevenfifty.shoppinglist.beans.ShoppingList;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingListRepository extends CrudRepository<ShoppingList, Long>{
	
	List <ShoppingList> findByNameContainsAllIgnoreCase(String namePart);

}
