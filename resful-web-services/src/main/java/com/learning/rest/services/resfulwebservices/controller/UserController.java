package com.learning.rest.services.resfulwebservices.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.learning.rest.services.resfulwebservices.beans.Users;
import com.learning.rest.services.resfulwebservices.dao.UserDAOService;
import com.learning.rest.services.resfulwebservices.exceptions.UserNotFoundException;

import jakarta.validation.Valid;

/**
 *
 * @author Pattabhi
 */
@RestController
public class UserController {
	@Autowired
	private UserDAOService usrSrvc;

	@GetMapping("/find-all-users")
	public List<Users> getAllUsers() {
		return usrSrvc.findAll();
	}

	@GetMapping("/find-users/{id}")
	public Users getUsers(@PathVariable int id) {
		Users usr = usrSrvc.findOne(id);
		if(usr==null) {
			throw new UserNotFoundException("User not found");
		}
		return usrSrvc.findOne(id);
	}

	@GetMapping("/v1/find-users/{id}")
	public Users getUsersWithURI(@PathVariable int id) {
		Users usr = usrSrvc.findOne(id);
		if (usr == null) {
			throw new UserNotFoundException("User not found");
		}
		return usrSrvc.findOne(id);
	}
	/**
	 * Request parameter versioning
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(path = "/find-users/version/{id}", params = "version=1")
	public Users getUsersWithParam(@PathVariable int id) {
		Users usr = usrSrvc.findOne(id);
		if(usr==null) {
			throw new UserNotFoundException("User not found");
		}
		return usrSrvc.findOne(id);
	}

	/**
	 * custom header versioning
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(path = "/find-users/header/{id}", headers = "X-API-VERSION=1")
	public Users getUsersWithHeader(@PathVariable int id) {
		Users usr = usrSrvc.findOne(id);
		if (usr == null) {
			throw new UserNotFoundException("User not found");
		}
		return usrSrvc.findOne(id);
	}

	/**
	 * mediatyp versioning
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(path = "/find-users/accept/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Users getUsersWithMedia(@PathVariable int id) {
		Users usr = usrSrvc.findOne(id);
		if (usr == null) {
			throw new UserNotFoundException("User not found");
		}
		return usrSrvc.findOne(id);
	}

	@PostMapping("/save-users")
	public ResponseEntity<Users> saveUsers(@Valid @RequestBody Users usr) {
		Users svdUsr = usrSrvc.save(usr);

		URI location = ServletUriComponentsBuilder.fromPath("/find-users/{id}").buildAndExpand(svdUsr.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/delete-users/{id}")
	public List<Users> deleteUsers(@PathVariable int id) {
		return usrSrvc.delete(id);
	}
}
