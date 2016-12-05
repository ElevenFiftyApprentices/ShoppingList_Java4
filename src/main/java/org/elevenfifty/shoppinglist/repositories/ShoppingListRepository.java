package org.elevenfifty.shoppinglist.repositories;

import java.util.List;

import org.elevenfifty.shoppinglist.beans.ShoppingList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface ShoppingListRepository extends CrudRepository<ShoppingList, Long> {

	ShoppingList findByUserIdAndId(long userId, long id);
	
<<<<<<< HEAD
	List<User> findByEmail(String email);
	
=======
>>>>>>> 7722dff870ffc0493908dc1bf5ff93d1c0548d06
	List<ShoppingList> findAllById(long id);

}
