package org.elevenfifty.shoppinglist.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.elevenfifty.shoppinglist.beans.UserRole;

public interface UserRoleRepository extends CrudRepository<UserRole, Long> {

	List<UserRole> findByUserId(long userId);
	
}
