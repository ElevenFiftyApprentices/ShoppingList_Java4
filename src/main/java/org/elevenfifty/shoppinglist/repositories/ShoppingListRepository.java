package org.elevenfifty.shoppinglist.repositories;

import java.util.List;

import org.elevenfifty.shoppinglist.beans.ShoppingList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.users.beans.Contact;
import com.users.beans.User;

@Repository
public interface ShoppingListRepository extends CrudRepository<ShoppingList, Long> {

	ShoppingList findByUserIdAndId(long userId, long id);
	
	List<ShoppingList> findByName(String name);
	
	List<ShoppingList> findAllByUserIdOrderByFirstNameAscLastNameAsc(long UserId);

}
