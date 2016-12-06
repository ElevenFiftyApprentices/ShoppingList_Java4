package org.elevenfifty.shoppinglist.repositories;

import java.util.List;

import org.elevenfifty.shoppinglist.beans.ShoppingList;
import org.elevenfifty.shoppinglist.beans.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface ShoppingListRepository extends CrudRepository<ShoppingList, Long> {

	ShoppingList findByUserIdAndId(long userId, long id);
	
	List<User> findByEmail(String email);
	
	List<ShoppingList> findAllById(long id);

}
