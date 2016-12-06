package org.elevenfifty.shoppingList.repositories;

import org.elevenfifty.shoppingList.beans.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{

	User findOneByEmail(String name);
}
