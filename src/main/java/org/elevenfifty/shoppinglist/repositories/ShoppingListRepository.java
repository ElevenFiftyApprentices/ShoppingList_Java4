package org.elevenfifty.shoppinglist.repositories;

import java.util.List;

import org.elevenfifty.shoppinglist.beans.ShoppingList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.users.beans.Contact;
import com.users.beans.User;

@Repository
public interface ShoppingListRepository extends CrudRepository<ShoppingList, Long> {

<<<<<<< HEAD
=======
	ShoppingList findByUserIdAndId(long userId, long id);
	
	List<ShoppingList> findByName(String name);
	
	List<ShoppingList> findAllByUserIdOrderByFirstNameAscLastNameAsc(long UserId);
>>>>>>> 1a887e8e7df8bcb884c1216c1170de8e4e9365cd

}
