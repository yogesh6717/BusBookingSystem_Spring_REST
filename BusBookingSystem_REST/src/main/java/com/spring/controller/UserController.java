package com.spring.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.beans.Bus;
import com.spring.beans.Suggestion;
import com.spring.beans.Ticket;
import com.spring.beans.User;
import com.spring.services.Services;

/**
 * Handles requests for the Employee service.
 */
@RequestMapping(value="/user")
@RestController
public class UserController {

	@Autowired
	private Services services;
	
	//create User
	@RequestMapping(value = "/userRegister", method = RequestMethod.POST)
	public User createUser(@RequestBody User user) {
		if(services.createUser(user)) {
			return user;
		}else {
			return null;
		}
	}
	//search User
	@RequestMapping(value = "/searchUser/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable("id") int userId) {
		return services.searchUser(userId);
	}

	//update User
	@RequestMapping(value = "/userUpdate", method = RequestMethod.PUT)
	public User createEmpl(@RequestBody User user) {
		if(services.updateUser(user)) {
			return user;
		}else {
			return null;
		}
	}
	
	
		
	
	//delete user
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public Boolean deleteUser(@RequestBody User user) {
		return services.deleteUser(user.getUserId(), user.getUserPassword());
	}

	//search Bus
	@RequestMapping(value = "/searchBus/{id}", method = RequestMethod.GET)
	public Bus getBus(@PathVariable("id") int busId) {
		return services.searchBus(busId);
	}

	//Login User
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public User loginUser(@RequestBody User user) {
		return services.loginUser(user.getUserId(), user.getUserPassword());

	}   

	//write Feedback
	@RequestMapping(value = "/feedback", method = RequestMethod.POST)
	public Boolean writeFeedback(@RequestBody Suggestion feed) {
		return services.giveFeedback(feed);
	}

	//book ticket
	@RequestMapping(value = "/bookTicket", method = RequestMethod.POST)
	public Ticket bookTicket(@RequestBody Ticket ticket) {
		return services.bookTicket(ticket);
	}

	//cancel ticket
	@RequestMapping(value = "/cancelTicket", method = RequestMethod.POST)
	public Boolean cancelTicket(@RequestBody Ticket ticket) {
		return services.cancelTicket(ticket.getBookingId());
	}
	
	
}