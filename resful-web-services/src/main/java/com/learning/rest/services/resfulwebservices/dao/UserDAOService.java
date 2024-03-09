package com.learning.rest.services.resfulwebservices.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.learning.rest.services.resfulwebservices.beans.Users;

/**
 *
 * @author Pattabhi
 */
@Component
public class UserDAOService {

	private static List<Users> users = new ArrayList<>();
	static {
		users.add(new Users(1, "Pattabhi", LocalDate.now().minusYears(39)));
		users.add(new Users(2, "Sravani", LocalDate.now().minusYears(39)));
		users.add(new Users(3, "Janaki Ramu", LocalDate.now().minusYears(11)));
		users.add(new Users(4, "Juhitha", LocalDate.now().minusYears(8)));
	}

	public List<Users> findAll() {
		return users;
	}

	public Users findOne(int id) {
		return (Users) users.stream().filter(usr -> usr.getId() == id).findFirst().orElse(null);
	}

	public Users save(final Users usr) {
		users.add(usr);
		return usr;
	}

	public List<Users> delete(final int id) {
		users.removeIf(usr -> (usr.getId() == id));
		return users;
	}
}
