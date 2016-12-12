package org.elevenfifty.shoppinglist.repositories;

import org.elevenfifty.shoppinglist.beans.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{

	User findOneByEmail(String email);
}
