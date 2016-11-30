package org.elevenfifty.shoppinglist.repositories;

import org.elevenfifty.shoppinglist.beans.ShoppingList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingListRepository extends CrudRepository<ShoppingList, Long> {

}
