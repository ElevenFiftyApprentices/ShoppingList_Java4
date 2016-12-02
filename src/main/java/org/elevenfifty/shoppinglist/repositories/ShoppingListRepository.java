package org.elevenfifty.shoppinglist.repositories;

import java.util.List;

import org.elevenfifty.shoppinglist.beans.ShoppingList;
import org.elevenfifty.shoppinglist.beans.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface ShoppingListRepository extends CrudRepository<ShoppingList, Long> {

<<<<<<< HEAD
=======
	ShoppingList findByUserIdAndId(long userId, long id);
	
	List<User> findByEmail( String email);
	
<<<<<<< HEAD
	List<ShoppingList> findAllById(long id);
=======
	List<ShoppingList> findAllByUserIdOrderByFirstNameAscLastNameAsc(long UserId);
>>>>>>> 1a887e8e7df8bcb884c1216c1170de8e4e9365cd
>>>>>>> 8c5976689b1b69c2c90022be6a96ade273cb09de

}
