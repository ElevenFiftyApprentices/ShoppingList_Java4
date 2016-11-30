package org.elevenfifty.shoppinglist.repositories;

import java.util.List;

import org.elevenfifty.shoppinglist.beans.User;
import org.springframework.data.repository.CrudRepository;



public interface UserRepository extends CrudRepository<User, Long> {


	List<User> findByEmail(String email);

	List<User> findAllByOrderByFirstNameAscLastNameAsc();


}