package org.elevenfifty.shoppinglist.security;

import static org.elevenfifty.shoppinglist.security.Role.ROLE_ADMIN;
import static org.elevenfifty.shoppinglist.security.Role.ROLE_USER;
import static org.springframework.security.core.context.SecurityContextHolder.getContext;

import java.util.List;

import org.elevenfifty.shoppinglist.beans.ShoppingList;
import org.elevenfifty.shoppinglist.beans.User;
import org.elevenfifty.shoppinglist.repositories.ShoppingListRepository;
import org.elevenfifty.shoppinglist.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;



@Service
public class PermissionService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ShoppingListRepository shoppingListRepo;

	private AbstractAuthenticationToken getToken() {
		return (AbstractAuthenticationToken) getContext().getAuthentication();
	}


	public long findCurrentUserId() {
		List<User> users = userRepository.findByEmail(getToken().getName());
		return users != null && !users.isEmpty() ? users.get(0).getId() : -1;
	}

	public long findCurrentShoppingListId() {
		List<ShoppingList> lists = shoppingListRepo.findByName(getToken().getName());
		return lists != null && !lists.isEmpty() ? lists.get(0).getId() : -1;
	}

	public boolean hasRole(Role role) {
		for (GrantedAuthority ga : getToken().getAuthorities()) {
			if (role.toString().equals(ga.getAuthority())) {
				return true;
			}
		}
		return false;
	}

	public boolean canAccessUser(long userId) {
		return hasRole(ROLE_ADMIN) || (hasRole(ROLE_USER) && findCurrentUserId() == userId);
	}

	public String getCurrentEmail() {
		return getToken().getName();
	}
	//retruns the token for the getname operator, this is linked to the email
	
	public User findCurrentUser() {
		List<User> users = userRepository.findByEmail(getToken().getName());
		return users != null && !users.isEmpty() ? users.get(0) : new User();
	}
	//find current user returns a new object while findcurrentuserbyid returns a value?
}
